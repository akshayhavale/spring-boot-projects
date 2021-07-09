package com.example.demo.domain;

import java.math.BigDecimal;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Attribute {

	private String attiributeDescription;
	private List<Image> images;
	private String ean;
	private String item_sku;
	private BigDecimal priceFinal = new BigDecimal(0);
	private BigDecimal productAttributePrice = new BigDecimal(0);
	private Option option;
	private OptionValue optionValue; // object
	private Integer productAttributeQuantity;
	private String styleCode;
	private String styleDescription;
	private String tradeDisCount;
	
	
}
