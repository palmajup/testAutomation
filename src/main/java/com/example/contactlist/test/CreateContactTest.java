package com.example.contactlist.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class    CreateContactTest extends BaseTest {

    @Test
    public void createContact() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // el Login
        driver.findElement(By.id("email")).sendKeys("pedritooo@12coronau12.com");
        driver.findElement(By.id("password")).sendKeys("myPassword");
        driver.findElement(By.id("submit")).click();

        // Esperar hasta que el botón "agregar contacto " esté visible y luego hacer clic
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-contact"))).click();

        // Esperar hasta que el campo "firstName" esté visible y luego completa el formulario
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))).sendKeys("pedrito");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName"))).sendKeys("matorral");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("birthdate"))).sendKeys("1980/05/11");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("juanpaaa@example.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone"))).sendKeys("123456789");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("street1"))).sendKeys("Av siempreViva");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("street2"))).sendKeys("Av siempreViva");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("city"))).sendKeys("Cordoba");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("stateProvince"))).sendKeys("Cordoba");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postalCode"))).sendKeys("5010");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("country"))).sendKeys("Argentina");
        // Se envia el formulario
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit"))).click();

        // Esperar hasta que el encabezado esté visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/header/h1")));

        // Esperar hasta que la primera fila de la tabla esté visible y hacer clic
        WebElement firstRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myTable\"]/tr[1]")));
        firstRow.click();


    }
}
