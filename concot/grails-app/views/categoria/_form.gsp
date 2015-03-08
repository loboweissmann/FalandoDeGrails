<%@ page import="concot.Categoria" %>



<div class="fieldcontain ${hasErrors(bean: categoriaInstance, field: 'nome', 'error')} required">
	<label for="nome">
		<g:message code="categoria.nome.label" default="Nome" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nome" maxlength="128" required="" value="${categoriaInstance?.nome}"/>

</div>

