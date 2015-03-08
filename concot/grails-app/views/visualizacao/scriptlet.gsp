<!DOCTYPE html>
<html>
	<head>
		<title>GSP ou HTML?</title>
	</head>
	<body>
		<h1>Apenas o HTML que você já conhece</h1>
		<p>Designers adoram!</p>
		<%
		// Declaro uma variável chamada data, aqui
		def data = new Date()
		%>
		<p>A propósito, agora é <%= data %></p>
	</body>
</html>