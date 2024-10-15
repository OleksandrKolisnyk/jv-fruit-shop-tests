package core.basesyntax.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FruitItemTest {
    private static String FRUIT_NAME = "apple";
    private static int FRUIT_QUANTITY = 10;
    private static FruitItem fruitItem;

    @BeforeAll
    static void setUp() {
        fruitItem = new FruitItem(FRUIT_NAME, FRUIT_QUANTITY);
    }

    @Test
    void getNameOk() {
        assertEquals(FRUIT_NAME, fruitItem.getName());
    }

    @Test
    void getQuantityOk() {
        assertEquals(FRUIT_QUANTITY, fruitItem.getQuantity());
    }

    @Test
    void toStringContainsClassNameOk() {
        String fruitItemToStingActual = fruitItem.toString();
        assertTrue(fruitItemToStingActual.contains("FruitItem"),
                "fruitItem.toSting() must contains class name");
    }

    @Test
    void toStringContainsItemNameOk() {
        String fruitItemToStingActual = fruitItem.toString();
        assertTrue(fruitItemToStingActual.contains(FRUIT_NAME),
                "fruitItem.toSting() must contains item name");
    }

    @Test
    void toStringContainsItemQuantityOk() {
        String fruitItemToStingActual = fruitItem.toString();
        assertTrue(fruitItemToStingActual.contains(String.valueOf(FRUIT_QUANTITY)),
                "fruitItem.toSting() must contains item Quantity");
    }
}
