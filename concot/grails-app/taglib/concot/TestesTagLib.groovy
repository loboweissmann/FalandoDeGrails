package concot

class TestesTagLib {
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def apenasUmTexto = {atributos, corpo ->
    	out << "Teste!"
    }
}
