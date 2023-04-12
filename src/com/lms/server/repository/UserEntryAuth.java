package com.lms.server.repository;

import java.util.HashSet;
import java.util.Set;

public class UserEntryAuth {
	private static Set<String> activeUser = new HashSet<String>();
	private static Set<String> existedUser  = new HashSet<String>();
	

	public static Set<String> getExistedUser() {
		return existedUser;
	}

	public static void setExisted(String name) {
		UserEntryAuth.existedUser.add(name);
	}
	public static Set<String> getActiveUser() {
		return activeUser;
	}
	
	public static void setActiveUser(String name) {
		UserEntryAuth.activeUser.add(name);
	}
	
//	public static void removeActiveUser(String name) {
//		UserEntryAuth.activeUser.remove(name);
//	}
}
