package br.com.caelum.tarefas.controller.test;

import java.util.Collection;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.ui.Model;

import br.com.caelum.tarefas.controller.TarefasController;

public class TarefasControllerTest {

	@Test
	public void formTest() {
		TarefasController controller = new TarefasController();		
		String retorno = controller.form();
		Assert.assertEquals("tarefa/formulario", retorno);
	}
	
	@Test
	public void listaTest() {
		TarefasController controller = new TarefasController();
		MockModel model = new MockModel();
		String retorno = controller.lista(model);
		Assert.assertEquals("tarefa/lista", retorno);
	}
	
}
