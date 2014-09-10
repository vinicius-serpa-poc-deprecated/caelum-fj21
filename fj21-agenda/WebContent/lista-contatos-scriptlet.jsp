<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	pageEncoding="ISO-8859-1"
    import="java.util.*, br.com.caelum.agenda.dao.*, br.com.caelum.agenda.modelo.*, java.text.SimpleDateFormat"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Contatos</title>
</head>
<body>
	<table>
	<tr>
		<td>Nome</td>
		<td>Endere�o</td>
		<td>Email</td>
		<td>Nascimento</td>
	</tr>
	<%
		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.getLista();
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		String datNascimento;
		
		for (Contato contato : contatos) {
			datNascimento = fmt.format(contato.getDataNascimento().getTime());
			%>
			<tr>
				<td><%=contato.getNome() %></td>
				<td><%=contato.getEndereco() %></td>
				<td><%=contato.getEmail() %></td>
				<td><%=datNascimento %></td>
			</tr>
			<%
		}
	%>
	</table>
</body>
</html>