package com.lms.server.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lms.server.cache.CacheBooksProfile;
import com.lms.server.cache.CacheMemory;
import com.lms.server.model.User;
import com.lms.server.repository.UserEntryAuth;

public class UserController {
	static CacheBooksProfile cache;

	public void create(InputStream inputStream, BufferedReader bufferedReader, OutputStream outputStream,
			PrintWriter printWriter) {
		try {
			String name = bufferedReader.readLine();
			String password = bufferedReader.readLine();
			String message = null;

			UserController.cache = new CacheBooksProfile();
			User user = new User(name, password, new ArrayList<String>());
			Map<String, List<String>> userBooks = new HashMap<String, List<String>>();
			userBooks.put(user.getName(), new ArrayList<String>());
			cache.setUserBooks(userBooks);

			if (!CacheMemory.checkActiveUser(UserEntryAuth.getActiveUser(), user.getName())
					&& !CacheMemory.checkExistedUser(UserEntryAuth.getExistedUser(), user.getName())) {
				UserEntryAuth.setActiveUser(user.getName());
				UserEntryAuth.setExisted(user.getName());
				message = "Account Generated";
//				System.out.println(UserEntryAuth.getExistedUser());
				printWriter.println(message);
			} else {
				message = "Account creation error";
				printWriter.println(message);
			}
			if (message.equals("Account Generated")) {
				OperationsController operation = new OperationsController();
				operation.serverOperations(inputStream, bufferedReader, outputStream, printWriter, user);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void login(InputStream inputStream, BufferedReader bufferedReader, OutputStream outputStream,
			PrintWriter printWriter) {
		try {
			String name = bufferedReader.readLine();
			String password = bufferedReader.readLine();
			String message = null;

			
			User user = null;
			System.out.println(CacheMemory.checkExistedUser(UserEntryAuth.getExistedUser(), name));
			System.out.println(CacheMemory.checkActiveUser(UserEntryAuth.getActiveUser(), name));
//			
			if (CacheMemory.checkExistedUser(UserEntryAuth.getExistedUser(), name) == true
					&& CacheMemory.checkActiveUser(UserEntryAuth.getActiveUser(), name) == false) {
				user = new User(name, password, UserController.cache.getUserBooks().get(name));
				UserEntryAuth.setActiveUser(name);
				message = "Login Successful";
				printWriter.println(message);
			} else {
				message = "Login error";
				printWriter.println(message);
			}
			if (message.equals("Login Successful")) {
				OperationsController operation = new OperationsController();
				operation.serverOperations(inputStream, bufferedReader, outputStream, printWriter, user);
			}
			
		} catch (Exception e) {

		}
	}
}
