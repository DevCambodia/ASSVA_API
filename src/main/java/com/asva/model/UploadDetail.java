package com.asva.model;

import com.fasterxml.jackson.annotation.JsonProperty;
	
public class UploadDetail {
	
	@JsonProperty("FILE_NAME")
	private String fileName;
	
	@JsonProperty("RELATIVE_PATH")
	private String relativePath;
	
	@JsonProperty("PATH")
	private String path;
	
	@JsonProperty("ERROR")
	private String error;
	
	public UploadDetail(){
		fileName = "";
		relativePath = "";
		path = "";
	}
	
	public UploadDetail(String fileName, String relativePath, String path) {
		super();
		this.fileName = fileName;
		this.relativePath = relativePath;
		this.path = path;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getRelativePath() {
		return relativePath;
	}
	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}

	public String getPath() {
		return this.relativePath + this.fileName;
	}
	
	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "UploadDetail [fileName=" + fileName + ", relativePath=" + relativePath + ", path="
				+ path + "]";
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	
	
}
