package io.github.lens0021.teogeul.event;

import android.view.KeyEvent;

public class InputSoftKeyEvent extends OpenWnnEvent {

	private KeyEvent keyEvent;

	public InputSoftKeyEvent(KeyEvent keyEvent) {
		this.keyEvent = keyEvent;
	}

	public KeyEvent getKeyEvent() {
		return keyEvent;
	}

}
