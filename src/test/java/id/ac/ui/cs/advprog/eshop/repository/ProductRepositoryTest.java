package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {
    @InjectMocks
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de47-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Bambang");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testDelete() {
        Product product1 = new Product();
        product1.setProductId("8a94bde4-aa11-41b6-92a0-42c08c8be2e0");
        product1.setProductName("Soap Bar Lavender");
        product1.setProductQuantity(60);
        productRepository.create(product1);

        productRepository.delete(product1);

        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testDeleteIfMoreThanOneProduct() {
        Product product1 = new Product(), product2 = new Product();
        product1.setProductId("d9a504f2-d86b-45b0-8902-4e16e295c4ef");
        product1.setProductName("Toothpaste Mint Fresh");
        product1.setProductQuantity(20);
        productRepository.create(product1);

        product2.setProductId("aab87b6c-b687-4d5e-9209-287ff392c44d");
        product2.setProductName("Shower Gel Ocean Breeze");
        product2.setProductQuantity(10);
        productRepository.create(product2);

        productRepository.delete(product1);
        Iterator<Product> productIterator = productRepository.findAll();
        Product curProduct = productIterator.next();
        assertNotEquals(curProduct, product1);
        assertEquals(curProduct, product2);
    }

    @Test
    void testDeleteNonExistingProduct() {
        Product product = new Product();
        product.setProductId("cfde63f4-868a-452f-a7bb-6dc0c084a60a");
        product.setProductName("Soap Bar Lavender");
        product.setProductQuantity(60);
        productRepository.create(product);

        Product dummyProduct = new Product();
        dummyProduct.setProductId("dummy");
        productRepository.delete(dummyProduct);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testUpdate() {
        Product product1 = new Product();
        product1.setProductId("28bf3c70-2d33-44a8-b5b5-1ff5ae8ec7fc");
        product1.setProductName("Toothpaste Mint Fresh");
        product1.setProductQuantity(20);
        productRepository.create(product1);

        String updatedName = "Updated Toothpaste";
        int updatedQuantity = 50;
        product1.setProductName(updatedName);
        product1.setProductQuantity(updatedQuantity);
        productRepository.update(product1);

        Iterator<Product> productIterator = productRepository.findAll();
        Product updatedProduct = productIterator.next();
        assertEquals(updatedName, updatedProduct.getProductName());
        assertEquals(updatedQuantity, updatedProduct.getProductQuantity());
    }

    @Test
    void testUpdateNonExistingProduct() {
        // Create a product
        Product product = new Product();
        product.setProductId("28bf3c70-2d33-44a8-b5b5-1ff5ae8ec7fc");
        product.setProductName("Toothpaste Mint Fresh");
        product.setProductQuantity(30);
        productRepository.create(product);

        // Attempt to update a non-existing product
        String nonExistingId = "nonExistingId";
        String updatedName = "Updated Name";
        int updatedQuantity = 40;
        Product updatedProduct = new Product();
        updatedProduct.setProductId(nonExistingId);
        updatedProduct.setProductName(updatedName);
        updatedProduct.setProductQuantity(updatedQuantity);
        productRepository.update(updatedProduct);

        // Check if the product is not updated
        Iterator<Product> productIterator = productRepository.findAll();
        Product curProduct = productIterator.next();
        assertNotEquals(updatedName, curProduct.getProductName());
        assertNotEquals(updatedQuantity, curProduct.getProductQuantity());
    }
}

