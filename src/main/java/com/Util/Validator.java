package com.Util;

public class Validator {
	public static boolean isBlank(String data) {
		return (data == null || data.equals("-1") || data.trim().length() < 1);
	}
	
	public static boolean isAlph(String data) {
		String alphaRegExString = "[a-zA-Z]+";
		return (data.matches(alphaRegExString)== false);
	}
}
