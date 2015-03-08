package concot

import grails.transaction.Transactional

@Transactional
class ListaCotacoesService {

	/**
		Verifica os limites
	*/
	private boolean testeLimites(ListaCotacoes lista, Cotacao cotacao) {
		def limite = LimiteCotacao.findByItemAndListaAndMoeda(cotacao.item, lista, cotacao.moeda)
			if ( limite &&
				 ((limite.valorMaximo && cotacao.valor > limite.valorMaximo) ||
				  (limite.valorMinimo && cotacao.valor < limite.valorMinimo) ))
			 {
				return false
			 } 
		
		true
	}

    def incluirCotacao(ListaCotacoes lista, Cotacao cotacao, Date data) {
    	if (ListaCotacoes.get(lista?.id) && 
    		Cotacao.get(cotacao?.id) && data && testeLimites(lista, cotacao)) {
    		println "Cheguei aqui"
    		def item = new CotacaoLista(cotacao:cotacao, lista:lista, dataInclusao:data)
    		return item.save(flush:true)
    	}
    	null
    }
}
