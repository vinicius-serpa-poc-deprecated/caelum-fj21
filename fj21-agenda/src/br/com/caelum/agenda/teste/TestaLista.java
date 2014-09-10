package br.com.caelum.agenda.teste;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.agenda.ConnectionFactory;
import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class TestaLista {
	
	public static void main(String[] args) {
		
		ContatoDao dao = new ContatoDao(new ConnectionFactory().getConnection());
		List<Contato> contatos = dao.getLista();
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		
		for (Contato contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			System.out.println("Nascimento: " + fmt.format(contato.getDataNascimento().getTime()) + "\n");
		}

	}

}
