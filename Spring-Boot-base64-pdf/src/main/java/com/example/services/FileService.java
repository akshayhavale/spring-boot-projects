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

		byte[] bytes = Base64.getDecoder().decode(base64String);

		return bytes;

	}

}
