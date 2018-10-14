package com.yoshi.webapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="phrase_detail")
@NamedQuery(name="PhraseDetail.findAll", query="SELECT p FROM PhraseDetail p")
public class PhraseDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="phrase_detail_id", unique=true, nullable=false)
	private Long id;

	@Column(name="phrase_description", length=1000)
	private String description;

	@Column(name="phrase_meaning", nullable=false, length=255)
	private String meaning;

	@Column(name="phrase_note", length=1000)
	private String mote;

	@Column(name="phrase_synonyms", length=1000)
	private String synonyms;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="phrase_id", nullable=false)
	private Phrase phrase;

	@OneToMany(mappedBy="phraseDetail")
	private List<PhraseExample> phraseExamples;

	public PhraseDetail() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
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

	public String getMote() {
		return this.mote;
	}

	public void setMote(String mote) {
		this.mote = mote;
	}

	public String getSynonyms() {
		return this.synonyms;
	}

	public void setSynonyms(String synonyms) {
		this.synonyms = synonyms;
	}

	public Phrase getPhrase() {
		return this.phrase;
	}

	public void setPhrase(Phrase phrase) {
		this.phrase = phrase;
	}

	public List<PhraseExample> getPhraseExamples() {
		return this.phraseExamples;
	}

	public void setPhraseExamples(List<PhraseExample> phraseExamples) {
		this.phraseExamples = phraseExamples;
	}

	public PhraseExample addPhraseExample(PhraseExample phraseExample) {
		getPhraseExamples().add(phraseExample);
		phraseExample.setPhraseDetail(this);

		return phraseExample;
	}

	public PhraseExample removePhraseExample(PhraseExample phraseExample) {
		getPhraseExamples().remove(phraseExample);
		phraseExample.setPhraseDetail(null);

		return phraseExample;
	}

}