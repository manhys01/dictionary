package com.yoshi.webapp.model;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="vocabulary_example")
@NamedQuery(name="VocabularyExample.findAll", query="SELECT v FROM VocabularyExample v")
public class VocabularyExample implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vocabulary_example_id", unique=true, nullable=false)
	private Long id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sentence_id", nullable=false)
	private Sentence sentence;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="vocabulary_id", nullable=false)
	private Vocabulary vocabulary;

	public VocabularyExample() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Sentence getSentence() {
		return this.sentence;
	}

	public void setSentence(Sentence sentence) {
		this.sentence = sentence;
	}

	public Vocabulary getVocabulary() {
		return this.vocabulary;
	}

	public void setVocabulary(Vocabulary vocabulary) {
		this.vocabulary = vocabulary;
	}

}