package io.github.lens0021.teogeul.input

import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.BaseInputConnection
import io.github.lens0021.teogeul.korean.EngineMode
import io.github.lens0021.teogeul.korean.HangulEngine
import io.github.lens0021.teogeul.model.KeyMappings
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class KeyEventHandlerTest {
    private class CapturingInputConnection :
        BaseInputConnection(View(RuntimeEnvironment.getApplication()), true) {
        var lastEvent: KeyEvent? = null

        override fun sendKeyEvent(event: KeyEvent): Boolean {
            lastEvent = event
            return true
        }
    }

    @Test
    fun processKeyEvent_ctrlUsesLayoutConversion() {
        val inputConnection = CapturingInputConnection()
        val handler = buildHandler(inputConnection)

        val event =
            KeyEvent(
                0L,
                0L,
                KeyEvent.ACTION_DOWN,
                KeyEvent.KEYCODE_P,
                0,
                KeyEvent.META_CTRL_ON,
            )

        val handled = handler.processKeyEvent(event)

        assertTrue(handled)
        assertNotNull(inputConnection.lastEvent)
        assertEquals(KeyEvent.KEYCODE_L, inputConnection.lastEvent?.keyCode)
        assertEquals(KeyEvent.META_CTRL_ON, inputConnection.lastEvent?.metaState)
    }

    @Test
    fun processKeyEvent_altOrMetaUsesLayoutConversion() {
        val inputConnection = CapturingInputConnection()
        val handler = buildHandler(inputConnection)

        val altEvent =
            KeyEvent(
                0L,
                0L,
                KeyEvent.ACTION_DOWN,
                KeyEvent.KEYCODE_P,
                0,
                KeyEvent.META_ALT_ON,
            )
        val metaEvent =
            KeyEvent(
                0L,
                0L,
                KeyEvent.ACTION_DOWN,
                KeyEvent.KEYCODE_P,
                0,
                KeyEvent.META_META_ON,
            )

        assertTrue(handler.processKeyEvent(altEvent))
        assertEquals(KeyEvent.KEYCODE_L, inputConnection.lastEvent?.keyCode)
        assertEquals(KeyEvent.META_ALT_ON, inputConnection.lastEvent?.metaState)

        assertTrue(handler.processKeyEvent(metaEvent))
        assertEquals(KeyEvent.KEYCODE_L, inputConnection.lastEvent?.keyCode)
        assertEquals(KeyEvent.META_META_ON, inputConnection.lastEvent?.metaState)
    }

    @Test
    fun processKeyEvent_shiftKeyDoesNotBreakComposition() {
        val inputConnection = TestInputConnection()
        val hangulEngine = HangulEngine()

        // 두벌식 표준 레이아웃 일부 설정
        // HangulEngine의 inputCode는 lowercase char code를 받음
        hangulEngine.jamoTable =
            arrayOf(
                intArrayOf('r'.code, 0x3131, 0x3132), // ㄱ (no shift), ㄲ (shift)
                intArrayOf('f'.code, 0x314f, 0x3151), // ㅏ (no shift), ㅑ (shift)
            )

        // 두벌식에서 ㅘ 같은 조합을 위한 테이블
        hangulEngine.setCombinationTable(
            arrayOf(
                // 초성 조합
                intArrayOf(0x3131, 0x3131, 0x3132), // ㄱ + ㄱ = ㄲ
                // 중성 조합
                intArrayOf(0x314f, 0x3151, 0x3151), // ㅏ + ㅑ -> ㅑ
            ),
        )

        // Set up listener to update InputConnection
        hangulEngine.listener =
            object : HangulEngine.HangulEngineListener {
                override fun onEvent(event: HangulEngine.HangulEngineEvent) {
                    when (event) {
                        is HangulEngine.SetComposingEvent -> {
                            inputConnection.setComposingText(event.composing, 1)
                        }
                        is HangulEngine.FinishComposingEvent -> {
                            inputConnection.finishComposingText()
                        }
                    }
                }
            }

        val handler = buildHandler(inputConnection, hangulEngine)

        // 1. 'r' 키 입력 (shift 없음) → "ㄱ" 조합 시작
        val rEvent =
            KeyEvent(
                0L,
                0L,
                KeyEvent.ACTION_DOWN,
                KeyEvent.KEYCODE_R,
                0,
                0, // no shift
            )
        handler.processKeyEvent(rEvent)
        assertEquals("ㄱ", inputConnection.lastComposingText)

        // 2. Shift DOWN 이벤트 - 조합이 끊어지면 안됨!
        val shiftDownEvent =
            KeyEvent(
                0L,
                0L,
                KeyEvent.ACTION_DOWN,
                KeyEvent.KEYCODE_SHIFT_LEFT,
                0,
                KeyEvent.META_SHIFT_LEFT_ON,
            )
        val shiftHandled = handler.processKeyEvent(shiftDownEvent)

        // Shift 단독 이벤트는 무시되어야 함 (false 반환)
        assertEquals(false, shiftHandled)

        // Shift 단독 이벤트로 조합이 끊어지지 않아야 함
        // (만약 끊어진다면 finishComposingText가 호출되어 lastCommittedText에 들어감)
        assertEquals("", inputConnection.lastCommittedText) // 커밋되면 안됨
        assertEquals("ㄱ", inputConnection.lastComposingText) // 조합 유지되어야 함

        // 3. 'f' 키를 Shift와 함께 입력 → "ㅑ" 입력되어 "갸" 완성
        val fEventWithShift =
            KeyEvent(
                0L,
                0L,
                KeyEvent.ACTION_DOWN,
                KeyEvent.KEYCODE_F,
                0,
                KeyEvent.META_SHIFT_LEFT_ON or KeyEvent.META_SHIFT_ON,
            )
        handler.processKeyEvent(fEventWithShift)

        // "갸"가 조합되어야 함
        assertEquals("갸", inputConnection.lastComposingText)

        // 4. Shift UP 이벤트 - 조합이 여전히 유지되어야 함
        val shiftUpEvent =
            KeyEvent(
                0L,
                0L,
                KeyEvent.ACTION_UP,
                KeyEvent.KEYCODE_SHIFT_LEFT,
                0,
                0,
            )
        val shiftUpHandled = handler.processKeyEvent(shiftUpEvent)

        // Shift 단독 이벤트는 무시되어야 함
        assertEquals(false, shiftUpHandled)

        // 조합이 여전히 유지되어야 함
        assertEquals("갸", inputConnection.lastComposingText)
    }

    private class TestInputConnection : BaseInputConnection(View(RuntimeEnvironment.getApplication()), true) {
        var lastCommittedText: String = ""
        var lastComposingText: String = ""

        override fun commitText(
            text: CharSequence?,
            newCursorPosition: Int,
        ): Boolean {
            lastCommittedText = text?.toString() ?: ""
            return true
        }

        override fun setComposingText(
            text: CharSequence?,
            newCursorPosition: Int,
        ): Boolean {
            lastComposingText = text?.toString() ?: ""
            return true
        }

        override fun finishComposingText(): Boolean {
            if (lastComposingText.isNotEmpty()) {
                lastCommittedText = lastComposingText
                lastComposingText = ""
            }
            return true
        }
    }

    private fun buildHandler(inputConnection: CapturingInputConnection): KeyEventHandler =
        buildHandler(inputConnection, HangulEngine())

    private fun buildHandler(
        inputConnection: BaseInputConnection,
        hangulEngine: HangulEngine,
    ): KeyEventHandler =
        KeyEventHandler(
            layoutConverter = LayoutConverter(),
            inputConnectionProvider = { inputConnection },
            hangulEngineProvider = { hangulEngine },
            directInputModeProvider = { false },
            alphabetLayoutProvider = { "keyboard_alphabet_dvorak" },
            hardLangKeyProvider = { null },
            keyMappingsProvider = { KeyMappings.EMPTY },
            currentLanguageProvider = { EngineMode.LANG_EN },
            toggleLanguage = {},
            resetCharComposition = { hangulEngine.resetComposition() },
            currentInputEditorInfoProvider = { null },
            sendDefaultEditorAction = {},
            markInput = {},
            sendKeyEvent = { inputConnection.sendKeyEvent(it) },
            openIMEPicker = {},
        )
}
