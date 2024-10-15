package core.basesyntax.db;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StorageTest {
    private static Storage storage;

    @BeforeAll
    static void setup() {
        storage = new Storage();
    }

    @Test
    void newStorageSizeIsZerroOk() {
        assertEquals(0, storage.fruits.size());
    }
}
