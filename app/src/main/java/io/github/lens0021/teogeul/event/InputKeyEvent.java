package io.github.lens0021.teogeul.event;

import android.view.KeyEvent;

public class InputKeyEvent extends OpenWnnEvent {

	private KeyEvent keyEvent;

	public InputKeyEvent(KeyEvent keyEvent) {
		this.keyEvent = keyEvent;
	}

	public KeyEvent getKeyEvent() {
		return keyEvent;
	}

}
