package io.github.lens0021.teogeul.input

import android.view.KeyEvent

sealed class InputEvent {
    var isCancelled: Boolean = false
}

class InputKeyEvent(
    val keyEvent: KeyEvent,
) : InputEvent()

class KeyUpEvent(
    val keyEvent: KeyEvent,
) : InputEvent()

class InputTimeoutEvent : InputEvent()

class CommitComposingTextEvent : InputEvent()
