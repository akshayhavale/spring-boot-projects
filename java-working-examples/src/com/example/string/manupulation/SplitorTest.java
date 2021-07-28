package com.example.string.manupulation;

import java.util.StringTokenizer;
import java.util.UUID;

public class SplitorTest {
	
	public static void main(String args []) {
		
		UUID uuid = UUID.randomUUID();

		System.out.println(uuid.toString());
		
		String url = "https://www.stockxbid.com/private/temp/seller/2/image/"+uuid.toString();
		
		String noSpaceString = url.trim();
		
		
		//now split the String and get sellerId and UUID from that String
		
		StringTokenizer tokens = new StringTokenizer(url, "/");
		
		System.out.println("Tokens count : "+tokens.countTokens());
		while(tokens.hasMoreElements()) {
			System.out.println(tokens.nextToken());
		}
		
		System.out.println("****************************************");
		
		String[] splitArray = noSpaceString.split("/");
		System.out.println("Count : "+splitArray.length);
		for(String s : splitArray) {
			System.out.println(s);
		}
		
		System.out.println("SellerId : "+ splitArray[4]);
		System.out.println("UUID : "+ splitArray[6]);
		
		
	}

}
