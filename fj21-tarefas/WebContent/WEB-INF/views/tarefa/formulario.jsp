<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
  <body>
    <h3>Adicionar tarefas</h3>
    
    <form:errors path="tarefa.descricao"/> /  <form:errors path="tarefa.peso"/>
    <form action="adicionaTarefa" method="post">
      
      Descrição: <br />
      <textarea name="descricao" rows="5" cols="100">${tarefa.descricao }</textarea><br />
      
      Peso: <br />
      <input name="peso" type="text" value="${tarefa.peso }"><br />
      
      <input type="submit" value="Adicionar">
    </form>
  </body>
</html>