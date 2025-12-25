package io.github.lens0021.teogeul.event;

public class InputCharEvent extends OpenWnnEvent {
	private char code;

	public InputCharEvent(char code) {
		this.code = code;
	}

	public char getCode() {
		return code;
	}

}
