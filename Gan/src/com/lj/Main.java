package com.lj;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList list = new ArrayList();
		for(int i = 0 ; i < 10 ; i++) {
			
			list.add("数据" + i);
		} 
		
	    for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	    
//	    
//	    String string = "14241242424ssss.mp3";
//	    string.split("\\.");
//	    for (int i = 0; i < string.length(); i++) {
//	    	String sss = string.charAt(i);
//			
//		}
	    
	    
	    String[] strs = "a.b.cv.dddd.".split(".");
	    for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}
	    
	    
	    
	    
	}

}
