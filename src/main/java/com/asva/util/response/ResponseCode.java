package com.asva.util.response;

public interface ResponseCode {

	String FAIL = "0000";
	String SUCCESS = "9000";

	String INSERT_SUCCESS = "1000";
	String INSERT_FAIL = "1001";

	String DELETE_SUCCESS = "2000";
	String DELETE_FAIL = "2001";

	String UPDATE_SUCCESS = "3000";
	String UPDATE_FAIL = "3001";

	String RECORD_FOUND = "4000";
	String RECORD_NOT_FOUND = "4001";

}
