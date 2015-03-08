package concot

class AcessoFilters {
	
	def filters = {
		acesso(controller:'*', action:'*') {
			before = {
			   if (session['usuario']) {
			   		return true
			   } else {
			   		if (controllerName == null || actionName == 'autenticar') {
			   			return true // página inicial
			   		}
			   		redirect(uri:'/')
			   }
			}
		}
	}

}