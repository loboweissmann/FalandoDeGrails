package concot.bind

import org.grails.databinding.converters.FormattedValueConverter
import java.text.SimpleDateFormat

class ExemploFormater implements FormattedValueConverter{

	def convert(value, String format) {
		def formato = format.replaceAll("data-", "")
		new SimpleDateFormat(format).parse(formato)
    }

    // O tipo de classe que o meu binder irá formatar
    Class getTargetType() {
        java.util.Date
    }

}