package Taller2.TDDAsserts;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarritoCompraTDDServiceTest {

    private CarritoCompraTDDService carritoService;

    @BeforeEach
    public void setup() {
        carritoService = new CarritoCompraTDDService();
    }

    @Test
    public void testAddProduct() {
        carritoService.addProduct("Apple", 3);
        assertEquals(3, carritoService.getProductQuantity("Apple"));
    }

    @Test
    public void testRemoveProduct() {
        carritoService.addProduct("Banana", 2);
        carritoService.removeProduct("Banana");
        assertEquals(0, carritoService.getProductQuantity("Banana"));
    }

    @Test
    public void testGetTotalProducts() {
        carritoService.addProduct("Orange", 5);
        carritoService.addProduct("Apple", 2);
        assertEquals(7, carritoService.getTotalProducts());
    }

    @Test
    public void testCalculateTotal() {
        carritoService.addProduct("Milk", 2);
        carritoService.addProduct("Bread", 1);

        Map<String, Double> productPrices = new HashMap<>();
        productPrices.put("Milk", 1.5);
        productPrices.put("Bread", 2.0);

        assertEquals(5.0, carritoService.calculateTotal(productPrices));
    }

    @Test
    public void testClearCart() {
        carritoService.addProduct("Juice", 4);
        carritoService.clearCart();
        assertEquals(0, carritoService.getTotalProducts());
    }
}
