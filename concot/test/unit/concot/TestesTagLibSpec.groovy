package concot

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(TestesTagLib)
class TestesTagLibSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "quando é um texto simples..."() {
    	when:
    	 def resultado = tagLib.apenasUmTexto().toString()
    	 println tagLib.apenasUmTexto().class
    	then:
    	 resultado == "Teste!"
    }

    void "usando assertOutputEquals..."() {
    	expect:
    	  assertOutputEquals "Teste!", "<g:apenasUmTexto/>"
    }

    void "e se eu quiser usar uma expressão regular?"() {
    	expect:
    	  assertOutputMatches(/.*este.*/, "<g:apenasUmTexto/>")
    }

    void "e para testar tags parametrizadas?"() {
    	expect:
    	  tagLib.comParametros(nome:"Henrique").toString == "Olá Henrique!"
    }
}
