package com.yoshi.webapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yoshi.webapp.dto.PhraseDictionary;
import com.yoshi.webapp.model.PhraseDetail;

public interface PhraseDetailRepository extends JpaRepository<PhraseDetail, Long> {

	@Query("SELECT new com.yoshi.webapp.dto.PhraseDictionary(p.id, p.phrase.text, p.meaning) FROM PhraseDetail p")
	Page<PhraseDictionary> getAll(Pageable pageable);

	@Query("SELECT new com.yoshi.webapp.dto.PhraseDictionary(p.id, p.phrase.text, p.meaning) "
			+ "FROM PhraseDetail p WHERE p.phrase.text like :query OR p.meaning like :query")
	Page<PhraseDictionary> search(@Param("query") String query, Pageable pageable);

}
