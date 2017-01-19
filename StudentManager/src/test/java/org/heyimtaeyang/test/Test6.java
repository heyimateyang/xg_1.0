package org.heyimtaeyang.test;

import javax.servlet.http.HttpServletRequest;


import org.junit.Test;

public class Test6 {
	
	 protected static String sqlValidate(String str) {    
	        str = str.toLowerCase();//统一转为小写    
	        String badStr = "'|select|update|and|or|delete|insert|truncate|char|into"  
	                + "|substr|declare|exec|master|drop|execute|"  
	                + "union|;|--|+|,|like|//|/|%|#|*|$|@|\"|http|cr|lf|<|>|(|)";//过滤掉的sql关键字，可以手动添加    
	        String[] badStrs = badStr.split("\\|");    
	        for (int i = 0; i < badStrs.length; i++) {    
	            if (str.indexOf(badStrs[i]) >= 0) {  
	            	System.out.println(badStrs[i]);
	                return badStrs[i];    
	            }    
	        }    
	        return null;    
	    }    
	 
	 
	 @Test 
	 public void andy(){
		 System.out.println(sqlValidate("SELECT * FROM STUDENT LIKE"));
	 }

}
