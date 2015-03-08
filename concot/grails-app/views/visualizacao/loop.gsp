<!DOCTYPE html>
<html>
	<head>
		<title>GSP ou HTML?</title>
	</head>
	<body>
		<h1>Um loop com GSP</h1>
		<%
		  def lista = concot.Categoria.list()
		  for (item in lista) {
		%>
			<h2>${item.nome} ( ${item.id} )</h2>
		<%
			}
		%>
	</body>
</html>