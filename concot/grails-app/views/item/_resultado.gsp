<table>
	<thead>
		<th>Nome</th>
		<th>Imagem</th>
	</thead>
	<tbody>
		<g:each in="${itens}" var="item" status="i">
		<tr class="${i % 2 == 0 ? 'even' : 'odd'}">
			<td><g:link action="show" id="${item.id}">${item.nome}</g:link></td>
			<td><concot:imagem item="${item}"/></td>
		</tr>
		</g:each>
	</tbody>
</table>