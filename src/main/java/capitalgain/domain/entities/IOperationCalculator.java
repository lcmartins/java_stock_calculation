package capitalgain.domain.entities;

import java.util.List;

public interface IOperationCalculator {

    List<Tax> executeOperation(List<Operation> operations);
}
