package com.yoshi.webapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="vocabulary")
@NamedQuery(name="Vocabulary.findAll", query="SELECT v FROM Vocabulary v")
public class Vocabulary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vocabulary_id", unique=true, nullable=false)
	private Long id;

	@Column(name="vocabulary_desciption", length=500)
	private String desciption;

	@Column(name="vocabulary_meaning", nullable=false, length=255)
	private String meaning;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="word_id", nullable=false)
	private Word word;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="word_type_id", nullable=false)
	private WordType wordType;

	@OneToMany(mappedBy="vocabulary")
	private List<VocabularyExample> vocabularyExamples;

	@OneToMany(mappedBy="vocabulary")
	private List<VocabularySpecialization> vocabularySpecializations;

	public Vocabulary() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesciption() {
		return this.desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public String getMeaning() {
		return this.meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public Word getWord() {
		return this.word;
	}

	public void setWord(Word word) {
		this.word = word;
	}

	public WordType getWordType() {
		return this.wordType;
	}

	public void setWordType(WordType wordType) {
		this.wordType = wordType;
	}

	public List<VocabularyExample> getVocabularyExamples() {
		return this.vocabularyExamples;
	}

	public void setVocabularyExamples(List<VocabularyExample> vocabularyExamples) {
		this.vocabularyExamples = vocabularyExamples;
	}

	public VocabularyExample addVocabularyExample(VocabularyExample vocabularyExample) {
		getVocabularyExamples().add(vocabularyExample);
		vocabularyExample.setVocabulary(this);

		return vocabularyExample;
	}

	public VocabularyExample removeVocabularyExample(VocabularyExample vocabularyExample) {
		getVocabularyExamples().remove(vocabularyExample);
		vocabularyExample.setVocabulary(null);

		return vocabularyExample;
	}

	public List<VocabularySpecialization> getVocabularySpecializations() {
		return this.vocabularySpecializations;
	}

	public void setVocabularySpecializations(List<VocabularySpecialization> vocabularySpecializations) {
		this.vocabularySpecializations = vocabularySpecializations;
	}

	public VocabularySpecialization addVocabularySpecialization(VocabularySpecialization vocabularySpecialization) {
		getVocabularySpecializations().add(vocabularySpecialization);
		vocabularySpecialization.setVocabulary(this);

		return vocabularySpecialization;
	}

	public VocabularySpecialization removeVocabularySpecialization(VocabularySpecialization vocabularySpecialization) {
		getVocabularySpecializations().remove(vocabularySpecialization);
		vocabularySpecialization.setVocabulary(null);

		return vocabularySpecialization;
	}

}