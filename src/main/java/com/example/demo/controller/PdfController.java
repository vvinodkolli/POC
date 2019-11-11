package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PdfDto;
import com.example.demo.service.PdfService;

@RestController
public class PdfController {
	@Autowired
	private PdfService pdfService;

	@PostMapping(value="/generatePdf")
	public void generatePdf(@RequestBody PdfDto pdfDto) throws Exception{
		pdfService.generatePdf(pdfDto);
	}
	
}
