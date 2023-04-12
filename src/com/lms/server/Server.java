package com.lms.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class Server {
	public static Set<String> activeUser = new HashSet<String>(); 
	static ExecutorService pool = null;
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9000);
			while (true) {
				Socket clientSocket = server.accept();
				
				
				ThreadHandler threadHandler = new ThreadHandler(clientSocket);
				Thread thread = new Thread(threadHandler);
				thread.start();
			}
		}catch(Exception e) {
			
		}
	}
}
