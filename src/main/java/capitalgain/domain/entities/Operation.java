package capitalgain.domain.entities;


public class Operation implements IOperation {

    private OperationType operationType;
    private Integer quantity;
    private Double unitCost;

    public Operation(OperationType operationType, Double unitCost, Integer quantity) {
        this.operationType = operationType;
        this.quantity = quantity;
        this.unitCost = unitCost;
    }

    @Override
    public OperationType getOperationType() {
        return this.operationType;
    }

    @Override
    public Integer getQuantity() {
        return this.quantity;
    }


    @Override
    public Double getPrice() {
        return this.unitCost;
    }

}
