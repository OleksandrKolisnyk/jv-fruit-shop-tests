package core.basesyntax.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import core.basesyntax.model.Operation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class OperationConverterStringToEnumTest {
    private static OperationConverterStringToEnum converter;

    @BeforeAll
    static void setup() {
        converter = new OperationConverterStringToEnum();
    }

    @Test
    void convertValidValueOk() {
        String inputString = "b";
        Operation operationExpected = Operation.BALANCE;
        Operation operationActual = null;
        try {
            operationActual = (Operation) converter.convert(inputString);
            assertEquals(operationExpected, operationActual);
        } catch (CsvDataTypeMismatchException e) {
            throw new RuntimeException(e);
        } catch (CsvConstraintViolationException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void convertInvalidValueExceptionOk() {
        Operation operationActual = null;
        try {
            operationActual = (Operation) converter.convert("z");
        } catch (CsvDataTypeMismatchException e) {
            return;
        } catch (CsvConstraintViolationException e) {
            return;
        } catch (RuntimeException e) {
            return;
        }
        fail("Converter with invalid input value should throws CsvDataTypeMismatchException or "
                + "CsvConstraintViolationException or RuntimeException");
    }
}
