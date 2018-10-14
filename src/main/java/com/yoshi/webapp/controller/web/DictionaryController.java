package com.yoshi.webapp.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yoshi.webapp.dto.Dictionary;
import com.yoshi.webapp.dto.PhraseDictionary;
import com.yoshi.webapp.dto.SentenceDicionary;
import com.yoshi.webapp.dto.VocabularyDictionary;
import com.yoshi.webapp.service.DictionaryService;
import com.yoshi.webapp.util.pagination.Pagination;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {

	@Autowired
	private DictionaryService dictionaryService;

	@GetMapping
	public String find(@RequestParam("query") String query, @RequestParam("entity") String entity,
			@RequestParam(name = "page", defaultValue = "1") Integer page, Model model) {
		
		if (entity == null || entity.isEmpty())
			entity = "all";
		
		entity = entity.trim();
		model.addAttribute("entity", entity);

		switch (entity) {
		
		case "vocabulary":
			Page<VocabularyDictionary> vocabularyPages = dictionaryService.findVocabulary(query, page, 10);
			
			model.addAttribute("vocabularies", vocabularyPages.getContent());
			model.addAttribute("pagination", new Pagination(vocabularyPages.getTotalPages(), 5, page));
			return "dictionary/vocabulary";

		case "sentence":
			Page<SentenceDicionary> sentencePages = dictionaryService.findSentence(query, page, 10);
			model.addAttribute("sentences", sentencePages.getContent());
			model.addAttribute("pagination", new Pagination(sentencePages.getTotalPages(), 5, page));
			return "dictionary/sentence";
			
		case "phrase":
			Page<PhraseDictionary> phrasePages = dictionaryService.findPhrase(query, page, 10);
			model.addAttribute("phrases", phrasePages.getContent());
			model.addAttribute("pagination", new Pagination(phrasePages.getTotalPages(), 5, page));
			return "dictionary/phrase";

		default:
			Dictionary dictionary = dictionaryService.findAll(query, page, 20);
			model.addAttribute("dictionary", dictionary);
			return "dictionary/all";
		}

	}

}
