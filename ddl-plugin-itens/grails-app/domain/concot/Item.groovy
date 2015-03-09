package concot

class Item {

	String nome
	byte[] imagem
	boolean obsoleto = false
	String observacoes

	String toString() {
		this.nome
	}

	static belongsTo = [categoria:Categoria]

    static constraints = {
    	nome nullable:false, blank:false, maxSize:128
    	categoria nullable:false
    	imagem nullable:true, maxSize:65536
    	obsoleto nullable:false
    	observacoes nullable:true, blank:true, maxSize:1024
    }
}
