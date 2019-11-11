package com.example.demo.util;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.example.demo.dto.PdfDto;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@Component
public class TemplateEngineUtil {

	@Autowired
	private Configuration freeMarkerConfig;

	public String processTemplate(PdfDto pdfDto) throws TemplateNotFoundException, MalformedTemplateNameException,
			ParseException, IOException, TemplateException {
		Template t = freeMarkerConfig.getTemplate("invoice.ftl");
		String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, pdfDto.getData());
		return html;
	}

}
