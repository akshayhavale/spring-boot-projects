package com.example.collections.map;

public enum ProductTypes {

	Sneakers("Value in Sneakers"), Streetwears("Value in Streetwears"), Bags("Value in Bag"),
	Watches("Value in watches");

	private String text;

	private ProductTypes(String info) {
		this.text = info;
	}

	public static ProductTypes getValue(String value) {
		ProductTypes t = null;
		for (ProductTypes type : ProductTypes.values()) {
			if (type.name().toLowerCase().equalsIgnoreCase(value)) {
				t = type;
			}
		}
		return t;
	}

	public String getText() {
		return text;
	}

}
