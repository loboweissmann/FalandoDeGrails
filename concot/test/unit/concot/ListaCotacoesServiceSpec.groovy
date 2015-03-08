package concot

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification
import spock.lang.Shared
/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ListaCotacoesService)
@Mock([ListaCotacoes, Cotacao, Item, Fornecedor, Moeda, Categoria, LimiteCotacao, CotacaoLista])
class ListaCotacoesServiceSpec extends Specification {

    @Shared listaTeste
    @Shared listaVazia
    @Shared cotacaoValida
    @Shared cotacaoInvalida

    def setup() {
        def fornecedor = Fornecedor.findOrSaveByNomeAndEmail("Juca", "juca@juca.com")
        def categoria = Categoria.findOrSaveByNome("Equipamento")
        def item = Item.findOrSaveByCategoriaAndNome(categoria, "Motor")
        def moeda = Moeda.findOrSaveByNomeAndSimbolo("Real", 'R$')
        this.cotacaoValida = Cotacao.findOrSaveByFornecedorAndItemAndMoedaAndValor(fornecedor, item, moeda, 100)
        this.listaTeste = ListaCotacoes.findOrSaveByNome("Lista de teste")
        def limite = LimiteCotacao.findOrSaveByListaAndItemAndMoeda(listaTeste, item, moeda)
        limite.valorMinimo = 10
        limite.valorMaximo = 1000
        limite.save()
        this.cotacaoInvalida = Cotacao.findOrSaveByFornecedorAndItemAndMoedaAndValor(fornecedor, item, moeda, 1)
        this.listaVazia = ListaCotacoes.findOrSaveByNome("Lista vazia")
    }

    def cleanup() {
    }

    void "verificando a sanidade do serviço para uma cotação nula"() {
    	when:
    		def cotacao = null
    		def lista = new ListaCotacoes()
    		def data = new Date()
    	then:
    		service.incluirCotacao(lista, cotacao, data) == null
    }

    void "uma cotação cujo valor esteja no limite deve poder ser inserida"() {
        when:
            def fornecedor = Fornecedor.findOrSaveByNomeAndEmail("Juca", "juca@juca.com")
            def categoria = Categoria.findOrSaveByNome("Equipamento")
            def item = Item.findOrSaveByCategoriaAndNome(categoria, "Motor")
            def moeda = Moeda.findOrSaveByNomeAndSimbolo("Real", 'R$')
            def cotacao = Cotacao.findOrSaveByFornecedorAndItemAndMoedaAndValor(fornecedor, item, moeda, 100)
            def lista = ListaCotacoes.findOrSaveByNome("Lista de teste")
            def limite = LimiteCotacao.findOrSaveByListaAndItemAndMoeda(lista, item, moeda)
            limite.valorMinimo = 10
            limite.valorMaximo = 1000
            def cotacaoForaDoLimite = Cotacao.findOrSaveByFornecedorAndItemAndMoedaAndValor(fornecedor, item, moeda, 1)
            limite.save()
        then:
            service.incluirCotacao(lista, cotacao, new Date()) != null
            service.incluirCotacao(lista, cotacaoForaDoLimite, new Date()) == null

    }

    void "situações esperadas para a inclusão de cotações na lista"() {
        expect:
        resultado == (service.incluirCotacao(lista, cotacao, data) != null)
        where:
        lista      |   cotacao       |   data     |    resultado
        listaTeste | cotacaoValida   | new Date() |      true
        listaTeste | cotacaoValida   |  null      |      false
        listaTeste | cotacaoInvalida | new Date() |      false
        null       | cotacaoValida   | new Date() |      false
        listaVazia | cotacaoInvalida | new Date() |      true
        listaVazia | cotacaoValida   | new Date() |      true
    }


}
