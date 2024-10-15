package Taller2.TDDAsserts;

import java.util.HashMap;
import java.util.Map;

public class CarritoCompraTDDService {

    private Map<String, Integer> cartItems = new HashMap<>(); // Nombre del producto y cantidad

    // Añadir producto al carrito
    public void addProduct(String productName, int quantity) {
        cartItems.put(productName, cartItems.getOrDefault(productName, 0) + quantity);
    }

    // Eliminar producto del carrito
    public void removeProduct(String productName) {
        cartItems.remove(productName);
    }

    // Obtener la cantidad de un producto
    public int getProductQuantity(String productName) {
        return cartItems.getOrDefault(productName, 0);
    }

    // Obtener el total de productos en el carrito
    public int getTotalProducts() {
        return cartItems.values().stream().mapToInt(Integer::intValue).sum();
    }

    // Calcular el costo total del carrito
    public double calculateTotal(Map<String, Double> productPrices) {
        return cartItems.entrySet().stream()
                .mapToDouble(entry -> entry.getValue() * productPrices.getOrDefault(entry.getKey(), 0.0))
                .sum();
    }

    // Vaciar el carrito
    public void clearCart() {
        cartItems.clear();
    }
}
