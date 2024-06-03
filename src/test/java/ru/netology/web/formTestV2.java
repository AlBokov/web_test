package ru.netology.web;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.*;


public class formTestV2 {


    @BeforeClass
    public static void setup() {
        Configuration.headless = true;
    }

    // проверка отправки формы с пустым полем Фамилия и имя
    @Test
    void sendingFormWithoutFULLNameField() {
        open("http://0.0.0.0:9999"); // открываем страницу

        SelenideElement form = $("[action]"); // делаем акцент на форму
        form.$(".input__control[type=tel]").setValue("+95000000000"); // заполняем поле телефон
        form.$(".checkbox__text").click(); // кликаем по чекбоксу
        form.$(".button_theme_alfa-on-white").click(); // кликаем по кнопке отправить
        element("[data-test-id=name]").shouldHave(cssClass("input_invalid")); // Проверяем что .input_invalid есть в поле [data-test-id=name]
    }

    @Test
    void nameFieldIsFilledInWithEnglishLetters() {
        open("http://0.0.0.0:9999");

        SelenideElement form = $("[action]");
        form.$("[name=name]").setValue("Bokov Alexander");
        form.$(".input__control[type=tel]").setValue("+95000000000");
        form.$(".checkbox__text").click();
        form.$(".button_theme_alfa-on-white").click();
        // $(".input_invalid").shouldBe(visible);
        // $("[data-test-id=name]").$(".input_invalid").shouldBe(visible);
        element("[data-test-id=name]").shouldHave(cssClass("input_invalid"));// Проверяем что .input_invalid есть в поле [data-test-id=name]
    }

    @Test
    void nameFieldForbiddenCharacters() {
        open("http://0.0.0.0:9999");

        SelenideElement form = $("[action]");
        form.$("[name=name]").setValue("Боков Александр?");
        form.$(".input__control[type=tel]").setValue("+95000000000");
        form.$(".checkbox__text").click();
        form.$(".button_theme_alfa-on-white").click();
        // $(".input_invalid").shouldBe(visible);
        // $("[data-test-id=name]").$(".input_invalid").shouldBe(visible);
        element("[data-test-id=name]").shouldHave(cssClass("input_invalid"));// Проверяем что .input_invalid есть в поле [data-test-id=name]
    }


}
