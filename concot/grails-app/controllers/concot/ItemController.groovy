package concot



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ItemController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def busca() {
        def itens = Item.findAllByNomeLike("%${params['nome']}%")

        render(template:'resultado', model:[itens:itens])
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Item.list(params), model:[itemInstanceCount: Item.count()]
    }

    def show(Item itemInstance) {
        respond itemInstance
    }

    def imagem(long id) {
        def item = Item.get(id)
        if (item?.imagem) {
            response.outputStream << item.imagem
        }
    }

    def create() {
        respond new Item(params)
    }

    @Transactional
    def save(Item itemInstance) {
        if (itemInstance == null) {
            notFound()
            return
        }

        if (itemInstance.hasErrors()) {
            respond itemInstance.errors, view:'create'
            return
        }

        itemInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'item.label', default: 'Item'), itemInstance.id])
                redirect itemInstance
            }
            '*' { respond itemInstance, [status: CREATED] }
        }
    }

    def edit(Item itemInstance) {
        respond itemInstance
    }

    @Transactional
    def update(Item itemInstance) {
        if (itemInstance == null) {
            notFound()
            return
        }

        if (itemInstance.hasErrors()) {
            respond itemInstance.errors, view:'edit'
            return
        }

        itemInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Item.label', default: 'Item'), itemInstance.id])
                redirect itemInstance
            }
            '*'{ respond itemInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Item itemInstance) {

        if (itemInstance == null) {
            notFound()
            return
        }

        itemInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Item.label', default: 'Item'), itemInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'item.label', default: 'Item'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
