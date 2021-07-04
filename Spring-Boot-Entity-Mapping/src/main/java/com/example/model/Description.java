package com.example.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Description {

	@Column(name = "DESC")
	private String desc;

}
