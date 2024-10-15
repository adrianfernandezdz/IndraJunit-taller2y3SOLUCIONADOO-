package Taller3.ParameterizedTest.services;

import java.util.stream.IntStream;

public class NumberValidatorService {

    // Método para verificar si un número es primo
    public boolean isPrime(int number) {
        if (number <= 1) return false;
        return IntStream.range(2, number).noneMatch(n -> number % n == 0);
    }

    // Método para verificar si un número es par
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    // Método para verificar si un número es positivo
    public boolean isPositive(int number) {
        return number > 0;
    }

    // Método para verificar una combinación de propiedades
    public boolean validateNumberProperties(int number, boolean expectedIsPrime, boolean expectedIsEven, boolean expectedIsPositive) {
        return isPrime(number) == expectedIsPrime
                && isEven(number) == expectedIsEven
                && isPositive(number) == expectedIsPositive;
    }
}

