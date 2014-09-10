package br.com.caelum.agenda.teste;

import java.sql.Connection;

import br.com.caelum.agenda.ConnectionFactory;
import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class TestaAtualizacao {

	public static void main(String[] args) {
		
		Connection connection = new ConnectionFactory().getConnection();
		
		ContatoDao dao = new ContatoDao(connection);
		Contato contato = dao.pesquisa(1);
		
		if (contato.getNome() != null) {
			contato.setNome("Vinicius");
			dao.altera(contato);
		}			

	}

}
