package com.yoshi.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.yoshi.webapp.dto.Dictionary;
import com.yoshi.webapp.dto.PhraseDictionary;
import com.yoshi.webapp.dto.SentenceDicionary;
import com.yoshi.webapp.dto.VocabularyDictionary;
import com.yoshi.webapp.repository.PhraseDetailRepository;
import com.yoshi.webapp.repository.SentenceRepository;
import com.yoshi.webapp.repository.VocabularyRepository;

@Service
public class DictionaryServiceImpl implements DictionaryService {

	@Autowired
	private PhraseDetailRepository phraseDetailRepository;

	@Autowired
	private SentenceRepository sentenceRepository;

	@Autowired
	private VocabularyRepository vocabularyRepository;

	@Override
	public Dictionary findAll(String query, int page, int size) {
		if (page < 1)
			page = 1;
		if (size < 5)
			size = 5;
		Dictionary dictionary = new Dictionary();

		// query vocabulary
		List<VocabularyDictionary> vocabularyDictionaries = vocabularyRepository
				.search("%" + query + "%", PageRequest.of(page - 1, size)).getContent();

		// query phrase
		List<PhraseDictionary> phraseDictionaries = phraseDetailRepository
				.search("%" + query + "%", PageRequest.of(page - 1, size)).getContent();

		// query dictionary
		List<SentenceDicionary> sentenceDicionaries = sentenceRepository
				.search("%" + query + "%", PageRequest.of(page - 1, size)).getContent();

		dictionary.setVocabularyDictionaries(vocabularyDictionaries);
		dictionary.setPhraseDictionaries(phraseDictionaries);
		dictionary.setSentenceDicionaries(sentenceDicionaries);

		return dictionary;
	}

	@Override
	public Page<SentenceDicionary> findSentence(String query, int page, int size) {
		if (page < 1)
			page = 1;
		if (size < 5)
			size = 5;
		return sentenceRepository.search("%" + query + "%", PageRequest.of(page - 1, size));
	}

	@Override
	public Page<PhraseDictionary> findPhrase(String query, int page, int size) {
		if (page < 1)
			page = 1;
		if (size < 5)
			size = 5;
		return phraseDetailRepository.search("%" + query + "%", PageRequest.of(page - 1, size));
	}

	@Override
	public Page<VocabularyDictionary> findVocabulary(String query, int page, int size) {
		if (page < 1)
			page = 1;
		if (size < 5)
			size = 5;
		return vocabularyRepository.search("%" + query + "%", PageRequest.of(page - 1, size));
	}

}
