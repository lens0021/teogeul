package io.github.lens0021.teogeul.input

import android.text.method.MetaKeyKeyListener
import android.view.KeyEvent

class ModifierStateManager {
    companion object {
        @JvmField
        val SHIFT_CONVERT =
            arrayOf(
                intArrayOf(0x60, 0x7e),
                intArrayOf(0x31, 0x21),
                intArrayOf(0x32, 0x40),
                intArrayOf(0x33, 0x23),
                intArrayOf(0x34, 0x24),
                intArrayOf(0x35, 0x25),
                intArrayOf(0x36, 0x5e),
                intArrayOf(0x37, 0x26),
                intArrayOf(0x38, 0x2a),
                intArrayOf(0x39, 0x28),
                intArrayOf(0x30, 0x29),
                intArrayOf(0x2d, 0x5f),
                intArrayOf(0x3d, 0x2b),
                intArrayOf(0x5b, 0x7b),
                intArrayOf(0x5d, 0x7d),
                intArrayOf(0x5c, 0x7c),
                intArrayOf(0x3b, 0x3a),
                intArrayOf(0x27, 0x22),
                intArrayOf(0x2c, 0x3c),
                intArrayOf(0x2e, 0x3e),
                intArrayOf(0x2f, 0x3f),
            )
    }

    var hardShift: Int = 0
    var capsLock: Boolean = false
    var shiftOnCapsLock: Boolean = false

    var shiftPressing: Boolean = false

    private val shiftKeyToggle = intArrayOf(0, MetaKeyKeyListener.META_SHIFT_ON, MetaKeyKeyListener.META_CAP_LOCKED)

    fun getShiftMeta(): Int = shiftKeyToggle[hardShift]

    fun handleKeyUp(event: KeyEvent, updateDisplay: () -> Unit) {
        val key = event.keyCode
        if (key == KeyEvent.KEYCODE_SHIFT_LEFT || key == KeyEvent.KEYCODE_SHIFT_RIGHT) {
            shiftPressing = false
            if (shiftOnCapsLock) {
                hardShift = 2
                shiftOnCapsLock = false
            } else {
                hardShift = if (capsLock) 2 else 0
            }
            updateDisplay()
        }
        // Alt key is not handled by IME - let system handle it
    }

    fun handleShiftAndCapsKey(event: KeyEvent, updateDisplay: () -> Unit): Boolean {
        return when (event.keyCode) {
            KeyEvent.KEYCODE_SHIFT_LEFT, KeyEvent.KEYCODE_SHIFT_RIGHT -> {
                if (event.repeatCount == 0) {
                    if (capsLock) {
                        hardShift = 0
                        shiftOnCapsLock = true
                    } else {
                        hardShift = 1
                    }
                }
                shiftPressing = true
                updateDisplay()
                true
            }

            KeyEvent.KEYCODE_CAPS_LOCK -> {
                capsLock = !capsLock
                if (capsLock) {
                    hardShift = 2
                    shiftPressing = true
                } else {
                    hardShift = 0
                    shiftPressing = false
                }
                updateDisplay()
                true
            }

            else -> false
        }
    }

    fun syncCapsLockFromMeta(metaState: Int, updateDisplay: () -> Unit) {
        if (metaState and KeyEvent.META_CAPS_LOCK_ON != 0) {
            if (!shiftOnCapsLock) {
                capsLock = true
                hardShift = 2
                shiftPressing = true
                updateDisplay()
            }
        } else if (capsLock) {
            capsLock = false
            hardShift = 0
            shiftPressing = false
            updateDisplay()
        }
    }

    fun afterPrintingKey(isShiftPressed: Boolean, updateDisplay: () -> Unit) {
        if (!isShiftPressed && !capsLock && hardShift == 1) {
            hardShift = 0
            updateDisplay()
        }
    }

    fun resetHardShift(force: Boolean) {
        if (hardShift == 2 && !force) {
            return
        }
        hardShift = 0
        shiftPressing = false
    }

    fun shinShift(updateDisplay: () -> Unit) {
        updateDisplay()
    }
}
