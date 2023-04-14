package com.lms.client.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import com.lms.client.utils.Validate;

public class UserController {

	public static boolean login(OutputStream outputStream, PrintWriter printWriter, BufferedReader userInput,
			BufferedReader serverResponse, Socket socket) {
		try {
			String name;
			String password;
			while (true) {
				System.out.println("Enter your name");
				name = userInput.readLine();
				System.out.println("Enter your password");
				password = userInput.readLine();

				Validate valid = new Validate();
				boolean nameValidate = valid.checkName(name.trim());
				boolean pwdValidate = valid.checkPwd(password.trim());

				if (nameValidate == true && pwdValidate == true) {
					break;
				}
				else {
					System.out.println("Invalid name or password, Please try again");
					System.out.println("Note: No numbers or spaces allowed in name.");
					System.out.println("      Password length should be atleast 4");
				}
			}

			printWriter.println("2");
			printWriter.println(name);
			printWriter.println(password);
			printWriter.flush();

			String accountMessage = serverResponse.readLine();
			System.out.println(accountMessage);
			if (accountMessage.equals("Login Successful")) {
				OperationsController operation = new OperationsController();
				operation.clientOperations(outputStream, printWriter, userInput, serverResponse, socket);
			}
			else if(accountMessage.equals("Login error")) {
				return true;
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean create(OutputStream outputStream, PrintWriter printWriter, BufferedReader userInput,
			BufferedReader serverResponse, Socket socket) {

		try {
			String name;
			String password;
			while (true) {
				System.out.println("Enter your name");
				name = userInput.readLine();
				System.out.println("Enter your password");
				password = userInput.readLine();

				Validate valid = new Validate();
				boolean nameValidate = valid.checkName(name.trim());
				boolean pwdValidate = valid.checkPwd(password.trim());

				if (nameValidate == true && pwdValidate == true) {
					break;
				}
				else {
					System.out.println("Invalid name or password, Please try again");
					System.out.println("Note: No numbers or spaces allowed in name.");
					System.out.println("      Password length should be atleast 4");
				}
			}


			printWriter.println("1");
			printWriter.println(name);
			printWriter.println(password);
			printWriter.flush();

			String accountMessage = serverResponse.readLine();
			System.out.println(accountMessage);
			if (accountMessage.equals("Account Generated")) {
				OperationsController operation = new OperationsController();
				operation.clientOperations(outputStream, printWriter, userInput, serverResponse, socket);
			}
			else if(accountMessage.equals("Account creation error")) {
				return true;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
}
