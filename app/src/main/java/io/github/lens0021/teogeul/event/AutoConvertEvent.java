package io.github.lens0021.teogeul.event;

import io.github.lens0021.teogeul.KOKR.trie.TrieDictionary;

public class AutoConvertEvent extends OpenWnnEvent {

	private TrieDictionary.Word candidate;

	public AutoConvertEvent(TrieDictionary.Word candidate) {
		this.candidate = candidate;
	}

	public TrieDictionary.Word getCandidate() {
		return candidate;
	}

}
