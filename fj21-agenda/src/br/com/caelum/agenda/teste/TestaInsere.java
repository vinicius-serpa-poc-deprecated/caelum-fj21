package br.com.caelum.agenda.teste;

import java.sql.Connection;
import java.util.Calendar;

import br.com.caelum.agenda.ConnectionFactory;
import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) {
		
		// pronto para gravar
		 Contato contato = new Contato();
		 contato.setNome("Caelum");
		 contato.setEmail("contato@caelum.com.br");
		 contato.setEndereco("R. Vergueiro 3185 cj57");
		 contato.setDataNascimento(Calendar.getInstance());
		 
		 // grave nessa conexão!!!		 
		 ContatoDao dao = new ContatoDao(new ConnectionFactory().getConnection());
		 
		 // método elegante
		 dao.adiciona(contato);
		 
		 System.out.println("Gravado!");

	}

}
