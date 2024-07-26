package com.example.contactlist.test;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeleteContactTest extends BaseTest {
    @Test
    public void deleteContact() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Login con el usuario ya creado por servicio
        driver.findElement(By.id("email")).sendKeys("pedritooo@12coronau12.com");
        driver.findElement(By.id("password")).sendKeys("myPassword");
        driver.findElement(By.id("submit")).click();
        //seleccionamos el primer registro de la tabla
        WebElement firstRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myTable\"]/tr[1]")));
        firstRow.click();
        //  Aguardamos que tengamos el encabezado
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/header/h1")));
        //  Eliminamos el Registro
        WebElement deletButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/p/button[2]")));
        deletButton.click();
    }
}
