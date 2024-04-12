<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Contas Bancárias - Modo Administrador</title>

<link rel="stylesheet" type="text/css" href="css/template2.css">
<link rel="stylesheet" type="text/css" href="css/mAdmin2.css">


</head>


<body>

	<header>

		<h1>Modo Administrador</h1>

	</header>
	<nav>

		<ul>
			<li><a href="index.html">Home |</a></li>
			<li><a href="modoAdmin.jsp" style="color: rgb(102, 153, 204)">
					Modo Administrador <span style="color: white">|</span>
				</a></li>
			<li><a href="cadastrarCC.jsp">Cadastrar Conta Corrente |</a></li>
			<li><a href="cadastrarCP.jsp">Cadastrar Conta Poupança </a></li>
		</ul>

	</nav>

	<main>

		<div>

			<form action="SvModoAdmin" method="GET">
				<input type="hidden" name="acao" value="criarBanco">
				<button type="submit">Criar Banco de Dados e Tabelas</button>
			</form>

			<form action="SvModoAdmin" method="GET">
				<input type="hidden" name="acao" value="deletarBanco">
				<button type="submit">Deletar Banco de Dados</button>
			</form>
			<br>
			<br>
			<br>
			<p class="cErro">
				<%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg")%>
			</p>

		</div>


	</main>


	<footer></footer>


</body>


</html>