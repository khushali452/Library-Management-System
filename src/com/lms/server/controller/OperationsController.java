package com.lms.server.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import com.lms.server.cache.CacheMemory;
import com.lms.server.model.User;
import com.lms.server.repository.UserEntryAuth;
import com.lms.server.service.OperationInterfaceImpl;

public class OperationsController {
	private OperationInterfaceImpl operationHandler;
	public OperationsController() {
		operationHandler = new OperationInterfaceImpl(); 
	}

	public void serverOperations(InputStream inputStream, BufferedReader bufferedReader, OutputStream outputStream,
			PrintWriter printWriter, User user) {
		String response;
		while(true) {
			try {
				String serverChoice = bufferedReader.readLine();
				String nameOfBook;
				if(serverChoice == null) {
					break;
				}
				switch(serverChoice) {
				case "1":
					nameOfBook = bufferedReader.readLine();
					response = issueBook(nameOfBook, user);
					printWriter.println(response);
					printWriter.flush();
					break;
				case "2":
					nameOfBook = bufferedReader.readLine();
					response = returnBook(nameOfBook, user);
					printWriter.println(response);
					printWriter.flush();
					break;
				case "3":
					response = viewProfile(user);
					printWriter.println(response);
					printWriter.flush();
					break;
				case "4":
					response = viewAllBooks();
					printWriter.println(response);
					printWriter.flush();
					break;
				case "5":
					response = logOut(user);
					printWriter.println(response);
					break;
				default:
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private String logOut(User user) {
		CacheMemory.removeActiveUser(UserEntryAuth.getActiveUser(), user.getName());
		return "Logout Success";
	}

	private String returnBook(String nameOfBook, User user) {
		boolean issue = this.operationHandler.returnBook(nameOfBook, user);
		String message;
		if(!issue) {
			message = "Can't return this this book, Try again later";
		}
		else {
			message = "Book Returned";
		}
		return message;
	}
	private String issueBook(String nameOfBook, User user) {
		boolean issue = this.operationHandler.issueBook(nameOfBook, user);
		String message;
		if(!issue) {
			message = "Can't issue this book, Try again later";
		}
		else {
			message = "Book Issued";
		}
		return message;
	}

	public String viewAllBooks(){
		List<String> listOfAllBooks = this.operationHandler.viewAvailabaleBooks();
		StringBuilder str = new StringBuilder();
		for(String book: listOfAllBooks) {
			str.append(book);
			str.append(":");
		}
		return str.toString();
		
	}
	public String viewProfile(User user){
		List<String> listOfAllBooks = this.operationHandler.viewProfile(user);
		StringBuilder str = new StringBuilder();
		for(String book: listOfAllBooks) {
			str.append(book);
			str.append(":");
		}
		return str.toString();
		
	}
}
