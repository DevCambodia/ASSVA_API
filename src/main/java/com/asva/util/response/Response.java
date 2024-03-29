package com.asva.util.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author PHEARUN 
 * Created Date: 14/07/2016 
 * Email: rathphearun123@gmail.com
 * Credit: Dara Penhchet
 */
public class Response {

	@JsonProperty("CODE")
	public String code = ResponseCode.FAIL;

	@JsonProperty("MESSAGE")
	public String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		switch (code) {
		case ResponseCode.SUCCESS:
			message = ResponseMessage.SUCCESS;
			break;
		case ResponseCode.INSERT_SUCCESS:
			message = ResponseMessage.INSERT_SUCCESS;
			break;
		case ResponseCode.INSERT_FAIL:
			message = ResponseMessage.INSERT_FAIL;
			break;
		case ResponseCode.DELETE_FAIL:
			message = ResponseMessage.DELETE_FAIL;
			break;
		case ResponseCode.DELETE_SUCCESS:
			message = ResponseMessage.DELETE_SUCCESS;
			break;
		case ResponseCode.RECORD_FOUND:
			message = ResponseMessage.RECORD_FOUND;
			break;
		case ResponseCode.RECORD_NOT_FOUND:
			message = ResponseMessage.RECORD_NOT_FOUND;
			break;
		case ResponseCode.UPDATE_FAIL:
			message = ResponseMessage.UPDATE_FAIL;
			break;
		case ResponseCode.UPDATE_SUCCESS:
			message = ResponseMessage.UPDATE_SUCCESS;
			break;
		default:
			message = ResponseMessage.ERROR;
		}
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Response [code=" + code + ", message=" + message + "]";
	}
}
