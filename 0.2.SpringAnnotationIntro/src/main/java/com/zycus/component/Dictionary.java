package com.zycus.component;

import org.springframework.stereotype.Component;

@Component
public class Dictionary implements DictionaryInterface{
	
	public boolean checkWord(String word) {
		return true;
	}
}
