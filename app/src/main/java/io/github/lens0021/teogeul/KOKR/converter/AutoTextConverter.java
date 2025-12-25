package io.github.lens0021.teogeul.KOKR.converter;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.github.lens0021.teogeul.KOKR.ComposingWord;
import io.github.lens0021.teogeul.KOKR.EngineMode;
import io.github.lens0021.teogeul.KOKR.WordConverter;
import io.github.lens0021.teogeul.KOKR.trie.TrieDictionary;
import io.github.lens0021.teogeul.event.DisplayCandidatesEvent;

public class AutoTextConverter implements WordConverter {

	private Map<String, String> autoTexts;

	public AutoTextConverter(Map<String, String> autoTexts) {
		this.autoTexts = autoTexts;
	}

	@Override
	public void convert(ComposingWord word) {
		List<TrieDictionary.Word> result = new ArrayList<>();
		String str = autoTexts.get(word.getEntireWord());
		if(str != null) {
			result.add(new TrieDictionary.Word(str, 1));
		}
		EventBus.getDefault().post(new DisplayCandidatesEvent(result, 0));
	}

	@Override
	public void setEngineMode(EngineMode engineMode) {

	}
}
