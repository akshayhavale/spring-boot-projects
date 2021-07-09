package com.example.demo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.example.demo.domain.CategoryType;
import com.example.demo.domain.Image;
import com.example.demo.domain.ProductDescription;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BulkUploadData implements  Serializable {

	private BulkCommonAttr  bulkCommonAttr;
	private ProductDescription productDescription;
	private String sizeFormat;
	private String insoleDetail;
	private String productName;
	private String soleMaterial;
	private String standardSize;
	private String upperMaterial;

	private String fabricDetails;
	private String fabricType;
	private String pattern;
	private String closure;
	private String fit;
	private String length;
	private String reversible;
	private String sleeve;
	
	
	private String  materialDetail;
	private String  materialType;
	private String  productDimensions;
	private String  compartmentDetail;
	private String  laptopCompartment;
	private String  styleType;

	private  List<Image> images;
	

}
