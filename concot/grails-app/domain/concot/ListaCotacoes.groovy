package concot

class ListaCotacoes {

	String nome

	String toString() {
		"${this.nome} - ${this.id}"
	}

    static constraints = {
    	nome nullable:false, blank:false, maxSize:128, unique:false
    }
}
