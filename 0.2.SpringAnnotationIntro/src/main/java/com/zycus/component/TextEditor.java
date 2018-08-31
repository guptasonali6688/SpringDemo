package com.zycus.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TextEditor implements TextEditorInterface {

	private SpellCheckerInterface spellCheckerInterface;
	
	@Autowired
	public void setSpellCheckerInterface(SpellCheckerInterface spellCheckerInterface) {
		this.spellCheckerInterface = spellCheckerInterface;
	}
	
	public  void  load( String document) {
		System.out.println("loaded: "+document);
		//SpellCheckerInterface spellCheckerInterface = new SpellChecker();
		spellCheckerInterface.checkSpellingMistakes(document);
	}
}
