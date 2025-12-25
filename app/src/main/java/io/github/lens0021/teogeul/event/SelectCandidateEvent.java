package io.github.lens0021.teogeul.event;

import io.github.lens0021.teogeul.KOKR.trie.TrieDictionary;
import io.github.lens0021.teogeul.WnnWord;

public class SelectCandidateEvent extends OpenWnnEvent {

	private WnnWord wnnWord;
	private TrieDictionary.Word word;

	public SelectCandidateEvent(WnnWord word) {
		this.wnnWord = word;
	}

	public SelectCandidateEvent(TrieDictionary.Word word) {
		this.word = word;
	}

	public WnnWord getWnnWord() {
		return wnnWord;
	}

	public TrieDictionary.Word getWord() {
		return word;
	}
}
