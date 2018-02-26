package com.jcabero.xkcdgag.crawler;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class XKCDGag {

	@JsonProperty
	private String month;
	@JsonProperty
	private Integer num;
	@JsonProperty
	private String link;
	@JsonProperty
	private String year;
	@JsonProperty
	private String news;
	@JsonProperty
	private String safe_title;
	@JsonProperty
	private String transcript;
	@JsonProperty
	private String alt;
	@JsonProperty
	private String img;
	@JsonProperty
	private String title;
	@JsonProperty
	private String day;

	public XKCDGag() {}
	
	public XKCDGag(String month, Integer num, String link, String year, String news, String safe_title,
			String transcript, String alt, String img, String title, String day) {
		super();
		this.month = month;
		this.num = num;
		this.link = link;
		this.year = year;
		this.news = news;
		this.safe_title = safe_title;
		this.transcript = transcript;
		this.alt = alt;
		this.img = img;
		this.title = title;
		this.day = day;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getNews() {
		return news;
	}
	public void setNews(String news) {
		this.news = news;
	}
	public String getSafe_title() {
		return safe_title;
	}
	public void setSafe_title(String safe_title) {
		this.safe_title = safe_title;
	}
	public String getTranscript() {
		return transcript;
	}
	public void setTranscript(String transcript) {
		this.transcript = transcript;
	}
	public String getAlt() {
		return alt;
	}
	public void setAlt(String alt) {
		this.alt = alt;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "XKCDGag [month=" + month + ", num=" + num + ", link=" + link + ", year=" + year + ", news=" + news
				+ ", safe_title=" + safe_title + ", transcript=" + transcript + ", alt=" + alt + ", img=" + img
				+ ", title=" + title + ", day=" + day + "]";
	}
}
