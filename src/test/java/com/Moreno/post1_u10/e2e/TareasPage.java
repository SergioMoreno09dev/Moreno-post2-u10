package com.Moreno.post1_u10.e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TareasPage {
    private final WebDriver driver;
    private final By btnNueva = By.id("btn-nueva");
    private final By listItems = By.cssSelector(".tarea-item");
    private final By titulo = By.tagName("h1");

    public TareasPage(WebDriver driver) {
        this.driver = driver;
    }

    public int contarTareas() {
        return driver.findElements(listItems).size();
    }

    public String obtenerTituloPagina() {
        return driver.getTitle();
    }

    public String obtenerEncabezado() {
        return driver.findElement(titulo).getText();
    }

    public boolean botonNuevaVisible() {
        return driver.findElement(btnNueva).isDisplayed();
    }
}