package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaAtualizacao {

	public static void main(String[] args) {
		
		ContatoDao dao = new ContatoDao();
		Contato contato = dao.pesquisa(1);
		
		if (contato.getNome() != null) {
			contato.setNome("Vinicius");
			dao.altera(contato);
		}			

	}

}
