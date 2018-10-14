package com.yoshi.webapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="sentence")
@NamedQuery(name="Sentence.findAll", query="SELECT s FROM Sentence s")
public class Sentence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sentence_id", unique=true, nullable=false)
	private Long id;
	
	@Column(name="sentence_text", nullable=false, length=255)
	private String text;

	@Column(name="sentece_ipa", length=255)
	private String ipa;
	
	@Column(name="sentence_meaning", nullable=false, length=255)
	private String meaning;

	@Column(name="sentence_audio_path", length=1000)
	private String audioPath;

	@OneToMany(mappedBy="sentence")
	private List<PhraseExample> phraseExamples;

	@OneToMany(mappedBy="sentence")
	private List<VocabularyExample> vocabularyExamples;

	public Sentence() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIpa() {
		return this.ipa;
	}

	public void setIpa(String ipa) {
		this.ipa = ipa;
	}

	public String getAudioPath() {
		return this.audioPath;
	}

	public void setAudioPath(String audioPath) {
		this.audioPath = audioPath;
	}

	public String getMeaning() {
		return this.meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<PhraseExample> getPhraseExamples() {
		return this.phraseExamples;
	}

	public void setPhraseExamples(List<PhraseExample> phraseExamples) {
		this.phraseExamples = phraseExamples;
	}

	public PhraseExample addPhraseExample(PhraseExample phraseExample) {
		getPhraseExamples().add(phraseExample);
		phraseExample.setSentence(this);

		return phraseExample;
	}

	public PhraseExample removePhraseExample(PhraseExample phraseExample) {
		getPhraseExamples().remove(phraseExample);
		phraseExample.setSentence(null);

		return phraseExample;
	}

	public List<VocabularyExample> getVocabularyExamples() {
		return this.vocabularyExamples;
	}

	public void setVocabularyExamples(List<VocabularyExample> vocabularyExamples) {
		this.vocabularyExamples = vocabularyExamples;
	}

	public VocabularyExample addVocabularyExample(VocabularyExample vocabularyExample) {
		getVocabularyExamples().add(vocabularyExample);
		vocabularyExample.setSentence(this);

		return vocabularyExample;
	}

	public VocabularyExample removeVocabularyExample(VocabularyExample vocabularyExample) {
		getVocabularyExamples().remove(vocabularyExample);
		vocabularyExample.setSentence(null);

		return vocabularyExample;
	}

}