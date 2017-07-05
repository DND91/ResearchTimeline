package org.chompzki.rt.data.broker;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.sql.Connection;

public class ConnectionPool {
	
	/** SINGELTON **/
	protected static ConnectionPool instance = null;
	
	public static ConnectionPool getInstance() {
		if(instance == null)
			instance = new ConnectionPool();
		return instance;
	}
	
	/** INSTANCE VARIABLES & METHODS **/
	
	protected final String databaseUrl = "jdbc:mysql://localhost:3306/timeline";
	protected final String userName = "root";
	protected final String password = "Sotis1234!!";
	
	protected ConcurrentLinkedQueue<Connection> queue = new ConcurrentLinkedQueue<Connection>();
	
	public ConnectionPool() {
		System.out.println("Loading driver...");

		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    System.out.println("Driver loaded!");
		} catch (ClassNotFoundException e) {
		    throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		}
	}
	
	public Connection get() {
		Connection con = queue.poll();
		
		if(con == null) {
			try {
				return DriverManager.getConnection(databaseUrl, userName, password);
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return con;
		}
	}
	
	public void put(Connection con) {
		queue.add(con);
	}
	
}

















