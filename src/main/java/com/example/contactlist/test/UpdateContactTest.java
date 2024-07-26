package com.example.contactlist.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UpdateContactTest extends BaseTest {
    @Test
    public void updateContact() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Login con el usuario ya creado por servicio
        driver.findElement(By.id("email")).sendKeys("pedritooo@12coronau12.com");
        driver.findElement(By.id("password")).sendKeys("myPassword");
        driver.findElement(By.id("submit")).click();

        // Esperar hasta que la primera fila de la tabla esté visible y hacer clic
        WebElement firstRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myTable\"]/tr[1]")));
        firstRow.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/header/h1")));
        WebElement editButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/p/button[1]")));
        editButton.click();

        // Esperar hasta que el campo "firstName" esté visible y se llena el formulario con los datos indicados
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))).sendKeys("pedrito");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName"))).sendKeys("update");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("birthdate"))).sendKeys("1980/05/11");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("juanpaaa@example.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone"))).sendKeys("123456789");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("street1"))).sendKeys("Av update");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("street2"))).sendKeys("Av update");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("city"))).sendKeys("update");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("stateProvince"))).sendKeys("update");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postalCode"))).sendKeys("5010");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("country"))).sendKeys("Argentina");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit"))).click();


    }
}
