import com.pagebuilder.util.CorsFilter
import com.pagebuilder.util.EnumMarshaller
import grails.converters.JSON
import org.grails.web.converters.configuration.ObjectMarshallerRegisterer

beans = {
    corsFilter(CorsFilter)

    enumMarshaller(EnumMarshaller)

    enumMarshallerRegisterer(ObjectMarshallerRegisterer) {
        marshaller = { EnumMarshaller om -> }
        converterClass = JSON
    }
}
