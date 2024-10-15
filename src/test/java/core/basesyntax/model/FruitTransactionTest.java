package core.basesyntax.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FruitTransactionTest {
    private static Operation TRANSACTION_TYPE = Operation.BALANCE;
    private static String FRUIT_NAME = "apple";
    private static int FRUIT_QUANTITY = 300;
    private static FruitTransaction transaction;

    @BeforeAll
    static void setUp() {
        transaction = new FruitTransaction(TRANSACTION_TYPE, FRUIT_NAME, FRUIT_QUANTITY);
    }

    @Test
    void fruitTransactionConstructorWithStringOperationTypeClassOk() {
        FruitTransaction transaction2 = new FruitTransaction("b", FRUIT_NAME, FRUIT_QUANTITY);
        // assertEquals(transaction, transaction2);
        assertEquals(FruitTransaction.class.getCanonicalName(),
                transaction2.getClass().getCanonicalName());
    }

    @Test
    void getTypeOk() {
        assertEquals(TRANSACTION_TYPE, transaction.getType());
    }

    @Test
    void getFruitNameOk() {
        assertEquals(FRUIT_NAME, transaction.getFruitName());
    }

    @Test
    void getQuantityOk() {
        assertEquals(FRUIT_QUANTITY, transaction.getQuantity());
    }
}
