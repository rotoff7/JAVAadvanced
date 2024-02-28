import org.example.calculator.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private static final String[] allSymbols = new String[]{
            " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "!", "@", "#", "$", "%",
            "^", "&", "(", ")", "=", "[", "{", "]", "}", ";",
            ":", "'", "|", ",", "<", ".", ">", "?"};

    @ParameterizedTest
    @CsvSource({"/", "*", "+", "-"})
    public void setValidOperationTest(String sign) {
        Calculator calculator = new Calculator();
        calculator.setOperation(sign);
        assertEquals(sign, calculator.getOperation(),
                "Присвоен некорректный знак операции");
    }

    @Test
    public void setInvalidOperationTest1() {
        Calculator calculator = new Calculator();
        for (String sign : allSymbols) {
            assertThrows(IllegalArgumentException.class, () -> calculator.setOperation(sign),
                    "Система приняла символ \"" + sign + "\" в качестве валидной операции\n");
        }
    }

    @ParameterizedTest
    @MethodSource("symbolsProvider")
    public void setInvalidOperationTest2(String sign) {
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.setOperation(sign),
                "Система приняла символ \"" + sign + "\" в качестве валидной операции\n");
    }

    private static Stream<String> symbolsProvider() {
        return Stream.of(allSymbols);
    }
}
