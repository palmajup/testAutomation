package com.example.contactlist.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUp() {
        // Configura WebDriverManager para ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Configura ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");

        // Inicializa el WebDriver
        driver = new ChromeDriver(options);

        // Abre la URL de la aplicación
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
    }

    @After
    public void tearDown() {
        // Cierra el navegador después de cada prueba
        if (driver != null) {
            driver.quit();
        }
    }
}
