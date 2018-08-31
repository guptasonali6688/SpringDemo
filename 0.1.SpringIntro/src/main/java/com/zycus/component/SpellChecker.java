package com.zycus.component;

public class SpellChecker implements SpellCheckerInterface{	
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
