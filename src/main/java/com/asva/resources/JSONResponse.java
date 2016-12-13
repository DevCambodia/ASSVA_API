package com.asva.resources;

public interface JSONResponse {
	/**
	 * Key
	 * */
	public interface Key{
		public String DATA		=	"DATA";
		public String COUNT 	=	"COUNT";
		public String MESSAGE 	=	"MESSAGE";
		public String STATUS 	=	"STATUS";
	}
	
	/**
	 * Value
	 * */
	public interface Value{
		public String TRANSACTION_FAIL		=	"TRANSACTION_FAIL";
		public String TRANSACTION_SUCCESS	=	"TRANSACTION_SUCCESS";
		public String NO_RECORD_FOUND		=	"NO_RECORD_FOUND";
	}
}
