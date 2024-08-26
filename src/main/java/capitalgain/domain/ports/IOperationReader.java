package capitalgain.domain.ports;

import capitalgain.domain.entities.Operation;

import java.io.IOException;
import java.util.List;

public interface IOperationReader {
    List<Operation> read() throws IOException;
}
