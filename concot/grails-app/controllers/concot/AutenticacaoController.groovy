package concot

class AutenticacaoController {
	static allowedMethods = [autenticar:'POST']
	
	def autenticar(Usuario usuario) {
		def registro = Usuario.findByLoginAndSenha(usuario.login, usuario.senha)
		if (registro) {
			session.usuario = registro
			redirect(controller:'cotacao')
		} else {
			flash.message = "Acesso negado"
			redirect(uri:'/')
		}
	}

}