package com.lms.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import com.lms.client.controller.UserController;

public class Client {
	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("localhost", 9000);
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream, true);
			BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader serverResponse = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			System.out.println("Connection request sent");
			boolean running = true;
			while(running) {
				System.out.println("Press any number: \n1: Create an account \n2: Log In");
				System.out.println("----------------------------------------------------------");
				String choice = userInput.readLine();
				boolean flag = false;
				switch(choice) {
				case "1":
					flag = UserController.create(outputStream, printWriter, userInput, serverResponse, socket);
					running = flag == true ? running : false;
					break;
				case "2":
					flag = UserController.login(outputStream, printWriter, userInput, serverResponse, socket);
					running = flag == true ? running : false;
					break;
				default:
					System.out.println("Invalid choice");
					break;
				}
				
			}
		}catch(Exception e){
			
		}
	}
}
