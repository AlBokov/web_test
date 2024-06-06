package ru.netology.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.*;

public class FormTestV3 {


    @BeforeClass
    public static void setup() {
        Configuration.headless = true;
    }

    @Test
    void phoneFieldIsEmpty() {
        open("http://localhost:9999");

        SelenideElement form = $("[action]");
        form.$("[name=name]").setValue("Боков Александр");
        form.$(".checkbox__text").click();
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id='phone'].input_invalid .input__sub").shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    @Test
    void phoneLettersField() {
        open("http://localhost:9999");

        SelenideElement form = $("[action]");
        form.$("[name=name]").setValue("Боков Александр");
        form.$(".input__control[type=tel]").setValue("+цукенгшщзхъ");
        form.$(".checkbox__text").click();
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id='phone'].input_invalid .input__sub").shouldHave(Condition.exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void phoneField10() {
        open("http://localhost:9999");

        SelenideElement form = $("[action]");
        form.$("[name=name]").setValue("Боков Александр");
        form.$(".input__control[type=tel]").setValue("+9500000000");
        form.$(".checkbox__text").click();
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id='phone'].input_invalid .input__sub").shouldHave(Condition.exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));    }

    @Test
    void phoneField12() {
        open("http://localhost:9999");

        SelenideElement form = $("[action]");
        form.$("[name=name]").setValue("Боков Александр");
        form.$(".input__control[type=tel]").setValue("+950000000000");
        form.$(".checkbox__text").click();
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id='phone'].input_invalid .input__sub").shouldHave(Condition.exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));    }

}
