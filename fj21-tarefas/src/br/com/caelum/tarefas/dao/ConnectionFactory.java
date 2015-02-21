package br.com.caelum.tarefas.dao;

import java.sql.*;

// A classe ConnectionFactory foi substituida pela configuração do bean no spring-context.xml, para o Controller
public class ConnectionFactory {

	public Connection getConnection() {			
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "yetsnap");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
