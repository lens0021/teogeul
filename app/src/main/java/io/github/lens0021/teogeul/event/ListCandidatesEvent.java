package io.github.lens0021.teogeul.event;

public class ListCandidatesEvent extends OpenWnnEvent {

	private boolean full;

	public ListCandidatesEvent(boolean full) {
		this.full = full;
	}

	public boolean isFull() {
		return full;
	}

}
