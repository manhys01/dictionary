package com.yoshi.webapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yoshi.webapp.dto.SentenceDicionary;
import com.yoshi.webapp.model.Sentence;

public interface SentenceRepository extends JpaRepository<Sentence, Long> {

	@Query("SELECT new com.yoshi.webapp.dto.SentenceDicionary(s.id, s.text, s.meaning) FROM Sentence s")
	Page<SentenceDicionary> getAll(Pageable pageable);

	@Query("SELECT new com.yoshi.webapp.dto.SentenceDicionary(s.id, s.text, s.meaning) "
			+ "FROM Sentence s WHERE s.text like :query OR s.meaning like :query")
	Page<SentenceDicionary> search(@Param("query") String query, Pageable pageable);

}
