package com.lms.client.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class OperationsController {
	public void clientOperations(OutputStream outputStream, PrintWriter printWriter, BufferedReader userInput,
			BufferedReader serverResponse, Socket socket) {
		boolean running = true;
		while (running) {
			System.out
					.println("1: Issue Book \n2: Return Book \n3: View Profile \n4: View Available Books \n5: Log Out");
			try {
				String choice = userInput.readLine();
				String nameOfBook;
				String response;
				switch (choice) {
				case "1":
					printWriter.println(choice);
					printWriter.flush();
					System.out.println("Enter the name of book you want to issue");
					nameOfBook = userInput.readLine();
					printWriter.println(nameOfBook);
					printWriter.flush();
					issueBook(outputStream, printWriter, userInput, serverResponse);
					break;
				case "2":
					printWriter.println(choice);
					printWriter.flush();
					System.out.println("Enter the name of book you want to return");
					nameOfBook = userInput.readLine();
					printWriter.println(nameOfBook);
					printWriter.flush();
					returnBook(outputStream, printWriter, userInput, serverResponse);
					break;
				case "3":
					printWriter.println(choice);
					printWriter.flush();
					viewProfile(outputStream, printWriter, userInput, serverResponse);
					break;
				case "4":
					printWriter.println(choice);
					printWriter.flush();
					decodeAllBooks(outputStream, printWriter, userInput, serverResponse);
					break;
				case "5":
					printWriter.println(choice);
					running = false;
					logout(outputStream, printWriter, userInput, serverResponse);
					socket.close();
					break;
				default:
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void logout(OutputStream outputStream, PrintWriter printWriter, BufferedReader userInput,
			BufferedReader serverResponse) {
		try {
			String message = serverResponse.readLine();
			System.out.println(message);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void viewProfile(OutputStream outputStream, PrintWriter printWriter, BufferedReader userInput,
			BufferedReader serverResponse) {
		try {
			String encode = serverResponse.readLine();
			String[] decode = encode.split(":");

			for (String books : decode) {
				System.out.println(books);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void returnBook(OutputStream outputStream, PrintWriter printWriter, BufferedReader userInput,
			BufferedReader serverResponse) {
		try {
			String message = serverResponse.readLine();
			System.out.println(message);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void decodeAllBooks(OutputStream outputStream, PrintWriter printWriter, BufferedReader userInput,
			BufferedReader serverResponse) {
		try {
			String encode = serverResponse.readLine();
			String[] decode = encode.split(":");

			for (String books : decode) {
				System.out.println(books);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void issueBook(OutputStream outputStream, PrintWriter printWriter, BufferedReader userInput,
			BufferedReader serverResponse) {
		try {
			String message = serverResponse.readLine();
			System.out.println(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
