package io.github.lens0021.teogeul.input

import android.view.KeyEvent
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class LayoutConverterTest {
    private val converter = LayoutConverter()

    @Test
    fun convertKeyEventForShortcut_dvorakMapsPhysicalPToL() {
        val event =
            KeyEvent(
                0L,
                0L,
                KeyEvent.ACTION_DOWN,
                KeyEvent.KEYCODE_P,
                0,
                KeyEvent.META_CTRL_ON,
            )

        val converted = converter.convertKeyEventForShortcut(event, "keyboard_alphabet_dvorak")

        assertNotNull(converted)
        assertEquals(KeyEvent.KEYCODE_L, converted?.keyCode)
        assertEquals(KeyEvent.META_CTRL_ON, converted?.metaState)
    }

    @Test
    fun convertKeyEventForShortcut_qwertyDoesNotConvert() {
        val event = KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_L)

        val converted = converter.convertKeyEventForShortcut(event, "keyboard_alphabet_qwerty")

        assertNull(converted)
    }
}
