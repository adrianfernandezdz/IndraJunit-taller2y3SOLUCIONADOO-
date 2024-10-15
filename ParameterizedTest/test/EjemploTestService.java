package Taller3.ParameterizedTest.test;

import java.util.stream.Stream;

import Taller3.ParameterizedTest.services.EjemploService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EjemploTestService {

    private final EjemploService mathService = new EjemploService();

    // Ejemplo usando @ValueSource para pasar múltiples valores a isEven
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    void testIsEvenWithValueSource(int number) {
        assertTrue(mathService.isEven(number), number + " should be even");
    }

    // Ejemplo usando @CsvSource para pasar múltiples pares de valores a add
    @ParameterizedTest
    @CsvSource({
            "1, 1, 2",
            "2, 3, 5",
            "-1, 1, 0",
            "10, -5, 5"
    })
    void testAddWithCsvSource(int a, int b, int expectedSum) {
        assertEquals(expectedSum, mathService.add(a, b), "Sum of " + a + " and " + b + " should be " + expectedSum);
    }

    // Ejemplo usando @MethodSource para pasar múltiples pares de valores a multiply
    @ParameterizedTest
    @MethodSource("provideNumbersForMultiply")
    void testMultiplyWithMethodSource(int a, int b, int expectedProduct) {
        assertEquals(expectedProduct, mathService.multiply(a, b), "Product of " + a + " and " + b + " should be " + expectedProduct);
    }

    // Método que provee los datos para el @MethodSource
    static Stream<Arguments> provideNumbersForMultiply() {
        return Stream.of(
                Arguments.of(2, 3, 6),
                Arguments.of(5, 4, 20),
                Arguments.of(-2, 3, -6),
                Arguments.of(0, 7, 0)
        );
    }

    // Ejemplo usando @StringSource para probar diferentes cadenas en repeatString
    @ParameterizedTest
    @ValueSource(strings = {"a", "abc", "hello"})
    void testRepeatStringWithStringSource(String input) {
        String result = mathService.repeatString(input, 3);
        assertEquals(input + input + input, result, "String '" + input + "' repeated 3 times should be '" + input + input + input + "'");
    }
}