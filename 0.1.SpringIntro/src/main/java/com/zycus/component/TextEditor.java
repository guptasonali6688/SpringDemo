package com.zycus.component;

public class TextEditor implements TextEditorInterface {

	private SpellCheckerInterface spellCheckerInterface;
	
	//Setter Injection 
	public void setSpellCheckerInterface(SpellCheckerInterface spellCheckerInterface) {
		this.spellCheckerInterface = spellCheckerInterface;
	}
	
	public  void  load( String document) {
		System.out.println("loaded: "+document);
		//SpellCheckerInterface spellCheckerInterface = new SpellChecker();
		spellCheckerInterface.checkSpellingMistakes(document);
	}
}
