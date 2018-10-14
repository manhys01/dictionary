package com.yoshi.webapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yoshi.webapp.dto.VocabularyDictionary;
import com.yoshi.webapp.model.Vocabulary;

public interface VocabularyRepository extends JpaRepository<Vocabulary, Long> {

	@Query("SELECT new com.yoshi.webapp.dto.VocabularyDictionary(v.id, v.word.text, v.meaning) FROM Vocabulary v")
	Page<VocabularyDictionary> getAll(Pageable pageable);

	@Query("SELECT new com.yoshi.webapp.dto.VocabularyDictionary(v.id, v.word.text, v.meaning) "
			+ "FROM Vocabulary v WHERE v.word.text like :query OR v.meaning like :query")
	Page<VocabularyDictionary> search(@Param("query") String query, Pageable pageable);
	
}
