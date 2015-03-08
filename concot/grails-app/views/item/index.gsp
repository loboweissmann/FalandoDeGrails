
<%@ page import="concot.Item" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'item.label', default: 'Item')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		
		<asset:javascript src="jquery.js"/>
		
	</head>
	<body>
		<a href="#list-item" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		
		

		<g:formRemote name="formBusca" url="[controller:'item', action:'busca']" update="resultado" style="padding: 1.0em;">
			Buscar item: <g:textField name="nome"/> <input type="submit" value="Buscar"/>
		</g:formRemote>

		<div id="resultado">

		</div>

		</div>
	</body>
</html>
