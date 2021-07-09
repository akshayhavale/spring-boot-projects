package com.example.demo;

import org.springframework.stereotype.Component;

import com.example.demo.domain.CategoryType;
import com.example.demo.utility.reader.Row;

@Component
public class BulkUploadAdapter {

	public Object apply(String name, Row r) { 
		if(name.equalsIgnoreCase(CategoryType.SNEAKERS.name())) {
			
			return BulkUploadData.builder().sizeFormat(r.getCellText(31))
					.insoleDetail(r.getCellText(32))
					.productName(r.getCellText(33))
					.soleMaterial(r.getCellText(34))
					.standardSize(r.getCellText(35))
					.upperMaterial(r.getCellText(36))
					.bulkCommonAttr(createCommonAttr(r))
					.productDescription(null).build();
		}
		return null;
	}
	private BulkCommonAttr createCommonAttr(Row r) {
	    
	    System.out.println(r);

		BulkCommonAttr bulkCommonAttr =	 BulkCommonAttr.builder().styleCode(r.getCellAsString(1).orElse(null))
				.styleDescripition(r.getCellText(2))
				.itemSku(r.getCellText(3))
				.brand(r.getCellText(4))
				.ean(r.getCellText(5))
				.td(r.getCellText(6))
				.mrp(r.getCellText(7))
				.quatity(r.getCellText(8))
				.hsn(r.getCellText(9))
				.productGroups(r.getCellText(10))
				.fashionGroups(r.getCellText(11))
				.articleDimensionsUnitHeight(r.getCellText(12))
				.articleDimensionsUnitLength(r.getCellText(13))
				.articleDimensionsUnitWidth(r.getCellText(14))
				.articleDimensionsUnitLengthUOM(r.getCellText(15))
				.articleDimensionsUnitWeight(r.getCellText(16))
				.articleDimensionsUnitWeightUOM(r.getCellText(17))
				.packageDimensionsHeight(r.getCellText(18))
				.packageDimensionsLength(r.getCellText(19)) 
				.packageDimensionsWidth(r.getCellText(20))
				.packageDimensionsLengthUOM(r.getCellText(21))
				.packageDimensionsWeight(r.getCellText(22))
				.packageDimensionsWeightUOM(r.getCellText(23))
				.additionalInformation1(r.getCellText(24))
				.countryOfOrigin(r.getCellText(25))
				.colorFamily(r.getCellText(26))
				.packagingType(r.getCellText(27))
				.season(r.getCellText(28))
				.seasonYear(r.getCellText(29))
				.secondaryColor(r.getCellText(30))
				//.taxRate(r.getCellText(3).orElse(null))
				.productType(r.getCellText(37))
				.baraginStartTime(r.getCellText(38))
				.baraginEndTime(r.getCellText(39))
				.gender(r.getCellText(40))
				.build();
		 
		 return bulkCommonAttr;
	}

}
