package com.csi.payroll.mgt.util;

import java.text.SimpleDateFormat;
import java.util.Date;



public class DataUtility {
	
	/**
     * Application Date Format
     */ 	
public static final String APP_DATE_FORMATE = "MM/dd/yyyy";

public static  SimpleDateFormat formatter = new SimpleDateFormat(APP_DATE_FORMATE);


public static Date getDate(String val ){	
	try{
		return formatter.parse(val);
	}catch(Exception e){
		return null;
	}
}

public static String getStringDate(Date val ){	
	
		return formatter.format(val);
	
}

}
