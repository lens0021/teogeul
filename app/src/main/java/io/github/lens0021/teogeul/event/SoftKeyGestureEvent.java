package io.github.lens0021.teogeul.event;

public class SoftKeyGestureEvent extends OpenWnnEvent {

	private int keyCode;
	private Type type;

	public SoftKeyGestureEvent(int keyCode, Type type) {
		this.keyCode = keyCode;
		this.type = type;
	}

	public int getKeyCode() {
		return keyCode;
	}

	public Type getType() {
		return type;
	}

	public enum Type {
		SLIDE_LEFT, SLIDE_RIGHT, RELEASE;
	}

}
