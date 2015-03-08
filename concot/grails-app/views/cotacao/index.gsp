
<%@ page import="concot.Cotacao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'cotacao.label', default: 'Cotacao')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-cotacao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-cotacao" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="data" title="${message(code: 'cotacao.data.label', default: 'Data')}" />
					
						<th><g:message code="cotacao.fornecedor.label" default="Fornecedor" /></th>
					
						<th><g:message code="cotacao.item.label" default="Item" /></th>
					
						<th><g:message code="cotacao.moeda.label" default="Moeda" /></th>
					
						<g:sortableColumn property="valor" title="${message(code: 'cotacao.valor.label', default: 'Valor')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${cotacaoInstanceList}" status="i" var="cotacaoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${cotacaoInstance.id}">${fieldValue(bean: cotacaoInstance, field: "data")}</g:link></td>
					
						<td>${fieldValue(bean: cotacaoInstance, field: "fornecedor")}</td>
					
						<td>${fieldValue(bean: cotacaoInstance, field: "item")}</td>
					
						<td>${fieldValue(bean: cotacaoInstance, field: "moeda")}</td>
					
						<td>${fieldValue(bean: cotacaoInstance, field: "valor")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${cotacaoInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
