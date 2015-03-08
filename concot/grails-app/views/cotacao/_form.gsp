<%@ page import="concot.Cotacao" %>



<div class="fieldcontain ${hasErrors(bean: cotacaoInstance, field: 'data', 'error')} required">
	<label for="data">
		<g:message code="cotacao.data.label" default="Data" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="data" precision="day"  value="${cotacaoInstance?.data}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: cotacaoInstance, field: 'fornecedor', 'error')} required">
	<label for="fornecedor">
		<g:message code="cotacao.fornecedor.label" default="Fornecedor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="fornecedor" name="fornecedor.id" from="${concot.Fornecedor.list()}" optionKey="id" required="" value="${cotacaoInstance?.fornecedor?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: cotacaoInstance, field: 'item', 'error')} required">
	<label for="item">
		<g:message code="cotacao.item.label" default="Item" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="item" name="item.id" from="${concot.Item.list()}" optionKey="id" required="" value="${cotacaoInstance?.item?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: cotacaoInstance, field: 'moeda', 'error')} required">
	<label for="moeda">
		<g:message code="cotacao.moeda.label" default="Moeda" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="moeda" name="moeda.id" from="${concot.Moeda.list()}" optionKey="id" required="" value="${cotacaoInstance?.moeda?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: cotacaoInstance, field: 'valor', 'error')} required">
	<label for="valor">
		<g:message code="cotacao.valor.label" default="Valor" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="valor" value="${fieldValue(bean: cotacaoInstance, field: 'valor')}" required=""/>

</div>

