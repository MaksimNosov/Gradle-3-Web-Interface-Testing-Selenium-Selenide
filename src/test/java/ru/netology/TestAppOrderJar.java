package ru.netology;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
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

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAppOrderJar {

    //    @Test
//    void testNameNotTrue() {                     /// тест на Selenium проходит
//        driver.get("http://localhost:9999/");
//        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("English");
//        driver.findElement(By.className("button__text")).click();
//        String expected = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
//        String actual = driver.findElement(By.className("input__sub")).getText().trim();
//        assertEquals(expected, actual);
//    }
    @Test
    void testNameNotTrue() {
        open("http://localhost:9999/");
        SelenideElement form = $("[id=root]");
        form.$("[id=root] input").setValue("English");
        form.$("[id=root] button").click();
        $(".input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }
//    @Test
//    void testNoName() {                     /// тест на Selenium проходит
//        driver.get("http://localhost:9999/");
//        driver.findElement(By.className("button__text")).click();
//        String expected = "Поле обязательно для заполнения";
//        String actual = driver.findElement(By.className("input__sub")).getText().trim();
//        assertEquals(expected, actual);
//    }

    @Test
    void testNoName() {
        open("http://localhost:9999/");
        SelenideElement form = $("[id=root]");
        form.$("[id=root] button").click();
        $(".input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

//    @Test
//    void testPhoneNotTrue() {                     /// тест на Selenium проходит
//        driver.get("http://localhost:9999/");
//        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Точно как в паспорте");
//        driver.findElement(By.cssSelector("[data-test-id=phone] input")).sendKeys("9999999999999");
//        driver.findElement(By.className("button__text")).click();
//        String expected = "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.";
//        String actual = driver.findElement(By.cssSelector("[data-test-id=phone] .input__sub")).getText().trim();
//        assertEquals(expected, actual);
//    }

    @Test
    void testPhoneNotTrue() {
        open("http://localhost:9999/");
        SelenideElement form = $("[id=root]");
        form.$("[data-test-id=name] input").setValue("Точно как в паспорте");
        form.$("[data-test-id=phone] input").setValue("9999999999999");
        form.$("[id=root] button").click();
        $("[id=root] .input_invalid .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }
//
//    @Test
//    void testNoPhone() {                     /// тест на Selenium проходит
//        driver.get("http://localhost:9999/");
//        driver.findElement(By.cssSelector("[data-test-id=name] input")).sendKeys("Точно как в паспорте");
//        driver.findElement(By.className("button__text")).click();
//        String expected = "Поле обязательно для заполнения";
//        String actual = driver.findElement(By.cssSelector("[data-test-id=phone] .input__sub")).getText().trim();
//        assertEquals(expected, actual);
//    }
        @Test
    void testNoPhone() {
            open("http://localhost:9999/");
            SelenideElement form = $("[id=root]");
            form.$("[data-test-id=name] input").setValue("Точно как в паспорте");
            form.$("[id=root] button").click();
            $("[id=root] .input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }
}
