package capitalgain.domain.ports;

import capitalgain.domain.entities.Tax;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface IOperationWriter {
    void write(List<Tax> taxes) throws JsonProcessingException;
}
