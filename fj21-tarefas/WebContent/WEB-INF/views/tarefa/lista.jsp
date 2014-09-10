<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
	<script type="text/javascript" src="<c:url value="js/jquery.js" />"></script>
</head>
<body>
  
  <script type="text/javascript">
  	function finalizaAgora(id) {
  		$.post("finalizaTarefa", {'id': id}, function(resposta) {  	  		
  			now = new Date();  			
  			// $("#tarefa_" + id).html("Finalizado");
  	  		// $("#data_" + id).html(now.getDate() + "/" + (now.getMonth() + 1) + "/" + now.getFullYear());
  	  		$("#tarefa_" + id).html(resposta);
  	  	});	
  	} 

  	function removerAjax(id, object) {
		$.post("removeTarefaAjax", {'id': id}, function() {
			$(object).closest("tr").hide();
		});
  	} 	
  </script>
  
  <a href="novaTarefa">Criar nova tarefa</a> 

  <br /> <br />

  <table>
  <tr>
    <th>Id</th>
    <th>Descrição</th>
    <th>Finalizado?</th>
    <th>Data de finalização</th>
    <th colspan="3">Ações</th>
  </tr>
  <c:forEach items="${tarefas}" var="tarefa">
    <tr id="tarefa_${tarefa.id}">
      <td>${tarefa.id}</td>
      <td>${tarefa.descricao}</td>
      
      <c:if test="${tarefa.finalizado eq true}">
        <td>Finalizado</td>
        <td>
			<fmt:formatDate 
	          value="${tarefa.dataFinalizacao.time}" 
	          pattern="dd/MM/yyyy"/>
	    </td>
      </c:if>
      
      <c:if test="${tarefa.finalizado eq false}">
        <td>
			<a href="#" onClick="finalizaAgora(${tarefa.id})">
			Finalizar Agora
			</a>
		</td>
        <td id="data_${tarefa.id}"></td>
      </c:if>
       
      <td><a href="mostraTarefa?id=${tarefa.id}">Alterar</a></td>
      <td><a href="removeTarefa?id=${tarefa.id}">Remover</a></td>
      <td><a href="#" onClick="removerAjax(${tarefa.id}, this)">Remover Ajax</a></td>     
    </tr>
  </c:forEach>
  </table>
</body>
</html>