package com.jcabero.xkcdgag.gag.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dummy {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_GAG")
	private Long id;

	public Dummy() {}
	
	public Dummy(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
