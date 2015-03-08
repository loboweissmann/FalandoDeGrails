<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Bem vindo ao ConCot</title>
		
	</head>
	<body>
		<h1>ConCot</h1>
		<g:form action="autenticar" controller="autenticacao">
			<label for="login">Login:</label><br/>
			<g:textField name="login"/><br/>
			<label for="senha">Senha:</label><br/>
			<g:passwordField name="senha"/><br/>
			<input type="submit" value="Entrar"/>
		</g:form>
	</body>
</html>
