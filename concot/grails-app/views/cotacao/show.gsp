
<%@ page import="concot.Cotacao" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'cotacao.label', default: 'Cotacao')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-cotacao" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-cotacao" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list cotacao">
			
				<g:if test="${cotacaoInstance?.data}">
				<li class="fieldcontain">
					<span id="data-label" class="property-label"><g:message code="cotacao.data.label" default="Data" /></span>
					
						<span class="property-value" aria-labelledby="data-label"><g:formatDate date="${cotacaoInstance?.data}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${cotacaoInstance?.fornecedor}">
				<li class="fieldcontain">
					<span id="fornecedor-label" class="property-label"><g:message code="cotacao.fornecedor.label" default="Fornecedor" /></span>
					
						<span class="property-value" aria-labelledby="fornecedor-label"><g:link controller="fornecedor" action="show" id="${cotacaoInstance?.fornecedor?.id}">${cotacaoInstance?.fornecedor?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${cotacaoInstance?.item}">
				<li class="fieldcontain">
					<span id="item-label" class="property-label"><g:message code="cotacao.item.label" default="Item" /></span>
					
						<span class="property-value" aria-labelledby="item-label"><g:link controller="item" action="show" id="${cotacaoInstance?.item?.id}">${cotacaoInstance?.item?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${cotacaoInstance?.moeda}">
				<li class="fieldcontain">
					<span id="moeda-label" class="property-label"><g:message code="cotacao.moeda.label" default="Moeda" /></span>
					
						<span class="property-value" aria-labelledby="moeda-label"><g:link controller="moeda" action="show" id="${cotacaoInstance?.moeda?.id}">${cotacaoInstance?.moeda?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${cotacaoInstance?.valor}">
				<li class="fieldcontain">
					<span id="valor-label" class="property-label"><g:message code="cotacao.valor.label" default="Valor" /></span>
					
						<span class="property-value" aria-labelledby="valor-label"><g:fieldValue bean="${cotacaoInstance}" field="valor"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:cotacaoInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${cotacaoInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
