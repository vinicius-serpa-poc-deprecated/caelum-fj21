<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>

<!DOCTYPE html>
<html>
<head>
	<link href="css/jquery-ui.css" rel="stylesheet">
	<script src="js/jquery.js"></script>
	<script src="js/jquery-ui.js"></script>
	
	<title>Alterar Contato</title>
</head>
<body>
	
	<c:import url="cabecalho.jsp" />

	<h1>Adiciona Contatos</h1>
    <hr />
    <form action="mvc" method="GET">
            
      <input type="hidden" name="logica" value="UpinsertContatoLogic" />
      <input type="hidden" name="id" value="${contato.id }" />
      
      Nome: <input type="text" name="nome" value="${contato.nome }" /><br />
      E-mail: <input type="text" name="email" value="${contato.email }" /><br />
      Endereço: <input type="text" name="endereco" value="${contato.endereco }" /><br />
      
      <fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" var="dataEmTexto" />
      Data Nascimento: <caelum:campoData id="dataNascimento" value="${dataEmTexto}" />              
         
      <br />
      
      <input type="submit" value="Gravar" />
    </form>
    
    <c:import url="rodape.jsp" />
    
</body>
</html>