<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Utilização da taglib core para recuperar o caminho absoluto. -->
<c:url value="/imagens/logo.png" var="imagem" />

<img src="${imagem }" /> 
<h2>Agenda de Contatos do Vinicius</h2>
<hr />