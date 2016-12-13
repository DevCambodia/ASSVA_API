package com.asva.util.table.meta;

import com.asva.model.user.User;

/**
 * Created Date: 14/07/2016
 * Author: Rath Phearun
 * Email: rathphearun123@gmail.com
 * 
 * */
public class TableUser extends User{
	
	public static final String NAME = "tb_user";
	
	public static class Field{
		
		public static final String ID         = "user_id"         ;
		public static final String FIRSTNAME  = "user_first_name" ;
		public static final String LASTNAME   = "user_last_name"  ;
		public static final String GENDER     = "user_gender"     ;
		public static final String EMAIL      = "user_email"      ;
		public static final String PASSWORD   = "user_password"   ;
		public static final String PHOTO      = "user_photo"      ;
		public static final String STATUS     = "user_status"     ;
		public static final String TELEPHONE  = "user_telelphone" ;
		public static final String ROLE       = "user_role"       ;
		
	}
	
}
