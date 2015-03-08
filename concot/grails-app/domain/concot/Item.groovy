package concot

class Item {

	String nome
	byte[] imagem

	String toString() {
		this.nome
	}

	static belongsTo = [categoria:Categoria]

    static constraints = {
    	nome nullable:false, blank:false, maxSize:128
    	categoria nullable:false
    	imagem nullable:true, maxSize:65536
    }
}
