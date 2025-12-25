package io.github.lens0021.teogeul.event;

import io.github.lens0021.teogeul.KOKR.EngineMode;

public class EngineModeChangeEvent extends OpenWnnEvent {

	EngineMode engineMode;

	public EngineModeChangeEvent(EngineMode engineMode) {
		this.engineMode = engineMode;
	}

	public EngineMode getEngineMode() {
		return engineMode;
	}

}
