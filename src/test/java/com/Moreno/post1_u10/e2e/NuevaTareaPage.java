package com.Moreno.post1_u10.e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NuevaTareaPage {
    private final WebDriver driver;
    private final By campoTitulo = By.id("titulo");
    private final By btnGuardar  = By.id("btn-guardar");

    public NuevaTareaPage(WebDriver d) { this.driver = d; }

    public TareasPage crearTarea(String titulo) {
        driver.findElement(campoTitulo).sendKeys(titulo);
        driver.findElement(btnGuardar).click();
        return new TareasPage(driver);
    }
}