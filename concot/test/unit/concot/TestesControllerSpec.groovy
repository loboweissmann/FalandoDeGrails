package concot

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(TestesController)
class TestesControllerSpec extends Specification {

    void "action index simples: testando o método render"() {
    	when:
    	controller.index()
    	then:
    	response.text == "Olá mundo!"
    }

    void "testando o model de uma action"() {
    	when:
    	controller.renderGSP()
    	then:"o model deve ter a chave nome"
    	model.nome != null
    	then: "o model deve ter o valor Henrique"
    	model.nome == "Henrique"
    }

    void "testando a renderização de um GSP"() {
    	when:
    	controller.renderGSP()
    	then: "renderizei a view certa?"
    	view == '/testes/renderGSP'
    }

    void "testando uma action que retorna um map"() {
    	when:
    	def model = controller.retornaMap()
    	then: "Checando o map"
    	model.nome == "Henrique"
    	model.sobrenome == "Lobo"
    }

    void "testando o retorno em XML"() {
    	when:
    	controller.renderizeXML()
    	then:
    	response.xml.@titulo.text() == "Falando de Grails"
        response.xml.@ano == 2015
        response.xml.indice.list().size() > 0
    }

    void "verificando o retorno em JSON. Será bom o livro?"() {
    	when:
    	controller.renderizeJSON()
    	then:
    	response.json.titulo == "Falando de Grails"
        response.json.ano == 2015
        response.json.capitulos.length() > 0
    }
}
