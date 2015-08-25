package com.myproject.parking.lib.utils;

public class Constants {
	
	public static final String ENVIRONMENT_DEV				= "http://localhost:8080/parking-trx/trx";
	public static final String ENVIRONMENT_LIVE = "http://ec2-52-3-21-158.compute-1.amazonaws.com:8080/parking-trx/trx";
	public static final long TIMEOUT_IN_MINUTES				= 10; // minutes

	
	public static final String CACHE_MALL = "cache_mall";
	
	public static final String NE_SDF_FULL			= "dd-MM-yyyy HH:mm:ss";
	public static final String NE_SDF_DATE			= "dd-MM-yyyy";
	public static final String NE_SDF_DOJO			= "yyyy-MM-dd'T'HH:mm:ss";
	public static final String NE_SDF_TIME			= "HH:mm:ss";
	public static final String NE_FORMAT_DATE_JSP	= "dd-mm-yy";
	public static final String NE_FORMAT_TIME_JSP	= "hh:mm:ss";
	public static final String NE_FORMAT_MONTH_YEAR_ONLY_JSP = "mm-yy";
	
	public static final String SEPARATOR_UPLOAD		= ",";	
		
	public static final int MAX_REGULER					= 5;	
	public static final int PASSWORD_LENGTH				= 8;	
	public static final int CUSTOMER_ID_LENGTH			= 8;
	
	public static final String SUCCESS_CODE				= "success";
	public static final String FAILED_CODE				= "failed";
	
	public static final int LEVEL_CODE_CMO				= 0	;
	public static final int LEVEL_CODE_BM				= 1	;
	public static final int LEVEL_CODE_RM				= 2	;
	
	public static final String SYSTEM					= "SYS";
	
	public static final int PENDING						= 0	;
	public static final int ACTIVE						= 1	;
	public static final int BLOCKED						= 2	;
	
	public static final int STATUS_ALL					= -1;
	public static final int STATUS_NONACTIVE			= 0;
	public static final int STATUS_ACTIVE				= 1;
	
	
	public static final String REGISTER_DEALER			= "TERDAFTAR";	
	public static final String UNREGISTER_DEALER		= "TIDAK TERDAFTAR";
	
	public static final int LENGTH_GENERATE_FORGET_PASSWORD = 6;
	public static final int LENGTH_GENERATE_BOOKING_CODE = 6;
	
	public static final String SHARED_PREF_LOGIN		= "SharedPrefLogin";	
	
}
