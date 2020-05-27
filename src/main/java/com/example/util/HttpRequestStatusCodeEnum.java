package com.example.util;

/**
 * http部分返回状态码
 * <ul>
 * <li></li>
 * <li>创建人： 相磊</li>
 * <li>创建时间: Oct 13, 2010 5:35:52 PM</li>
 * </ul>
 */
public enum HttpRequestStatusCodeEnum {
	OK(200,"OK"), BAD_REQUEST(400,"BAD_REQUEST"), UNAUTHORIZED(401,"UNAUTHORIZED"),
	FORBIDDEN(403,"FORBIDDEN"),
	METHOD_NOT_ALLOWED(405,"METHOD_NOT_ALLOWED"),
	NOT_FOUND(404,"NOT_FOUND"),
	INTERNAL_SERVER_ERROR(500,"INTERNAL_SERVER_ERROR"),
	HTTP_VERSION_NOT_SUPPORTED(505,"HTTP_VERSION_NOT_SUPPORTED"),
	SERVICE_UNAVAILABLE(503,"SERVICE_UNAVAILABLE"),

	CONNECT_TIMEOUT(901, "CONNECT_TIMEOUT"),
	READ_TIMEOUT(902, "READ_TIMEOUT");

	private HttpRequestStatusCodeEnum(int statusCode, String desc){
		this.code=statusCode;
		this.desc=desc;
		
	}
	
	public static HttpRequestStatusCodeEnum valueOf(int code) {

		if (code == 200) {
			return OK;
		} else if (code == 400) {

			return BAD_REQUEST;
		} else if (code == 401) {
			return UNAUTHORIZED;

		} else if (code == 403) {

			return FORBIDDEN;
		} else if (code == 404) {

			return NOT_FOUND;
		} else if(code==405){
			return METHOD_NOT_ALLOWED;
		}else if (code == 500) {

			return INTERNAL_SERVER_ERROR;
		} else if (code == 505) {

			return HTTP_VERSION_NOT_SUPPORTED;
		} else if (code == 503) {

			return SERVICE_UNAVAILABLE;
		} else {
			return BAD_REQUEST;
		}
	}
	
	private int code;
	
	private String desc;




	public int getCode() {
		return code;
	}



	public void setCode(int code) {
		this.code = code;
	}



	public String getDesc() {
		return desc;
	}



	public void setDesc(String desc) {
		this.desc = desc;
	}
}
