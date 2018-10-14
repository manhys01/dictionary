package com.yoshi.webapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="specialization")
@NamedQuery(name="Specialization.findAll", query="SELECT s FROM Specialization s")
public class Specialization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="specialization_id", unique=true, nullable=false)
	private Integer id;

	@Column(name="specialization_name", nullable=false, length=255)
	private String name;

	@OneToMany(mappedBy="specialization")
	private List<VocabularySpecialization> vocabularySpecializations;

	public Specialization() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setID(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<VocabularySpecialization> getVocabularySpecializations() {
		return this.vocabularySpecializations;
	}

	public void setVocabularySpecializations(List<VocabularySpecialization> vocabularySpecializations) {
		this.vocabularySpecializations = vocabularySpecializations;
	}

	public VocabularySpecialization addVocabularySpecialization(VocabularySpecialization vocabularySpecialization) {
		getVocabularySpecializations().add(vocabularySpecialization);
		vocabularySpecialization.setSpecialization(this);

		return vocabularySpecialization;
	}

	public VocabularySpecialization removeVocabularySpecialization(VocabularySpecialization vocabularySpecialization) {
		getVocabularySpecializations().remove(vocabularySpecialization);
		vocabularySpecialization.setSpecialization(null);

		return vocabularySpecialization;
	}

}