package concot

class ConcotTagLib {

	static namespace = 'concot'

    static defaultEncodeAs = [imagem:'raw']
    /**
        Renderiza uma imagem.
        @attr item O item cuja imagem será renderizada
    */
    def imagem = {attrs, body ->
    	if (attrs.item) {
    		def link = g.createLink(controller:'item', action:'imagem', id:attrs.item.id)
    		out << "<img src=\"${link}\"/>"
    	} else {
    		out << body()
    	}
    }

    def comParametros = {attrs, body ->
        out << "Olá ${attrs.nome}!"
    }

}
