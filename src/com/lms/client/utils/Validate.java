package com.lms.client.utils;

public class Validate {
	public boolean checkName(String name) {
		if(name.equals("")) {
			return false;
		}
		char[] chars = name.toCharArray();
		for (char c : chars) {
			if (Character.isDigit(c)) {
				return false;
			}
		}
		return true;

	}

	public boolean checkPwd(String pwd) {
		if(pwd.length()<4) {
			return false;
		}
		return true;
	}
}
