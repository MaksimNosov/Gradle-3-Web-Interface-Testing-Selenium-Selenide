package ru.netology;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAppOrderJar {
//    private WebDriver driver;
//
//    @BeforeAll
//    static void setUpAll() {
//        System.setProperty("webdriver.chrome.driver", "drivers/win/chromedriver.exe");
//    }
//
//    @BeforeEach
//    void setUp() {
//        driver = new ChromeDriver();
//    }
//
//    @AfterEach
//    void tearDown() {
//        driver.quit();
//        driver = null;
//    }

        private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "drivers/win/chromedriver.exe");
    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }



    @Test
    void shouldTestV1() {
        driver.get("http://localhost:9999/");
//        List<WebElement> inputs = driver.findElements(By.tagName("input"));
//        inputs.get(0).sendKeys("Точно как в паспорте");
//        inputs.get(1).sendKeys("+79998889988");
        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Точно как в паспорте");
        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("+79998889988");
        driver.findElement(By.cssSelector("[data-test-id=agreement]")).click();
        driver.findElement(By.className("button__text")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();
        assertEquals(expected, actual);
    }


}
