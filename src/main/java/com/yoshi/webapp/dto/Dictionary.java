package com.yoshi.webapp.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dictionary {
	
	private List<SentenceDicionary> sentenceDicionaries;
	private List<PhraseDictionary> phraseDictionaries;
	private List<VocabularyDictionary> vocabularyDictionaries;
	
}
