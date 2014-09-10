package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.caelum.tarefas.modelo.Usuario;

public class JdbcUsuarioDao {

	private Connection connection;
	
	public JdbcUsuarioDao() {
		this.connection = (new ConnectionFactory()).getConnection();
	}
	
	public JdbcUsuarioDao(Connection connection) {
		this.connection = connection;
	}
	
	public boolean existeUsuario(Usuario usuario) {

		try {

			PreparedStatement stmt = this.connection.prepareStatement("select * from usuarios where login = ? and senha = ?");

			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}
	
}
