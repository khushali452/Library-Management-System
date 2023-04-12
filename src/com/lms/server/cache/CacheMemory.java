package com.lms.server.cache;

import java.util.Set;

import com.lms.server.repository.UserEntryAuth;

public class CacheMemory {
	public static boolean checkActiveUser(Set<String> activeUser, String name) {
		return activeUser.contains(name);
	}
	
	public static boolean checkExistedUser(Set<String> existedUser, String name) {
		return existedUser.contains(name);
	}
	public static void removeActiveUser(Set<String> activeUser, String name) {
		activeUser.remove(name);
	}
}
