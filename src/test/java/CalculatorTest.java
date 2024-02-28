import org.example.calculator.Calculator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Имеется тест на статическую переменную класса, было необходимо задать выполнение одного теста самым первым
 * @see #getOperationCountTest()
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {

    @Test
    public void unitCheckTest() {
        Calculator calculator = new Calculator();
        assertEquals(calculator.getNumber1(), 0.0);
        assertEquals(calculator.getNumber2(), 0.0);
    }

    @Test
    public void setNumber1Test() {
        Calculator calculator = new Calculator();
        calculator.setNumber1(10.255);
        assertEquals(10.255, calculator.getNumber1());
    }

    @Test
    public void getNumber1Test() {
        Calculator calculator = new Calculator(5.7, 3.5);
        assertEquals(5.7, calculator.getNumber1());
    }

    @Test
    public void setNumber2Test() {
        Calculator calculator = new Calculator();
        calculator.setNumber2(17.20105);
        assertEquals(17.20105, calculator.getNumber2());
    }

    @Test
    public void getNumber2Test() {
        Calculator calculator = new Calculator(9.5, 0.3);
        assertEquals(0.3, calculator.getNumber2());
    }

    @ParameterizedTest
    @CsvSource({
            "17.5, -3.955, 13.545",
            "10, 5, 15",
            "20, -10, 10"
    })
    public void sumOperationTest(double num1, double num2, double expectedResult) {
        Calculator calculator = new Calculator(num1, num2);
        assertEquals(expectedResult, calculator.sum(),
                "Некорректное значение операции суммы.\n" +
                        "Ожидаемый результат: " + expectedResult + "\n" +
                        "Фактический результат: " + calculator.sum());
    }

    @ParameterizedTest
    @CsvSource({
            "20.210, -10.955, 31.165",
            "10, 5, 5",
            "-30, -10, -20"
    })
    public void subtractionOperationTest(double num1, double num2, double expectedResult) {
        Calculator calculator = new Calculator(num1, num2);
        assertEquals(expectedResult, calculator.subtraction(),
                "Некорректное значение операции разности.\n" +
                        "Ожидаемый результат: " + expectedResult + "\n" +
                        "Фактический результат: " + calculator.subtraction());
    }

    @ParameterizedTest
    @CsvSource({
            "10, 3, 3.3333",
            "10, 5, 2",
            "-30, 3, -10"
    })
    public void divisionOperationTest(double num1, double num2, double expectedResult) {
        Calculator calculator = new Calculator(num1, num2);
        assertEquals(expectedResult, calculator.division(), 0.0001,
                "Некорректное значение операции разности.\n" +
                        "Ожидаемый результат: " + expectedResult + "\n" +
                        "Фактический результат: " + calculator.division());
    }

    @Test
    public void zeroDivisionTest() {
        Calculator calculator = new Calculator(10, 0);
        assertThrows(ArithmeticException.class, calculator::division);
    }

    @ParameterizedTest
    @CsvSource({
            "-12.42, 5.4, -67.068",
            "10, 5, 50",
            "0, 10, 0"
    })
    public void multiplicationOperationTest(double num1, double num2, double expectedResult) {
        Calculator calculator = new Calculator(num1, num2);
        assertEquals(expectedResult, calculator.multiplication(),
                "Некорректное значение операции разности.\n" +
                        "Ожидаемый результат: " + expectedResult + "\n" +
                        "Фактический результат: " + calculator.multiplication());
    }

    @Test
    @Order(1)
    public void getOperationCountTest() {
        String message = "Некорректное значение кол-ва операций.";
        Calculator calculator = new Calculator(175.755, -120.400);
        assertEquals(0, calculator.getOperationCount(), message);
        calculator.sum();
        assertEquals(1, calculator.getOperationCount(), message);
        calculator.division();
        calculator.multiplication();
        calculator.subtraction();
        assertEquals(4, calculator.getOperationCount(), message);
    }

}
