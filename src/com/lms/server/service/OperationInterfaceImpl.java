package com.lms.server.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lms.server.cache.CacheBooksProfile;
import com.lms.server.model.User;
import com.lms.server.repository.BookData;

public class OperationInterfaceImpl {
	BookData booksData;
	public OperationInterfaceImpl() {
		booksData = new BookData();
	}

	public boolean issueBook(String nameOfBook, User user) {
		Map<String, Integer> availBooks = booksData.getBooks();
		int copies = availBooks.get(nameOfBook);
		if(user.getIssuedBooks().contains(nameOfBook) || copies == 0) {			
			return false;
		}
		user.getIssuedBooks().add(nameOfBook);
		CacheBooksProfile cache = new CacheBooksProfile();
		Map<String, List<String>> userBooks = new HashMap<String, List<String>>();
		userBooks.put(user.getName(), user.getIssuedBooks());
		cache.setUserBooks(userBooks);
		booksData.setBooks(nameOfBook, copies-1);
		return true;
	}

	
	public boolean returnBook(String nameOfBook, User user) {
		Map<String, Integer> availBooks = booksData.getBooks();
		int copies = availBooks.get(nameOfBook);
		if(!user.getIssuedBooks().contains(nameOfBook) || !availBooks.containsKey(nameOfBook)) {			
			return false;
		}
		user.getIssuedBooks().remove(nameOfBook);
		booksData.setBooks(nameOfBook, copies+1);
		return true;
		
	}

	
	public List<String> viewProfile(User user) {
		return user.getIssuedBooks();
	}

	
	public List<String> viewAvailabaleBooks() {
		List<String> listOfAvailBooks = new ArrayList<String>();
		for(String keys: booksData.getBooks().keySet()) {
			listOfAvailBooks.add(keys);
		}
		return listOfAvailBooks;
		
	}

}
