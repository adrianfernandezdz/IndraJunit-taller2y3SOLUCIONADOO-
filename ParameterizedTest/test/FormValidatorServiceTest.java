package Taller3.ParameterizedTest.test;

import java.util.stream.Stream;

import Taller3.ParameterizedTest.services.FormValidatorService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormValidatorServiceTest {

    FormValidatorService formValidatorService = new FormValidatorService();

    // Test parametrizado para validar nombres válidos usando @ParameterizedTest y @ValueSource
    @ParameterizedTest
    @ValueSource(strings = {"John", "Alice", "Bob"})
    public void testValidateName_ValidNames(String name) {
        assertTrue(formValidatorService.validateName(name));
    }

    // Test parametrizado para validar nombres inválidos usando @ParameterizedTest y @ValueSource
    @ParameterizedTest
    @ValueSource(strings = {"", "J", "123", "Jo1hn"})
    public void testValidateName_InvalidNames(String name) {
        assertFalse(formValidatorService.validateName(name));
    }

    // Test parametrizado para validar edades válidas usando @ParameterizedTest y @ValueSource
    @ParameterizedTest
    @ValueSource(ints = {18, 30, 50, 120})
    public void testValidateAge_ValidAges(int age) {
        assertTrue(formValidatorService.validateAge(age));
    }

    // Test parametrizado para validar edades inválidas usando @ParameterizedTest y @ValueSource
    @ParameterizedTest
    @ValueSource(ints = {17, 121, -1, 0})
    public void testValidateAge_InvalidAges(int age) {
        assertFalse(formValidatorService.validateAge(age));
    }

    // Test parametrizado para validar correos electrónicos válidos usando @ParameterizedTest y @ValueSource
    @ParameterizedTest
    @ValueSource(strings = {"test@example.com", "user.name@domain.com", "email@sub.domain.com"})
    public void testValidateEmail_ValidEmails(String email) {
        assertTrue(formValidatorService.validateEmail(email));
    }

    // Test parametrizado para validar correos electrónicos inválidos usando @ParameterizedTest y @ValueSource
    @ParameterizedTest
    @ValueSource(strings = {"test@", "invalid-email", "user@domain", "name@domain.c"})
    public void testValidateEmail_InvalidEmails(String email) {
        assertFalse(formValidatorService.validateEmail(email));
    }

    // Test parametrizado para validar contraseñas válidas usando @ParameterizedTest y @ValueSource
    @ParameterizedTest
    @ValueSource(strings = {"Password123", "MyP4ssword", "AnotherP4ss"})
    public void testValidatePassword_ValidPasswords(String password) {
        assertTrue(formValidatorService.validatePassword(password));
    }

    // Test parametrizado para validar el form usando @ParameterizedTest y @CsvSource
    @ParameterizedTest
    @CsvSource({
            "John, 25, john@example.com, Password123",
            "Alice, 30, alice@domain.com, MyP4ssword"
    })
    public void testValidateForm_ValidForm(String name, int age, String email, String password) {
        assertTrue(formValidatorService.validateForm(name, age, email, password));
    }

    // Método que provee los argumentos para el test de formularios válidos e inválidos
    static Stream<Arguments> provideFormData() {
        return Stream.of(
                // Casos válidos
                Arguments.of("John", 25, "john@example.com", "Password123", true),
                Arguments.of("Alice", 30, "alice@domain.com", "ValidP4ssword", true),

                // Casos inválidos
                Arguments.of("J", 25, "john@example.com", "Password123", false),         // Nombre inválido
                Arguments.of("John", 17, "john@example.com", "Password123", false),      // Edad inválida
                Arguments.of("John", 25, "invalid-email", "Password123", false),         // Email inválido
                Arguments.of("John", 25, "john@example.com", "short", false)             // Contraseña inválida
        );
    }

    // Test parametrizado para validar el formulario completo usando @MethodSource
    @ParameterizedTest
    @MethodSource("provideFormData")
    public void testValidateForm(String name, int age, String email, String password, boolean expected) {
        assertEquals(expected, formValidatorService.validateForm(name, age, email, password));
    }
}
