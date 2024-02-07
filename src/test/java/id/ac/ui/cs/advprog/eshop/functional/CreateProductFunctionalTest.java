package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
public class CreateProductFunctionalTest {

    private WebDriver driver;

    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrlGet;
    private String baseUrlList;

    @BeforeEach
    public void setUp() {
        // Set up base URLs for create and list pages
        baseUrlGet = String.format("%s:%d/product/create", testBaseUrl, serverPort);
        baseUrlList = String.format("%s:%d/product/list", testBaseUrl, serverPort);
    }

    @Test
    void givenProductCreationPage_whenProductCreated_thenProductListContainsNewProduct(ChromeDriver driver) throws Exception{
        // Given: The user is on the product creation page
        driver.get(baseUrlGet);

        // When: The user fills out the form with product details
        WebElement productNameInput = driver.findElement(By.id("nameInput"));
        WebElement productQuantityInput = driver.findElement(By.id("quantityInput"));
        WebElement submitButton = driver.findElement(By.tagName("button"));

        productNameInput.sendKeys("New Product Name");
        productQuantityInput.sendKeys("10");
        submitButton.click();

        // Then: The user is redirected to the product list page
        assertEquals(baseUrlList, driver.getCurrentUrl());

        // And: The newly created product appears in the product list
        WebElement productListTable = driver.findElement(By.tagName("table"));
        assertTrue(productListTable.getText().contains("New Product Name"));
    }


}
