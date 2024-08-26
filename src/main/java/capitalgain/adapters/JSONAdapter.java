//package capitalgain.adapters;
//
//import capitalgain.adapters.response.TaxResponseJSON;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.dataformat.xml.XmlMapper;
//
//import javax.xml.stream.XMLInputFactory;
//import javax.xml.stream.XMLStreamException;
//import javax.xml.stream.XMLStreamReader;
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//
//public class JSONAdapter {
//
//    public List<TaxResponseJSON> toJSON(String xmlTaxes) throws IOException, XMLStreamException {
//        XmlMapper xmlMapper = new XmlMapper();
//        XMLInputFactory inputFactory = XMLInputFactory.newFactory();
//        XMLStreamReader reader = inputFactory.createXMLStreamReader(new ByteArrayInputStream(xmlTaxes.getBytes(StandardCharsets.UTF_8)));
//        reader.next();
//        reader.next();
//        TypeReference<List<TaxResponseJSON>> typeReference = new TypeReference<>() {};
//        return xmlMapper.readValue(reader, typeReference);
//    }
//}
