package com.lms.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import com.lms.server.controller.UserController;

public class ThreadHandler implements Runnable {

	Socket clientSocket;
	public ThreadHandler(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	@Override
	public void run() {
		
		try {
			InputStream inputStream = clientSocket.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			OutputStream outputStream = clientSocket.getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream, true);
			while(true) {
				String clientChoice = bufferedReader.readLine();
				UserController userController = new UserController();
				if(clientChoice == null) {
					break;
				}
				switch(clientChoice){
				case "1":
					userController.create(inputStream, bufferedReader, outputStream, printWriter);
					break;
				case "2":
					userController.login(inputStream, bufferedReader, outputStream, printWriter);
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
