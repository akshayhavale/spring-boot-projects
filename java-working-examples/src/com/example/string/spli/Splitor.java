package com.example.string.spli;

public class Splitor {

	private static final String sentance = "http://104.237.9.45:7001/stockxbid/notifyuser/product/image/STOCKXBID-SELLER-50/IMAG[…]ZORQW75SE1PSYGHEGD/c38a09e3-ea0d-11eb-9ef5-a95154e3f817.jpeg";

	public static void main(String[] args) {
		int count = 0;
		String[] words = sentance.split("/");
		for (String word : words) {
			System.out.println("Position : " + count + " , Value : " + word);
			count++;
		}
		System.out.println("**********");
		String imageNameWithExtension = words[10];
		System.out.println(imageNameWithExtension);
		String[] imgSplit = imageNameWithExtension.split("\\.");
		for(String i : imgSplit){
			System.out.println(i);
		}
		System.out.println("ImageName is : " + imgSplit[0] + " and extension is : " + imgSplit[1]);
		
		String url = new StringBuilder().append(Constants.SLASH).append("static").append(Constants.SLASH).append("PRODUCT")
				.append(Constants.SLASH).append(words[7]).append(Constants.SLASH).append("IMAGE")
				.append(Constants.SLASH).append(imageNameWithExtension).toString();
		System.out.println(url);
	}

}
