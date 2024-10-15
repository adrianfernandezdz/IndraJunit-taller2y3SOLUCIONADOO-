package Taller3.ParameterizedTest.services;

public class EjemploService {
    // Método que suma dos números
    public int add(int a, int b) {
        return a + b;
    }

    // Método que verifica si un número es par
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    // Método que multiplica dos números
    public int multiply(int a, int b) {
        return a * b;
    }

    // Método que repite un string varias veces
    public String repeatString(String str, int times) {
        return str.repeat(times);
    }
}
