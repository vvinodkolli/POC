package com.example.demo.util;

import java.io.FileOutputStream;
import java.util.UUID;

import com.example.demo.dto.PdfDto;

public class FileUtil {

	public static void writeToFile(PdfDto pdfDto, byte[] bytes) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(
				"D:\\" + UUID.randomUUID() + pdfDto.getTemplateName() + ".pdf");) {
			fileOutputStream.write(bytes);
		} catch (Exception e) {
			System.out.println("File Exception");
		}
	}

}
