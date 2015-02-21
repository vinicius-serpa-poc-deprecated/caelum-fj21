package br.com.caelum.tarefas.controller.test;

import java.util.Collection;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import br.com.caelum.tarefas.controller.TarefasController;
import br.com.caelum.tarefas.dao.JdbcTarefaDao;

public class TarefasControllerTest {

	@Autowired
	private JdbcTarefaDao dao;
	
	@Test
	public void formTest() {
		TarefasController controller = new TarefasController(dao);		
		String retorno = controller.form();
		Assert.assertEquals("tarefa/formulario", retorno);
	}
	
	@Test
	public void listaTest() {
		TarefasController controller = new TarefasController(dao);
		MockModel model = new MockModel();
		String retorno = controller.lista(model);
		Assert.assertEquals("tarefa/lista", retorno);
	}
	
}
