package concot

class LimiteCotacao {


	BigDecimal valorMinimo
	BigDecimal valorMaximo

	static belongsTo = [lista:ListaCotacoes, item:Item, moeda:Moeda]

    static constraints = {
    	valorMinimo: nullable:true
    	valorMaximo: nullable:true
    }
}
