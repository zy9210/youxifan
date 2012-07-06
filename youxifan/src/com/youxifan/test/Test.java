package com.youxifan.test;

public class Test {

	public static void main(String[] args) {
		System.out.println(new StringBuffer("abc").equals(new StringBuffer("abc")));
		
		System.out.println("abc".equals("abc"));
		
		int i = 1;
		for(int m= 1; m<=10 ; m++){
			i = i*m;
			System.out.println(i);
		}
		System.out.println(i);
	}
}
