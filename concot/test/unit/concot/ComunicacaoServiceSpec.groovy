package concot

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ComunicacaoService)
class ComunicacaoServiceSpec extends Specification {

	

    def setup() {
    }

    def cleanup() {
    }

    void "verificando uma simples soma"() {
    	when:
    	def valor = service.soma(2,3)
    	then:
    	valor == 5
    }

    void "verificando com ranges"() {
    	expect:
    	service.soma(primeiro, segundo) == valor
    	where:
    	primeiro | segundo | valor
    	    3    |   4     |   7
    	    1    |   7     |   8
    	    9    |   38    |   47
    }
}
