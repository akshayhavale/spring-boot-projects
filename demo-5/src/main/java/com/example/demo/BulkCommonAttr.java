package com.example.demo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BulkCommonAttr  implements  Serializable {
 
	private String styleCode;
	private String styleDescripition;
	private String itemSku;
	private String brand;
	private String ean;
	private String td;//tradeDisCount
	private String mrp;
	private String quatity;
	private String hsn;
	private String productGroups;
	private String fashionGroups;
	private String articleDimensionsUnitHeight;
	private String articleDimensionsUnitLength;
	private String articleDimensionsUnitWidth;
	private String articleDimensionsUnitLengthUOM;
	private String articleDimensionsUnitWeight;
	private String articleDimensionsUnitWeightUOM;
	private String packageDimensionsHeight;
	private String  packageDimensionsLength;
	private String packageDimensionsWeight;
	private String packageDimensionsWidth;//
	private String packageDimensionsLengh;//
	private String packageDimensionsWeightUOM;
	private String packageDimensionsLengthUOM; //
	private String additionalInformation1;
	private String countryOfOrigin;
	private String colorFamily;
	private String packagingType;
	private String season;
	private String seasonYear;
	private String secondaryColor;
	private String taxRate;
	
	private String productType;
	private String baraginStartTime;
	private String baraginEndTime;
	private String gender;
	
	
		
}
