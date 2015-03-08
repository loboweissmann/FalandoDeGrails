package concot

import grails.test.spock.IntegrationSpec
import spock.lang.Shared

class ListaCotacoesServiceIntegrationSpec extends IntegrationSpec {

	def listaCotacoesService

	@Shared listaTeste
    @Shared listaVazia
    @Shared cotacaoValida
    @Shared cotacaoInvalida

    def setup() {
        def fornecedor = Fornecedor.findOrSaveByNomeAndEmail("Juca", "juca@juca.com")
        def categoria = Categoria.findOrSaveByNome("Equipamento")
        def item = Item.findOrSaveByCategoriaAndNome(categoria, "Motor")
        def moeda = Moeda.findOrSaveByNomeAndSimbolo("Real", 'R$')
        this.cotacaoValida = Cotacao.findOrSaveByFornecedorAndItemAndMoedaAndValorAndData(fornecedor, item, moeda, 100, new Date())
        this.listaTeste = ListaCotacoes.findOrSaveByNome("Lista de teste")
        def limite = LimiteCotacao.findOrSaveByListaAndItemAndMoeda(listaTeste, item, moeda)
        limite.valorMinimo = 10
        limite.valorMaximo = 1000
        limite.save()
        this.cotacaoInvalida = Cotacao.findOrSaveByFornecedorAndItemAndMoedaAndValorAndData(fornecedor, item, moeda, 1, new Date())
        this.listaVazia = ListaCotacoes.findOrSaveByNome("Lista vazia")
    }

    def cleanup() {
    }

    void "Auto teste"() {
    	expect:"A cotação valida deveria ser diferente de null"
    	  this.cotacaoValida != null
    	  this.cotacaoInvalida != null
    	  this.listaTeste != null
    	  this.listaVazia != null
    }
   
    void "situações esperadas para a inclusão de cotações na lista"() {
        expect:
        resultado == (listaCotacoesService.incluirCotacao(lista, cotacao, data) != null)
        where:
        lista         |   cotacao       |   data     |    resultado
        null          | null            | new Date() |      false
        listaTeste    | cotacaoValida   | new Date() |      true
        
    }

}
