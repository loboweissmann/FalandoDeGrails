package concot

import grails.transaction.Transactional

@Transactional
class ComunicacaoService {

    def enviarMensagem(Fornecedor fornecedor, 
					   String email,
					   String mensagem) {
		// Executa a tarefa de envio de e-mail
	}

	def soma(x, y) {
		x + y
	}
}
