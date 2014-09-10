package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import br.com.caelum.tarefas.modelo.Tarefa;
import br.com.caelum.tarefas.dao.JdbcTarefaDao;

@Controller
public class TarefasController {

	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefa/formulario";
	}

	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
		
		if (result.hasFieldErrors("descricao")) {
			return "tarefa/formulario";
		}
		
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}
	
	@RequestMapping("listaTarefas")
	public String lista(Model model) {
		JdbcTarefaDao dao = new JdbcTarefaDao();
		model.addAttribute("tarefas", dao.lista());
		return "tarefa/lista";
	}

	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.remove(tarefa);
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("removeTarefaAjax")
	public void remove(Long id, HttpServletResponse response) {
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.remove(id);
		response.setStatus(200);
	}
	
	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) {
	  JdbcTarefaDao dao = new JdbcTarefaDao();
	  model.addAttribute("tarefa", dao.buscaPorId(id));
	  return "tarefa/mostra";
	}
	
	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {
	  JdbcTarefaDao dao = new JdbcTarefaDao();
	  dao.altera(tarefa);
	  return "redirect:listaTarefas";
	}
	
	
	public void finaliza(Long id, HttpServletResponse response) {
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.finaliza(id);
		response.setStatus(200);
	}
	
	// Recebe um objeto do modelo na resposta
	// O objetivo é exibir a data de finalização direto do objeto
	@RequestMapping("finalizaTarefa")
	public String finalizaComRetorno(Long id, Model model) {
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.finaliza(id);
		model.addAttribute("tarefa", dao.buscaPorId(id));
		return "tarefa/finalizada";
	}
	
}