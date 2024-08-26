//package capitalgain.adapters;
//
//import capitalgain.adapters.response.TaxResponseJSON;
//import capitalgain.domain.entities.Tax;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
//import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
//
//import javax.xml.stream.XMLStreamException;
//import java.io.IOException;
//import java.util.List;
//
//public class TestClass {
//
//    @JacksonXmlRootElement(localName = "taxes")
//    public static class TaxList {
//
//        @JacksonXmlElementWrapper(localName = "taxes")
//        @JacksonXmlProperty(localName = "tax")
//        public List<Tax> list;
//
//    }
//    public static void main(String... args) throws IOException, XMLStreamException {
//
//        var taxes = List.of(new Tax(10.0), new Tax(1505.75), new Tax(800.01));
//        var xml = fromObjectsToXML(taxes);
//        var objs = fromXMLToObjects(xml);
//        System.out.println(xml);
//        System.out.println(objs);
//    }
//
//    public static Double getValue(List<Tax> entrance) {
//        Double value = 0.0;
//        while (entrance.size() > 0) {
//            value += entrance.get(entrance.size() - 1).getValue();
//            entrance.remove(entrance.size() - 1);
//            return value + getValue(entrance);
//        }
//        return value;
//    }
//
//
//    public static String fromObjectsToXML(List<Tax> taxes) throws JsonProcessingException {
//        return new XmlAdapter().toXML(taxes);
//    }
//
//    public static List<TaxResponseJSON> fromXMLToObjects(String xml) throws IOException, XMLStreamException {
//       return new JSONAdapter().toJSON(xml);
//    }
//}
