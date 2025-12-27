package io.github.lens0021.teogeul.input

import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.BaseInputConnection
import io.github.lens0021.teogeul.korean.EngineMode
import io.github.lens0021.teogeul.korean.HangulEngine
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

    private fun buildHandler(inputConnection: CapturingInputConnection): KeyEventHandler {
        return KeyEventHandler(
            layoutConverter = LayoutConverter(),
            inputConnectionProvider = { inputConnection },
            hangulEngineProvider = { HangulEngine() },
            directInputModeProvider = { false },
            alphabetLayoutProvider = { "keyboard_alphabet_dvorak" },
            hardLangKeyProvider = { null },
            currentLanguageProvider = { EngineMode.LANG_EN },
            toggleLanguage = {},
            resetCharComposition = {},
            currentInputEditorInfoProvider = { null },
            sendDefaultEditorAction = {},
            markInput = {},
        )
    }
}
