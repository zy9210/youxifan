package com.youxifan.test;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		System.out.println(new StringBuffer("abc").equals(new StringBuffer("abc")));
		System.out.println(new StringBuffer("abc")==(new StringBuffer("abc")));
		System.out.println("abc".equals("abc"));
		System.out.println("abc"=="abc");
		
		for (int i = 0; i < 20; i++) {
			System.out.println(new Random().nextInt(5)+1);
		}
		


	}
}
