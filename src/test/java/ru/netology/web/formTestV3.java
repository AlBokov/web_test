package ru.netology.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.*;

public class formTestV3 {


    @BeforeClass
    public static void setup() {
        Configuration.headless = true;
    }

    @Test
    void phoneFieldIsEmpty() {
        open("http://0.0.0.0:9999");

        SelenideElement form = $("[action]");
        form.$("[name=name]").setValue("Боков Александр");
        // form.$(".input__control[type=tel]").setValue("+95000000000");
        form.$(".checkbox__text").click();
        form.$(".button_theme_alfa-on-white").click();
        element("[data-test-id=phone]").shouldHave(cssClass("input_invalid"));// Проверяем что .input_invalid есть в поле [data-test-id=name]
    }

    @Test
    void phoneLettersField() {
        open("http://0.0.0.0:9999");

        SelenideElement form = $("[action]");
        form.$("[name=name]").setValue("Боков Александр");
        form.$(".input__control[type=tel]").setValue("+цукенгшщзхъ");
        form.$(".checkbox__text").click();
        form.$(".button_theme_alfa-on-white").click();
        element("[data-test-id=phone]").shouldHave(cssClass("input_invalid"));// Проверяем что .input_invalid есть в поле [data-test-id=name]
    }

    @Test
    void phoneField10() {
        open("http://0.0.0.0:9999");

        SelenideElement form = $("[action]");
        form.$("[name=name]").setValue("Боков Александр");
        form.$(".input__control[type=tel]").setValue("+9500000000");
        form.$(".checkbox__text").click();
        form.$(".button_theme_alfa-on-white").click();
        element("[data-test-id=phone]").shouldHave(cssClass("input_invalid"));// Проверяем что .input_invalid есть в поле [data-test-id=name]
    }

    @Test
    void phoneField12() {
        open("http://0.0.0.0:9999");

        SelenideElement form = $("[action]");
        form.$("[name=name]").setValue("Боков Александр");
        form.$(".input__control[type=tel]").setValue("+950000000000");
        form.$(".checkbox__text").click();
        form.$(".button_theme_alfa-on-white").click();
        element("[data-test-id=phone]").shouldHave(cssClass("input_invalid"));// Проверяем что .input_invalid есть в поле [data-test-id=name]
    }

}
