package com.lms.server.repository;

import java.util.HashMap;
import java.util.Map;

public class BookData {
	private static Map<String, Integer> books = new HashMap<String, Integer>();
	
	
	public BookData() {
		BookData.books.put("Atomic Habbits", 10);
		BookData.books.put("Alchemist", 5);
		BookData.books.put("Deep Work", 2);
		BookData.books.put("Java", 7);
		BookData.books.put("Rich Dad Poor Dad", 1);
	}
	public static Map<String, Integer> getBooks() {
		return books;
	}
	public static void setBooks(String nameOfBook, int copies) {
		BookData.books.put(nameOfBook, copies);
	}

	
}
