package concot

class CotacaoLista {

	Date dataInclusao

	static belongsTo = [
		lista: ListaCotacoes,
		cotacao: Cotacao
	]

    static constraints = {
    	dataInclusao nullable:false
    	lista nullable:false
    	cotacao nullable:false
    }
}
