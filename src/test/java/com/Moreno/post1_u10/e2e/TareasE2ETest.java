package com.Moreno.post1_u10.e2e;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TareasE2ETest {

    @LocalServerPort
    private int port;

    private WebDriver driver;
    private TareasPage tareasPage;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(opts);
        driver.get("http://localhost:" + port + "/tareas");
        tareasPage = new TareasPage(driver);
    }

    @Test
    void paginaTareas_cargaCorrectamente() {
        assertThat(tareasPage.obtenerTituloPagina()).contains("Tareas");
    }

    @Test
    void paginaTareas_botonNuevaVisible() {
        assertThat(tareasPage.botonNuevaVisible()).isTrue();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }
}