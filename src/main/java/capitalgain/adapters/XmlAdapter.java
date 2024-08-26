//package capitalgain.adapters;
//
//import capitalgain.domain.entities.Tax;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.dataformat.xml.XmlMapper;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
//
//import java.util.List;
//
//public class XmlAdapter {
//
//    @JacksonXmlElementWrapper(localName = "taxes")
//    @JacksonXmlProperty(localName = "tax")
//    private List<Tax> taxes;
//
//    public String toXML(List<Tax> taxes) throws JsonProcessingException {
//        XmlMapper xmlMapper = new XmlMapper();
//        this.taxes = taxes;
//        return xmlMapper.writer().writeValueAsString(this);
//    }
//}
