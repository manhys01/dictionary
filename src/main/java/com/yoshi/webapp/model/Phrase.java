package com.yoshi.webapp.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="phrase")
@NamedQuery(name="Phrase.findAll", query="SELECT p FROM Phrase p")
public class Phrase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="phrase_id", unique=true, nullable=false)
	private Long id;

	@Column(name="phrase_ipa", length=255)
	private String ipa;

	@Column(name="phrase_text", nullable=false, length=255)
	private String text;

	@OneToMany(mappedBy="phrase")
	private List<PhraseDetail> phraseDetails;

	public Phrase() {
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

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<PhraseDetail> getPhraseDetails() {
		return this.phraseDetails;
	}

	public void setPhraseDetails(List<PhraseDetail> phraseDetails) {
		this.phraseDetails = phraseDetails;
	}

	public PhraseDetail addPhraseDetail(PhraseDetail phraseDetail) {
		getPhraseDetails().add(phraseDetail);
		phraseDetail.setPhrase(this);

		return phraseDetail;
	}

	public PhraseDetail removePhraseDetail(PhraseDetail phraseDetail) {
		getPhraseDetails().remove(phraseDetail);
		phraseDetail.setPhrase(null);

		return phraseDetail;
	}

}