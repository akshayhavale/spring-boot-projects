package com.example.demo.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PackagingSpecifications {

	private String dimensionUnitOfMeasure;
	private float height;
	private float length;
	private String packagingType;
	private float weight;
	private String weightUnitOfMeasure;
	private float width;
}
