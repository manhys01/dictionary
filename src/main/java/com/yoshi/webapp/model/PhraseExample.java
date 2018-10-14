package com.yoshi.webapp.model;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="phrase_example")
@NamedQuery(name="PhraseExample.findAll", query="SELECT p FROM PhraseExample p")
public class PhraseExample implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="phrase_example_id", unique=true, nullable=false)
	private Long id;

	//bi-directional many-to-one association to PhraseDetail
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="phrase_detail_id", nullable=false)
	private PhraseDetail phraseDetail;

	//bi-directional many-to-one association to Sentence
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sentence_id", nullable=false)
	private Sentence sentence;

	public PhraseExample() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PhraseDetail getPhraseDetail() {
		return this.phraseDetail;
	}

	public void setPhraseDetail(PhraseDetail phraseDetail) {
		this.phraseDetail = phraseDetail;
	}

	public Sentence getSentence() {
		return this.sentence;
	}

	public void setSentence(Sentence sentence) {
		this.sentence = sentence;
	}

}