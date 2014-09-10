package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaPesquisa {

	public static void main(String[] args) {
		
		ContatoDao dao = new ContatoDao();
		Contato contato = dao.pesquisa(1);
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		
		if (contato.getNome() != null) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			System.out.println("Nascimento: " + fmt.format(contato.getDataNascimento().getTime()) + "\n");
		}			

	}

}
