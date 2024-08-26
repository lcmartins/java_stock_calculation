package capitalgain.domain.entities;


import java.util.ArrayList;
import java.util.List;

public class OperationCalculator implements IOperationCalculator {
    public double MIN_TO_PAY_TAX = 20_000;
    public double CURRENT_TAX = 0.2;
    private Double weightedAverage = 0.0;
    private Integer quantityPurchased = 0;
    private Double losses = 0.0;
    private final List<Tax> taxes = new ArrayList<>();


    public OperationCalculator() {

    }

    public OperationCalculator(double minimumProfitToPayTax, double taxToPay) {
        this.MIN_TO_PAY_TAX = minimumProfitToPayTax;
        this.CURRENT_TAX = taxToPay;
    }

    public List<Tax> executeOperation(List<Operation> operations) {
        operations.forEach(o -> {
            this.execute(o);

        });
        return this.taxes;
    }

    private void execute(Operation operation) {
        if (operation.getOperationType() == OperationType.SELL) {
            sell(operation);
            return;
        }

        if (operation.getOperationType() == OperationType.BUY) {
            buy(operation);
        }
    }

    private void buy(Operation operation) {
        this.weightedAverage = getWeightedAverage(operation);
        this.quantityPurchased += operation.getQuantity();
        this.taxes.add(new Tax());
    }


    private void sell(Operation operation) {
        if (this.quantityPurchased < operation.getQuantity()) {
            taxes.add(new Tax("Can't sell more stocks than you have"));
            return;
        }
        if (operation.getPrice() < this.weightedAverage) {
            registerLoss(operation);
            debitQuantity(operation);
            return;
        }

        registerGains(operation);
        debitQuantity(operation);
    }

    private double getWeightedAverage(Operation operation) {
        return ((this.quantityPurchased * weightedAverage)
                + ((operation.getQuantity() * operation.getPrice())))
                / (this.quantityPurchased + operation.getQuantity());
    }

    private void registerGains(Operation operation) {
        double operationResultValue = getOperationResultValue(operation);

        if (operationResultValue >= MIN_TO_PAY_TAX) {
            if (operationResultValue >= this.losses) {
                operationResultValue = operationResultValue - this.losses;
                this.losses = 0.0;
                taxes.add(new Tax(operationResultValue * CURRENT_TAX));
            } else {
                this.losses = this.losses - operationResultValue;
                taxes.add(new Tax());
            }
        } else {
            if (operationResultValue >= this.losses) {
                this.losses = 0.0;
            } else {
                this.losses = losses - operationResultValue;
            }
            taxes.add(new Tax());
        }
    }

    private void registerLoss(Operation operation) {
        this.losses += Math.abs(getOperationResultValue(operation));
        this.taxes.add(new Tax(0.0));
    }

    private void debitQuantity(Operation operation) {
        this.quantityPurchased -= operation.getQuantity();
    }

    private double getOperationResultValue(Operation operation) {
        return operation.getQuantity() * operation.getPrice() - this.weightedAverage * operation.getQuantity();
    }

}
