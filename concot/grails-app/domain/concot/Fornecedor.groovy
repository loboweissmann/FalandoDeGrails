package concot

class Fornecedor {

	String nome
	String email

	String toString() {
		this.nome
	}

    static constraints = {
    	nome nullable:false, blank:false, maxSize:128, unique:true
    	email nullable:false, blank:false, email:true
    }
}
