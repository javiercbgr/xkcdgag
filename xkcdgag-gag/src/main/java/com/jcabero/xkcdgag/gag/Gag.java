package com.jcabero.xkcdgag.gag;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gag {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_GAG")
	private Long id;
	
	@Column(name="NUM_GAG")
	private Long number;
	
	@Column(name="IMG_URL")
	private String imgUrl;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="LIKES")
	private Long likes;
	
	@Column(name="DISLIKES")
	private Long dislikes;

	public Gag() {}
	
	public Gag(Long number, String imgUrl, String title, Long likes, Long dislikes) {
		this.number = number;
		this.imgUrl = imgUrl;
		this.title = title;
		this.likes = likes;
		this.dislikes = dislikes;
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

	public Long getDislikes() {
		return dislikes;
	}

	public void setDislikes(Long dislikes) {
		this.dislikes = dislikes;
	}

	@Override
	public String toString() {
		return "Gag [id=" + id + ", numGag=" + number + ", imgUrl=" + imgUrl + ", title=" + title + ", likes=" + likes
				+ ", dislikes=" + dislikes + "]";
	}
}
