<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
	</head>
	<body>
		
		<g:form action="enviarMensagem" useToken="true">
		<fieldset class="form">
			<h2>Contato</h2><br/>
			<g:if test="${flash.message}">
				<div style="margin: 1.0em;">${flash.message}</div>
				
			</g:if>

			<div class="${hasErrors(bean: mensagem, field: 'fornecedor.id', 'error')}">
				<label for="fornecedor">Fornecedor:</label><br/>
				<g:select from="${fornecedores}" optionKey="id" name="fornecedor.id" value="${mensagem?.fornecedor?.id}"/>
			</div>
			<br/>
			<div class="${hasErrors(bean: mensagem, field: 'email', 'error')}">
				<label for="email">E-mail:</label><br/>
				<input type="email" name="email" value="${mensagem?.email}"/>
			</div>
			<br/>
			<div class="${hasErrors(bean: mensagem, field: 'mensagem', 'error')}">
				<label for="mensagem">Mensagem:</label><br/>
				<textarea cols="80" rows="10" name="mensagem">${mensagem?.mensagem}</textarea>
			</div>
			<br/>
			<input type="submit" value="Enviar"/>
		</fieldset>
		</g:form>
	</body>
</html>