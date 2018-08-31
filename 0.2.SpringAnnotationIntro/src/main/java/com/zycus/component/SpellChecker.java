package com.zycus.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpellChecker implements SpellCheckerInterface{	
	@Autowired
	private DictionaryInterface dictionaryInterface;
		
	public void setDictionaryInterface(DictionaryInterface dictionaryInterface) {
		this.dictionaryInterface = dictionaryInterface;
	}
	
	public void checkSpellingMistakes(String document) {
		System.out.println("Checking spelling mistakes :"+document);
		//DictionaryInterface dictionaryInterface = new Dictionary();
		dictionaryInterface.checkWord(document);
	}
}
