package com.youxifan.test;

public class Test {

	public static void main(String[] args) {
		System.out.println(new StringBuffer("abc").equals(new StringBuffer("abc")));
		System.out.println(new StringBuffer("abc")==(new StringBuffer("abc")));
		System.out.println("abc".equals("abc"));
		System.out.println("abc"=="abc");
		
		int i = 1;
		for(int m= 1; m<=10 ; m++){
			i = i*m;
			System.out.println(i);
		}
		System.out.println(i);
		
		double  p, x, y;
		  p = Math.pow(2, 5) * 256;
		  System.out.println(p);
		  
		 x = 115 / 360.0 + 0.5; 
		 System.out.println(x);
		 
		 y = (39 / 90.0 + 1) * Math.PI / 4.0; 
		 System.out.println(y);
		  
		  y = 1 - (Math.log(y) / Math.PI + 1) / 2.0; 
		  System.out.println(y);
		 
		  System.out.println(Math.round(x * p) );
		  System.out.println(Math.round(y * p) );


	}
}
