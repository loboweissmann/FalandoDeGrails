<div class="item">
	<div class="categoria">${item?.categoria?.nome}</div>
	<div class="nome">
		<g:link action="show" controller="item" id="${item?.id}">
		${item?.nome}
		</g:link>
		<concot:imagem item="${item}">
		  <p>Sem imagem :(</p>
		</concot:imagem>
	</div>
</div>
