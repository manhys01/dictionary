package com.yoshi.webapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the word_type database table.
 * 
 */
@Entity
@Table(name="word_type")
@NamedQuery(name="WordType.findAll", query="SELECT w FROM WordType w")
public class WordType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="word_type_id", unique=true, nullable=false)
	private Integer id;

	@Column(name="word_type_description", length=1000)
	private String description;

	@Column(name="word_type_meaning", length=45)
	private String meaning;

	@Column(name="word_type_name", nullable=false, length=45)
	private String name;

	@OneToMany(mappedBy="wordType")
	private List<Vocabulary> vocabularies;

	public WordType() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMeaning() {
		return this.meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Vocabulary> getVocabularies() {
		return this.vocabularies;
	}

	public void setVocabularies(List<Vocabulary> vocabularies) {
		this.vocabularies = vocabularies;
	}

	public Vocabulary addVocabulary(Vocabulary vocabulary) {
		getVocabularies().add(vocabulary);
		vocabulary.setWordType(this);

		return vocabulary;
	}

	public Vocabulary removeVocabulary(Vocabulary vocabulary) {
		getVocabularies().remove(vocabulary);
		vocabulary.setWordType(null);

		return vocabulary;
	}

}