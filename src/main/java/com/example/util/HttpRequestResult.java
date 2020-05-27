package com.example.util;


public class HttpRequestResult {
	private boolean isSuccess;
	private HttpRequestStatusCodeEnum httpRequestStatusCodeEnum;
	private String responseTxt;
	private String charset;

	public HttpRequestResult(HttpRequestStatusCodeEnum httpRequestStatusCodeEnum, boolean isSuccess, String responseTxt){
		this(httpRequestStatusCodeEnum,isSuccess,responseTxt,"UTF-8");
	}

	public HttpRequestResult(HttpRequestStatusCodeEnum httpRequestStatusCodeEnum, boolean isSuccess, String responseTxt, String charset){
		this.isSuccess = isSuccess;
		this.httpRequestStatusCodeEnum = httpRequestStatusCodeEnum;
		this.responseTxt = responseTxt;
		this.charset = charset;
	}


	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public HttpRequestStatusCodeEnum getHttpRequestStatusCodeEnum() {
		return httpRequestStatusCodeEnum;
	}
	public void setHttpRequestStatusCodeEnum(
			HttpRequestStatusCodeEnum httpRequestStatusCodeEnum) {
		this.httpRequestStatusCodeEnum = httpRequestStatusCodeEnum;
	}
	public String getResponseTxt() {
		return responseTxt;
	}
	public void setResponseTxt(String responseTxt) {
		this.responseTxt = responseTxt;
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}
}
