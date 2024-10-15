package Taller3.ParameterizedTest.test;

import java.util.stream.Stream;

import Taller3.ParameterizedTest.services.NumberValidatorService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberValidatorServiceTest {

    private final NumberValidatorService numberProperties = new NumberValidatorService();


    // Test parametrizado para verificar si un número es primo usando @ValueSource
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11})
    public void testIsPrime_ValidPrimes(int number) {
        assertTrue(numberProperties.isPrime(number));
    }

    // Test parametrizado para verificar no primos usando @ValueSource
    @ParameterizedTest
    @ValueSource(ints = {1, 4, 6, 8, 10})
    public void testIsPrime_NotPrimes(int number) {
        assertFalse(numberProperties.isPrime(number));
    }

    // Test parametrizado para verificar si un número es par usando @ValueSource
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    public void testIsEven_EvenNumbers(int number) {
        assertTrue(numberProperties.isEven(number));
    }

    // Test parametrizado para verificar que un número NO es par usando @ValueSource
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    public void testIsEven_OddNumbers(int number) {
        assertFalse(numberProperties.isEven(number));
    }

    // Test parametrizado para verificar si un número es positivo usando @ValueSource
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 100, Integer.MAX_VALUE})
    public void testIsPositive_PositiveNumbers(int number) {
        assertTrue(numberProperties.isPositive(number));
    }

    // Test parametrizado para verificar si un número NO es positivo usando @ValueSource
    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -100, 0})
    public void testIsPositive_NotPositiveNumbers(int number) {
        assertFalse(numberProperties.isPositive(number));
    }

    // Test parametrizado para verificar la combinación de propiedades usando @MethodSource
    @ParameterizedTest
    @MethodSource("provideNumberPropertiesData")
    public void testValidateNumberProperties(int number, boolean expectedIsPrime, boolean expectedIsEven, boolean expectedIsPositive, boolean expected) {
        assertEquals(expected, numberProperties.validateNumberProperties(number, expectedIsPrime, expectedIsEven, expectedIsPositive));
    }

    // Método que proporciona datos para el test de validateNumberProperties
    static Stream<Arguments> provideNumberPropertiesData() {
        return Stream.of(
                // Casos válidos
                Arguments.of(2, true, true, true, true),      // 2 es primo, par y positivo
                Arguments.of(3, true, false, true, true),     // 3 es primo, impar y positivo
                Arguments.of(4, false, true, true, true),     // 4 no es primo, es par y positivo
                Arguments.of(-5, false, false, false, true),  // -5 no es primo, no es par, no es positivo
                Arguments.of(0, false, true, false, true),    // 0 no es primo, es par, no es positivo

                // Casos inválidos
                Arguments.of(10, false, true, true, true),    // 10 no es primo pero debe fallar
                Arguments.of(7, true, true, true, false)      // 7 es primo pero no es par
        );
    }
}
