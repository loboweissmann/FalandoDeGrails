package concot

class RenderController {

    def renderHTML() {
    	render(contentType:"text/html") {
    		table {
    			for (numero in 1..10) {
    				tr(id:numero) {
    					td(id:numero) numero
    				}
    			}
    		}
    	}
    }

    def renderJSON() {
    	render(contentType:"application/json") {
    		array {
    			for (numero in 1..10) {
    				valor(id:numero)
    			}
    		}
    	}	
    }
}
