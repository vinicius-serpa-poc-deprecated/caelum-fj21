<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum"%>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="<c:url value="css/jquery-ui.css" />" />
	<script type="text/javascript" src="<c:url value="js/jquery.js" />"></script>
	<script type="text/javascript" src="<c:url value="js/jquery-ui.js" />"></script>
	
	<script type="text/javascript" src="resources/js/jquery.js"></script>
</head>
<body>
  <h3>Alterar tarefa - ${tarefa.id}</h3>
  <form action="alteraTarefa" method="post">

    <input type="hidden" name="id" value="${tarefa.id}" />
  
    Descrição:<br />
    <textarea name="descricao" cols="100" rows="5">${tarefa.descricao}</textarea>
    <br />      

    Finalizado? <input type="checkbox" name="finalizado" 
      value="true" ${tarefa.finalizado? 'checked' : '' }/> <br /><br />      

    Data de finalização: <br />
    <fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy" var="dataFormatada" />
    <caelum:campoData id="dataFinalizacao" value="${dataFormatada }"/>    
    
    <input type="submit" value="Alterar"/>
  </form>
</body>
</html>