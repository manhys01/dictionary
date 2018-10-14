package com.yoshi.webapp.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vocabulary_specialization database table.
 * 
 */
@Entity
@Table(name="vocabulary_specialization")
@NamedQuery(name="VocabularySpecialization.findAll", query="SELECT v FROM VocabularySpecialization v")
public class VocabularySpecialization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="vocabulary_specialization_id", unique=true, nullable=false)
	private int id;

	@Column(name="vocabulary_specialization_description", length=1000)
	private String description;

	@Column(name="vocabulary_specialization_meaning", nullable=false, length=255)
	private String meaning;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="specialization_id", nullable=false)
	private Specialization specialization;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="vocabulary_id", nullable=false)
	private Vocabulary vocabulary;

	public VocabularySpecialization() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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

	public Specialization getSpecialization() {
		return this.specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	public Vocabulary getVocabulary() {
		return this.vocabulary;
	}

	public void setVocabulary(Vocabulary vocabulary) {
		this.vocabulary = vocabulary;
	}

}