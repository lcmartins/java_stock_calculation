package capitalgain.adapters.request;

import capitalgain.domain.entities.Operation;
import capitalgain.domain.entities.OperationType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OperationRequest {

    @JsonProperty("operation")
    private String operationType;

    @JsonProperty
    private Integer quantity;

    @JsonProperty("unit-cost")
    private Double unitCost;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OperationRequest{");
        sb.append("operationType='").append(operationType).append('\'');
        sb.append(", quantity=").append(quantity);
        sb.append(", unitCost=").append(unitCost);
        sb.append('}');
        return sb.toString();
    }

    public Operation parseToDomain() {
        return new Operation(
                OperationType.fromString(this.operationType),
                this.unitCost, this.quantity
        );
    }
}
