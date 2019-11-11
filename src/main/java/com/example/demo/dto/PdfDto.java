package com.example.demo.dto;

import java.util.Map;

public class PdfDto {
private String templateName;
private Map<String,String> data;
public String getTemplateName() {
	return templateName;
}
public void setTemplateName(String templateName) {
	this.templateName = templateName;
}
public Map<String, String> getData() {
	return data;
}
public void setData(Map<String, String> data) {
	this.data = data;
}


	
}
