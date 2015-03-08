package concot

class Cotacao {

	BigDecimal valor
	Date data

	static belongsTo = [item:Item, moeda:Moeda, fornecedor:Fornecedor]

	

}
