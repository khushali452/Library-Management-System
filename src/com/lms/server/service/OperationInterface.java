package com.lms.server.service;

import java.util.List;

import com.lms.server.model.User;

public interface OperationInterface {
	public boolean issueBook(String nameofBook, User user);
	public boolean returnBook(String nameofBook, User user);
	public List<String> viewProfile(User user);
	List<String> viewAvailabaleBooks();
}
