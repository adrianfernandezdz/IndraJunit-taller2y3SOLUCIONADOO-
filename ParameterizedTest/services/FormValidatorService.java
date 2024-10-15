package Taller3.ParameterizedTest.services;

public class FormValidatorService {

    // Método para validar el nombre: debe tener al menos 2 caracteres y no contener números
    public boolean validateName(String name) {
        return name != null && name.length() >= 2 && name.matches("[a-zA-Z]+");
    }

    // Método para validar la edad: debe estar entre 18 y 120 años
    public boolean validateAge(int age) {
        return age >= 18 && age <= 120;
    }

    // Método para validar el correo electrónico
    public boolean validateEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email != null && email.matches(emailRegex);
    }

    // Método para validar la contraseña: debe tener al menos 8 caracteres y contener una letra mayúscula, una minúscula y un número
    public boolean validatePassword(String password) {
        return password != null && password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[a-z].*") &&
                password.matches(".*\\d.*");
    }

    // Método que valida todo el formulario
    public boolean validateForm(String name, int age, String email, String password) {
        return validateName(name) && validateAge(age) && validateEmail(email) && validatePassword(password);
    }
}
