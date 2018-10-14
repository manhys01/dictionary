package com.yoshi.webapp.service;

import org.springframework.data.domain.Page;

import com.yoshi.webapp.dto.Dictionary;
import com.yoshi.webapp.dto.PhraseDictionary;
import com.yoshi.webapp.dto.SentenceDicionary;
import com.yoshi.webapp.dto.VocabularyDictionary;

public interface DictionaryService {
	
	public Dictionary findAll(String query, int page, int size);
	
	public Page<SentenceDicionary> findSentence(String query, int page, int size);
	
	public Page<PhraseDictionary> findPhrase(String query, int page, int size);
	
	public Page<VocabularyDictionary> findVocabulary(String query, int page, int size);
	
}
