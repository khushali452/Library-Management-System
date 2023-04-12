package com.lms.server.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lms.server.repository.BookData;

public class CacheBooksProfile {
	private static Map<String, List<String>> userBooks;

	public CacheBooksProfile() {
		CacheBooksProfile.userBooks = new HashMap<String, List<String>>();
	}

	public Map<String, List<String>> getUserBooks() {
		return userBooks;
	}

	public void setUserBooks(Map<String, List<String>> userBooks) {
		CacheBooksProfile.userBooks = userBooks;
	}

}
