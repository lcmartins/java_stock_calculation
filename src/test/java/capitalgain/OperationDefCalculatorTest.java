package capitalgain;


import capitalgain.domain.entities.OperationType;
import capitalgain.domain.entities.OperationCalculator;
import capitalgain.domain.entities.Operation;
import capitalgain.domain.entities.Tax;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OperationDefCalculatorTest {
    private final OperationType BUY = OperationType.fromString("buy");
    private final OperationType SELL = OperationType.fromString("sell");


    @Test
    void test_case_1() {
        OperationCalculator operationCalculator = new OperationCalculator();
        Operation stockOperation = new Operation(BUY, 10.0, 100);
        Operation stockOperation2 = new Operation(SELL, 15.0, 50);
        Operation stockOperation3 = new Operation(SELL, 15.0, 50);

        List<Tax> result = operationCalculator.executeOperation(List.of(stockOperation, stockOperation2, stockOperation3));


        assertEquals(0.0, result.get(0).getValue());
        assertEquals(0.0, result.get(1).getValue());
        assertEquals(0.0, result.get(2).getValue());
    }

    @Test
    void test_case_2() {
        OperationCalculator operationCalculator = new OperationCalculator();
        Operation stockOperation = new Operation(BUY, 10.0, 10_000);
        Operation stockOperation2 = new Operation(SELL, 20.0, 5_000);
        Operation stockOperation3 = new Operation(SELL, 5.0, 5_000);

        List<Tax> result = operationCalculator.executeOperation(List.of(stockOperation, stockOperation2, stockOperation3));


        assertEquals(0.0, result.get(0).getValue());
        assertEquals(10_000, result.get(1).getValue());
        assertEquals(0.0, result.get(2).getValue());
    }

    @Test
    void test_case_3() {
        OperationCalculator operationCalculator = new OperationCalculator();
        Operation stockOperation = new Operation(BUY, 10.0, 10_000);
        Operation stockOperation2 = new Operation(SELL, 5.0, 5_000);
        Operation stockOperation3 = new Operation(SELL, 20.0, 3_000);

        List<Tax> result = operationCalculator.executeOperation(List.of(stockOperation, stockOperation2, stockOperation3));

        assertEquals(0.0, result.get(0).getValue());
        assertEquals(0.0, result.get(1).getValue());
        assertEquals(1_000, result.get(2).getValue());
    }

    @Test
    void test_case_4() {
        OperationCalculator operationCalculator = new OperationCalculator();
        Operation stockOperation = new Operation(BUY, 10.0, 10_000);
        Operation stockOperation2 = new Operation(BUY, 25.0, 5_000);
        Operation stockOperation3 = new Operation(SELL, 15.0, 10_000);

        List<Tax> result = operationCalculator.executeOperation(List.of(stockOperation, stockOperation2, stockOperation3));

        assertEquals(0.0, result.get(0).getValue());
        assertEquals(0.0, result.get(1).getValue());
        assertEquals(0.0, result.get(2).getValue());
    }

    @Test
    void test_case_5() {
        OperationCalculator operationCalculator = new OperationCalculator();
        Operation stockOperation = new Operation(BUY, 10.0, 10_000);
        Operation stockOperation2 = new Operation(BUY, 25.0, 5_000);
        Operation stockOperation3 = new Operation(SELL, 15.0, 10_000);
        Operation stockOperation4 = new Operation(SELL, 25.0, 5_000);

        List<Tax> result = operationCalculator
                .executeOperation(List.of(stockOperation, stockOperation2, stockOperation3, stockOperation4));


        assertEquals(0.0, result.get(0).getValue());
        assertEquals(0.0, result.get(1).getValue());
        assertEquals(0.0, result.get(2).getValue());
        assertEquals(10_000, result.get(3).getValue());
    }

    @Test
    void test_case_6() {
        OperationCalculator operationCalculator = new OperationCalculator();
        Operation stockOperation = new Operation(BUY, 10.0, 10_000);
        Operation stockOperation2 = new Operation(SELL, 2.0, 5_000);
        Operation stockOperation3 = new Operation(SELL, 20.0, 2_000);
        Operation stockOperation4 = new Operation(SELL, 20.0, 2_000);
        Operation stockOperation5 = new Operation(SELL, 25.0, 1_000);

        List<Tax> result = operationCalculator
                .executeOperation(List.of(stockOperation,
                        stockOperation2,
                        stockOperation3,
                        stockOperation4,
                        stockOperation5));


        assertEquals(0.0, result.get(0).getValue());
        assertEquals(0.0, result.get(1).getValue());
        assertEquals(0.0, result.get(2).getValue());
        assertEquals(0.0, result.get(3).getValue());
        assertEquals(0.0, result.get(4).getValue());
    }

    @Test
    void test_case_7() {
        OperationCalculator operationCalculator = new OperationCalculator();
        Operation stockOperation = new Operation(BUY, 10.0, 10_000);
        Operation stockOperation2 = new Operation(SELL, 2.0, 5_000);
        Operation stockOperation3 = new Operation(SELL, 20.0, 2_000);
        Operation stockOperation4 = new Operation(SELL, 20.0, 2_000);
        Operation stockOperation5 = new Operation(SELL, 25.0, 1_000);

        Operation stockOperation6 = new Operation(BUY, 20.0, 10_000);
        Operation stockOperation7 = new Operation(SELL, 15.0, 5_000);
        Operation stockOperation8 = new Operation(SELL, 30.0, 4_350);
        Operation stockOperation9 = new Operation(SELL, 30.0, 650);


        List<Tax> result = operationCalculator
                .executeOperation(List.of(stockOperation,
                        stockOperation2,
                        stockOperation3,
                        stockOperation4,
                        stockOperation5,
                        stockOperation6,
                        stockOperation7,
                        stockOperation8,
                        stockOperation9));


        assertEquals(0.0, result.get(0).getValue());
        assertEquals(0.0, result.get(1).getValue());
        assertEquals(0.0, result.get(2).getValue());
        assertEquals(0.0, result.get(3).getValue());
        assertEquals(0.0, result.get(4).getValue());

        assertEquals(0.0, result.get(5).getValue());
        assertEquals(0.0, result.get(6).getValue());
        assertEquals(3_700, result.get(7).getValue());
        assertEquals(0.0, result.get(8).getValue());
    }

    @Test
    void test_case_8() {
        OperationCalculator operationCalculator = new OperationCalculator();
        Operation stockOperation = new Operation(BUY, 10.0, 10_000);
        Operation stockOperation2 = new Operation(SELL, 50.0, 10_000);
        Operation stockOperation3 = new Operation(BUY, 20.0, 10_000);
        Operation stockOperation4 = new Operation(SELL, 50.0, 10_000);


        List<Tax> result = operationCalculator
                .executeOperation(List.of(stockOperation,
                        stockOperation2,
                        stockOperation3,
                        stockOperation4));


        assertEquals(0.0, result.get(0).getValue());
        assertEquals(80_000, result.get(1).getValue());
        assertEquals(0.0, result.get(2).getValue());
        assertEquals(60_000, result.get(3).getValue());
    }

    @Test
    void test_sell_more_than_exists() {
        OperationCalculator operationCalculator = new OperationCalculator();
        Operation stockOperation = new Operation(BUY, 10.0, 100);
        Operation stockOperation2 = new Operation(SELL, 15.0, 101);
        Operation stockOperation3 = new Operation(SELL, 15.0, 50);

        List<Tax> result = operationCalculator.executeOperation(List.of(stockOperation, stockOperation2, stockOperation3));


        assertEquals(0.0, result.get(0).getValue());
        assertEquals(null, result.get(1).getValue());
        assertEquals("Can't sell more stocks than you have", result.get(1).getMessage());
        assertEquals(0.0, result.get(2).getValue());
    }
}