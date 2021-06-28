package com.example.services;

import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileService {

	public String covertPdfToBase64String(MultipartFile file) {
		String encodedString = null;
		try {

			byte[] bytes = file.getBytes();

			encodedString = Base64.getEncoder().encodeToString(bytes);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return encodedString;
	}

	public byte[] convertBase64StringToPdf(String base64String) {

		String[] strings = base64String.split(",");
//		String extension;
//		switch (strings[0]) {// check image's extension
//		case "data:image/jpeg;base64":
//			extension = "p";
//			break;
//		case "data:image/png;base64":
//			extension = "png";
//			break;
//		default:// should write cases for more images types
//			extension = "jpg";
//			break;
//		}
		System.out.println(strings[0]);
		byte[] bytes = Base64.getDecoder().decode(base64String);

		return bytes;

	}
}
