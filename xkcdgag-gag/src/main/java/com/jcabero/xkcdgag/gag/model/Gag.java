package com.jcabero.xkcdgag.gag.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY)
@Entity
public class Gag {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_GAG")
	private Long id;

	@JsonProperty("number")
	@Column(name="NUM_GAG")
	private Long number;
	
	@Column(name="IMG_URL")
	private String imgUrl;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="LIKES")
	private Long likes;
	
	@OneToMany(mappedBy="gag")
	private List<Comment> comments;
	
	public Gag() {}
	
	public Gag(Long number, String imgUrl, String title, Long likes) {
		this.number = number;
		this.imgUrl = imgUrl;
		this.title = title;
		this.likes = likes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getLikes() {
		return likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComment(List<Comment> comments) {
		this.comments = comments;
	}
}
