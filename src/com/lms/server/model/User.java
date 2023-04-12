package com.lms.server.model;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class User {
	private String name;
	private String password;
	private List<String> issuedBooks;
	public User(String name, String password, List<String> issuedBooks) {
		this.name = name;
		this.password = password;
		this.issuedBooks = issuedBooks;
	}

	public List<String> getIssuedBooks() {
		return issuedBooks;
	}

	public void setIssuedBooks(List<String> issuedBooks) {
		this.issuedBooks = issuedBooks;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
