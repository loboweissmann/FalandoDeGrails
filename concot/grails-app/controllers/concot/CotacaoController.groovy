package concot



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CotacaoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Cotacao.list(params), model:[cotacaoInstanceCount: Cotacao.count()]
    }

    def show(Cotacao cotacaoInstance) {
        respond cotacaoInstance
    }

    def create() {
        respond new Cotacao(params)
    }

    @Transactional
    def save(Cotacao cotacaoInstance) {
        if (cotacaoInstance == null) {
            notFound()
            return
        }

        if (cotacaoInstance.hasErrors()) {
            respond cotacaoInstance.errors, view:'create'
            return
        }

        cotacaoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'cotacao.label', default: 'Cotacao'), cotacaoInstance.id])
                redirect cotacaoInstance
            }
            '*' { respond cotacaoInstance, [status: CREATED] }
        }
    }

    def edit(Cotacao cotacaoInstance) {
        respond cotacaoInstance
    }

    @Transactional
    def update(Cotacao cotacaoInstance) {
        if (cotacaoInstance == null) {
            notFound()
            return
        }

        if (cotacaoInstance.hasErrors()) {
            respond cotacaoInstance.errors, view:'edit'
            return
        }

        cotacaoInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Cotacao.label', default: 'Cotacao'), cotacaoInstance.id])
                redirect cotacaoInstance
            }
            '*'{ respond cotacaoInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Cotacao cotacaoInstance) {

        if (cotacaoInstance == null) {
            notFound()
            return
        }

        cotacaoInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Cotacao.label', default: 'Cotacao'), cotacaoInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'cotacao.label', default: 'Cotacao'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
