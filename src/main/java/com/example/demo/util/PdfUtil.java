package com.example.demo.util;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import javax.mail.MessagingException;

import org.springframework.stereotype.Component;

import com.example.demo.dto.PdfDto;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@Component
public class PdfUtil {

	public byte[] createRawPdf(PdfDto pdfDto, String html)
			throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException,
			TemplateException, DocumentException, FileNotFoundException, MessagingException {
		return convertPdf(html);
	}

	private byte[] convertPdf(String html) throws DocumentException, IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		Document document = new Document();

		PdfWriter writer = PdfWriter.getInstance(document, outputStream);

		document.open();

		Reader targetReader = new StringReader(html);
		XMLWorkerHelper.getInstance().parseXHtml(writer, document, targetReader);

		targetReader.close();
		writer.close();
		document.close();
		outputStream.close();

		return outputStream.toByteArray();
	}

}
