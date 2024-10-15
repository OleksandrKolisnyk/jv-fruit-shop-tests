package core.basesyntax.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;

class OperationTest {

    @Test
    void getByCodeBalanceOperationOk() {
        assertEquals(Operation.BALANCE, Operation.getByCode("b"));
    }

    @Test
    void getByCodeSupplyOperationOk() {
        assertEquals(Operation.SUPPLY, Operation.getByCode("s"));
    }

    @Test
    void getByCodePurchaseOperationOk() {
        assertEquals(Operation.PURCHASE, Operation.getByCode("p"));
    }

    @Test
    void getByCodeReturnOperationOk() {
        assertEquals(Operation.RETURN, Operation.getByCode("r"));
    }

    @Test
    void getByCodeInvalidValuesRuntimeExceptionOk() {
        assertThrowsExactly(RuntimeException.class,() -> Operation.getByCode("z"));
        assertThrowsExactly(RuntimeException.class,() -> Operation.getByCode("0"));
        assertThrowsExactly(RuntimeException.class,() -> Operation.getByCode("+"));
        assertThrowsExactly(RuntimeException.class,() -> Operation.getByCode("B"));
        assertThrowsExactly(RuntimeException.class,() -> Operation.getByCode(""));
    }

    @Test
    void getCodeOk() {
        // inner class used because Enum types cannot be instantiated directly in test
        class TestItemWithOperationField {
            private Operation operation;

            public TestItemWithOperationField(Operation operation) {
                this.operation = operation;
            }
        }

        TestItemWithOperationField testItem =
                new TestItemWithOperationField(Operation.BALANCE);
        assertEquals("b",testItem.operation.getCode());
    }
}
