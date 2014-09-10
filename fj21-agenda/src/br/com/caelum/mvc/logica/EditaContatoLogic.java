package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class EditaContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		long id = Long.parseLong(req.getParameter("id"));
		
		Connection connection = (Connection) req.getAttribute("conexao");
		
		Contato contato = new ContatoDao(connection).pesquisa(id);
		req.setAttribute("contato", contato);			
		
		return "WEB-INF/jsp/altera-contato.jsp";
	}

	
	
}
