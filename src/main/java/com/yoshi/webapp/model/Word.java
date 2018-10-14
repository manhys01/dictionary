package com.yoshi.webapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the word database table.
 * 
 */
@Entity
@Table(name="word")
@NamedQuery(name="Word.findAll", query="SELECT w FROM Word w")
public class Word implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="word_id", unique=true, nullable=false)
	private Integer id;

	@Column(name="audio_path", length=255)
	private String path;

	@Column(name="word_ipa", length=255)
	private String ipa;

	@Column(name="word_text", nullable=false, length=255)
	private String text;

	@OneToMany(mappedBy="word")
	private List<Vocabulary> vocabularies;

	public Word() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getIpa() {
		return this.ipa;
	}

	public void setIpa(String ipa) {
		this.ipa = ipa;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Vocabulary> getVocabularies() {
		return this.vocabularies;
	}

	public void setVocabularies(List<Vocabulary> vocabularies) {
		this.vocabularies = vocabularies;
	}

	public Vocabulary addVocabulary(Vocabulary vocabulary) {
		getVocabularies().add(vocabulary);
		vocabulary.setWord(this);

		return vocabulary;
	}

	public Vocabulary removeVocabulary(Vocabulary vocabulary) {
		getVocabularies().remove(vocabulary);
		vocabulary.setWord(null);

		return vocabulary;
	}

}