package com.jcabero.xkcdgag.comment.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY)
@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_COMMENT")
	private Long id;

	@JsonProperty("date")
	@Column(name="DATE")
	private Date date;

	@JsonProperty("idGag")
	@Column(name="ID_GAG")
	private Long idGag;

	@JsonProperty("text")
	@Column(name="TEXT")
	private String text;
	
	@ManyToOne
	@JoinColumn( name = "ID_GAG", insertable=false, updatable=false)
	private Gag gag;

	public Comment() {}
	
	public Comment(Long id, Date date, Long idGag, String text) {
		super();
		this.id = id;
		this.date = date;
		this.idGag = idGag;
		this.text = text;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getIdGag() {
		return idGag;
	}

	public void setIdGag(Long idGag) {
		this.idGag = idGag;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Gag getGag() {
		return gag;
	}

	public void setGag(Gag gag) {
		this.gag = gag;
	}
}
