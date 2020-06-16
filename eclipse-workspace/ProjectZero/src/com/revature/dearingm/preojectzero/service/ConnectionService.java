package com.revature.dearingm.preojectzero.service;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionService {
	
	private Connection connection;
	
	private static ConnectionService connectionServiceInstance = null;
	
	public static ConnectionService getInstance() {
		
		if (connectionServiceInstance == null) {
			
			connectionServiceInstance = new ConnectionService();
		}
		
		return connectionServiceInstance;
	}
	
	
	public ConnectionService() {
		try  {
			FileInputStream fis = new FileInputStream("connection.properties");
			Properties p = new Properties();
			p.load(fis);
			
			connection = DriverManager.getConnection(p.getProperty("hostname"), 
					p.getProperty("username"), p.getProperty("password"));
			
			System.out.println("Connection Established");
			
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	@Override
	public void finalize() {
		try {
			connection.close();
		} catch(Exception e) {
			
		}
	}

}
