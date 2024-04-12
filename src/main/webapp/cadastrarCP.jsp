<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Contas Bancárias</title>

<link rel="stylesheet" type="text/css" href="css/template2.css">
<link rel="stylesheet" type="text/css" href="css/cadastrar2.css">

</head>


<body>

	<header>

		<h1>Contas Bancárias</h1>

	</header>
	<nav>

		<ul>
			<li><a href="index.html">Home |</a></li>
			<li><a href="modoAdmin.jsp">Modo Administrador |</a></li>
			<li><a href="cadastrarCC.jsp">Cadastrar Conta Corrente |</a></li>
			<li><a href="cadastrarCP.jsp" style="color: rgb(102, 153, 204)">Cadastrar
					Conta Poupança </a></li>
		</ul>

	</nav>

	<main>

		<form id="form-2" action="SvCadastrarCP" method="get">

			<label for="iagencia">Agência:</label>
			<br>
			<input id="iagencia" placeholder="" type="text" name="agencia"
				value="<%=request.getParameter("agencia") == null ? "" : request.getParameter("agencia")%>">
			<br>
			<label for="iNrConta">Número da Conta:</label>
			<br>
			<input id="iNrConta" placeholder="" type="text" name="nrConta"
				value="<%=request.getParameter("nrConta") == null ? "" : request.getParameter("nrConta")%>" />
			<br>
			<label for="ititular">Titular:</label>
			<br>
			<input id="ititular" placeholder="" type="text" name="titular"
				value="<%=request.getParameter("titular") == null ? "" : request.getParameter("titular")%>" />
			<br>
			<label for="isaldo">Saldo:</label>
			<br>
			<input id="isaldo" placeholder="" type="text" name="saldo"
				value="<%=request.getParameter("saldo") == null ? "" : request.getParameter("saldo")%>" />
			<br>
			<label for="irendimento">Rendimento:</label>
			<br>
			<input id="irendimento" placeholder="" type="text" name="rendimento"
				value="<%=request.getParameter("rendimento") == null ? "" : request.getParameter("rendimento")%>" />
			<br> <br> <br>

			<input type="submit" value="Cadastrar" id="button-2" class="cbotao">

			<br> <br>

			<p class="cErro">
				<%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg")%>
			</p>


		</form>


	</main>


	<footer></footer>


</body>


</html>