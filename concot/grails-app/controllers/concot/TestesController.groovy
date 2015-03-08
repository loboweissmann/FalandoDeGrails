package concot

class TestesController {

    def index() { 
    	render "Olá mundo!"
    }

    def renderGSP() {
    	render view:'renderGSP', model:[nome:"Henrique"]
    }

    def retornaMap() {
    	[nome:"Henrique", sobrenome:"Lobo"]
    }

    def renderizeXML() {
        def capitulos = ["Introdução", "Groovy: uma breve introdução", 
                         "Mergulhando em Groovy", "Precisamos falar sobre Grails",
                         "Domínio e persistência", "Buscas",
                         "A camada web: controladores", "A camada web: visualização",
                         "A camada de negócios: serviços", "Testes",
                         "Plugins", "Implantação"]
    	render(contentType:"text/xml") {
    		livro(titulo:"Falando de Grails", ano:2015) {
                indice() {
                    for (capitulo in capitulos) {
                        cap(titulo:capitulo)
                    }
                }
            }
    	}
    }

    def renderizeJSON() {
    	render(contentType:"application/json") {
            [
    		  titulo:"Falando de Grails",
              ano:2015,
              capitulos:["Introdução", "Groovy: uma breve introdução", 
                         "Mergulhando em Groovy", "Precisamos falar sobre Grails",
                         "Domínio e persistência", "Buscas",
                         "A camada web: controladores", "A camada web: visualização",
                         "A camada de negócios: serviços", "Testes",
                         "Plugins", "Implantação"]
            ]
    	}
    }
}
