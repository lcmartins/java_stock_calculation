package capitalgain.adapters;

import capitalgain.adapters.response.TaxResponse;
import capitalgain.domain.entities.Tax;
import capitalgain.domain.ports.IOperationWriter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ConsoleWriter implements IOperationWriter {

    @Override
    public void write(List<Tax> taxes) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        List<TaxResponse> responses = taxes
                .stream()
                .map(TaxResponse::toResponse).collect(Collectors.toList());

        try {
            String exit = mapper.writer().writeValueAsString(responses);
            System.out.println(exit);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw e;
        }

    }
}
