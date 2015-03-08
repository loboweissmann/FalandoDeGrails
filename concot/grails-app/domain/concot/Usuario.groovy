package concot

class Usuario {

	String login
	String senha

    static constraints = {
    	login nullable:false, blank:false, maxSize:16
    	senha nullable:false, blank:false, maxSize:312
    }
}
