<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
	<head>
		<title>Lista de Contatos com JSTL</title>
	</head>
	<body>
		
		<c:import url="cabecalho.jsp" />
		
		<!-- Cria o Dao - substituido pela logica do servlet (o servlet passa a lista de contatos) -->
		<!-- <jsp:useBean id="dao" class="br.com.caelum.agenda.dao.ContatoDao"></jsp:useBean> -->
		
		<table border="1" cellpadding="2">
			<tr>
				<td><b>Nome</b></td>
				<td><b>Endereço</b></td>
				<td><b>Email</b></td>
				<td><b>Nascimento</b></td>
				<td><b>Ação</b></td>
			</tr>
		
			<!-- percorre contatos montando as linhas da tabela -->
			<c:forEach var="contato" items="${contatos}" varStatus="id">
				<tr bgcolor="${id.count % 2 == 0 ? '#aaee88' : '#ffffff' }">
					<td>${contato.nome}</td>
					<td>
						<!-- Estrutura de IF simulando um ELSE em JSTL -->
						<c:if test="${not empty contato.email}">
							<a href="mailto:${contato.email}">${contato.email}</a>
						</c:if>								
						<c:if test="${empty contato.email }">
							E-mail não informado
						</c:if>			
					</td>
					<td>
						<!-- Estrutura de switch simulando um ELSE em JSTL -->
						<c:choose>
						  <c:when test="${not empty contato.endereco}">
						    ${contato.endereco}
						  </c:when>
						  <c:otherwise>
						    Endereço não informado
						  </c:otherwise>
						</c:choose>
					</td>
					<td>
						<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" />
					</td>
					<td>
				      	<a href="mvc?logica=EditaContatoLogic&id=${contato.id}">Alterar</a>
				    |
				      	<a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
				    </td>
				</tr>
			</c:forEach>
			
		</table>
		
		<a href="mvc?logica=NovoContatoLogic">Novo Contato</a>
		
		<c:import url="rodape.jsp" />
		
	</body>
</html>