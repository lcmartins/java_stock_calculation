package capitalgain.domain.entities;

public interface IOperation {
    OperationType getOperationType();
    Integer getQuantity();
    Double getPrice();
}
