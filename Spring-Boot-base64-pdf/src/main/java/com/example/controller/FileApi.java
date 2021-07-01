package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.services.FileService;

@RestController
public class FileApi {

	@Autowired
	private FileService fileService;

	@PostMapping("/pdf/string")
	public @ResponseBody String convertPdfToString(@RequestParam(value = "file", required = true) MultipartFile file,
			HttpServletRequest request, HttpServletResponse response) {
		
		String localAddr = request.getLocalAddr();
		int localPort = request.getLocalPort();
		
		System.out.println(localAddr+":"+localPort);
		return fileService.covertPdfToBase64String(file);
	}

	@GetMapping(path = "/string/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public byte[] convertStringToPdf(@RequestParam(value = "pdfstring") String pdfstring) {
		return fileService.convertBase64StringToPdf(pdfstring);
	}

}
