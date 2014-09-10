package br.com.caelum.agenda;

import java.sql.*;

public class ConnectionFactory {

	public Connection getConnection() {			
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
