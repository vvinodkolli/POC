package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PdfDto;
import com.example.demo.util.FileUtil;
import com.example.demo.util.MailUtil;
import com.example.demo.util.PdfUtil;
import com.example.demo.util.TemplateEngineUtil;

@Service
public class PdfService {



	@Autowired
	private TemplateEngineUtil templateEngineUtil;
	
	@Autowired
	private MailUtil mailUtil;
	
	@Autowired
	private PdfUtil pdfUtil;
	
	

	public void generatePdf(PdfDto pdfDto) throws Exception {
		String html = templateEngineUtil.processTemplate(pdfDto);
		byte[] pdfBytes = pdfUtil.createRawPdf(pdfDto, html);
		FileUtil.writeToFile(pdfDto, pdfBytes);
		mailUtil.sendMail(pdfBytes, "application/pdf");

	}
}
