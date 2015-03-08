package concot

@grails.validation.Validateable
class EnvioEmail  {
	
	Fornecedor fornecedor
	String email
	String mensagem

	static constraints = {
		fornecedor nullable:false
		email nullable:false, blank:false, email:true
		mensagem nullable:false, blank:false
	}

}