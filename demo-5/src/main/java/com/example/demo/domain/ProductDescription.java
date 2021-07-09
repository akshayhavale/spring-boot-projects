package com.example.demo.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDescription {

	private String description;
	private String friendlyUrl;
	private String highlights;
	private String keyWords;
	private String language="en";
	private String metaDescription;
	private String name;
	private String title;	
	

}
