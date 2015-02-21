package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.caelum.tarefas.modelo.Tarefa;

@Repository
public class JdbcTarefaDao {

	private Connection connection;

	@Autowired
	public JdbcTarefaDao(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public JdbcTarefaDao(Connection connection) {
		this.connection = connection;
	}

	public void adiciona(Tarefa tarefa) {

		String sql = "insert into tarefas (descricao, finalizado, dataFinalizacao) values (?, ?, ?)";		
		
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, tarefa.getDescricao());
			
			stmt.setBoolean(2, false);
			stmt.setNull(3, java.sql.Types.DATE);
			/*
			stmt.setBoolean(2, tarefa.isFinalizado());
			stmt.setDate(3, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
			*/
			
			stmt.execute();			
			stmt.close();
			
		} catch (SQLException e) {
			throw new DAOException(e);
		} 
	}

	public List<Tarefa> lista() {

		try {

			List<Tarefa> tarefas = new ArrayList<Tarefa>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from tarefas");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Tarefa tarefa = new Tarefa();
				
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));		
 
				try {
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("dataFinalizacao"));
					tarefa.setDataFinalizacao(data);
				} catch(Exception e) {
					tarefa.setDataFinalizacao(null);
				}				
				
				tarefas.add(tarefa);
			}

			rs.close();
			stmt.close();

			return tarefas;

		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public Tarefa buscaPorId(long id) {

		try {

			Tarefa tarefa = new Tarefa();
			PreparedStatement stmt = this.connection.prepareStatement("select * from tarefas where id = ?");

			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				
				tarefa.setId(rs.getLong("id"));
				tarefa.setDescricao(rs.getString("descricao"));
				tarefa.setFinalizado(rs.getBoolean("finalizado"));		
 
				try {
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("dataFinalizacao"));
					tarefa.setDataFinalizacao(data);
				} catch(Exception e) {
					tarefa.setDataFinalizacao(null);
				}	
			}

			return tarefa;

		} catch (SQLException e) {
			throw new DAOException(e);
		}

	}

	public void altera(Tarefa tarefa) {
		
		String sql = "update tarefas set descricao = ?, finalizado = ?, dataFinalizacao = ? where id = ?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.isFinalizado());
			stmt.setDate(3, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));			
			stmt.setLong(4, tarefa.getId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void remove(Tarefa tarefa) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from tarefas where id = ?");
			
			stmt.setLong(1, tarefa.getId());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void remove(Long id) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from tarefas where id = ?");
			
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void finaliza(Long id) {
		
		String sql = "update tarefas set finalizado = ?, dataFinalizacao = ? where id = ?";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			java.util.Date dataAtual = new java.util.Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dataAtual);
			
			stmt.setBoolean(1, true);
			stmt.setDate(2, new Date(calendar.getTimeInMillis()));	
			stmt.setLong(3, id);
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
