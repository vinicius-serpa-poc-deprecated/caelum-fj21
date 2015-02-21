package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import br.com.caelum.tarefas.modelo.Tarefa;
import br.com.caelum.tarefas.dao.JdbcTarefaDao;

@Controller
public class TarefasController {	
	
	private final JdbcTarefaDao dao;
	
	@Autowired
	public TarefasController(JdbcTarefaDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/")
	public String raiz(Model model) {
		model.addAttribute("tarefas", dao.lista());
		return "tarefa/lista";
	}
	
	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefa/formulario";
	}

	@RequestMapping("adicionaTarefa")
	public String adiciona(@Valid Tarefa tarefa, BindingResult result) {
		
		if (result.hasFieldErrors()) {					
			return "tarefa/formulario";
		}
				
		dao.adiciona(tarefa);
		return "tarefa/adicionada";
	}
	
	@RequestMapping("listaTarefas")
	public String lista(Model model) {		
		model.addAttribute("tarefas", dao.lista());
		return "tarefa/lista";
	}

	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {		
		dao.remove(tarefa);
		return "redirect:listaTarefas";
	}
	
	@RequestMapping("removeTarefaAjax")
	public void remove(Long id, HttpServletResponse response) {
		dao.remove(id);
		response.setStatus(200);
	}
	
	@RequestMapping("mostraTarefa")
	public String mostra(Long id, Model model) {	  
	  model.addAttribute("tarefa", dao.buscaPorId(id));
	  return "tarefa/mostra";
	}
	
	@RequestMapping("alteraTarefa")
	public String altera(Tarefa tarefa) {	  
	  dao.altera(tarefa);
	  return "redirect:listaTarefas";
	}
	
	
	public void finaliza(Long id, HttpServletResponse response) {		
		dao.finaliza(id);
		response.setStatus(200);
	}
	
	// Recebe um objeto do modelo na resposta
	// O objetivo é exibir a data de finalização direto do objeto
	@RequestMapping("finalizaTarefa")
	public String finalizaComRetorno(Long id, Model model) {		
		dao.finaliza(id);
		model.addAttribute("tarefa", dao.buscaPorId(id));
		return "tarefa/finalizada";
	}
	
}