package com.oyk.product.form;

import javax.validation.constraints.NotEmpty;
public class ProductForm {
	//验证、国际化用大括号
	
	@NotEmpty(message="{id.valid}")
	private String code;
	
	@NotEmpty(message="{name.valid}")
	private String name;
	
	@NotEmpty(message="{summary.valid}")
	private String summary;
	
	@NotEmpty(message="{description.valid}")
	private String description;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
