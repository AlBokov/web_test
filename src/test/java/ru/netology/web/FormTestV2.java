package ru.netology.web;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;


import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.*;


public class FormTestV2 {


    @BeforeClass
    public static void setup() {
        Configuration.headless = true;
    }

    // проверка отправки формы с пустым полем Фамилия и имя
    @Test
    void sendingFormWithoutFULLNameField() {
        open("http://localhost:9999"); // открываем страницу
        SelenideElement form = $("[action]"); // делаем акцент на форму
        form.$(".input__control[type=tel]").setValue("+95000000000"); // заполняем поле телефон
        form.$(".checkbox__text").click(); // кликаем по чекбоксу
        form.$(".button_theme_alfa-on-white").click(); // кликаем по кнопке отправить
        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(Condition.exactText("Поле обязательно для заполнения")); // проверка наличия текста об ошибке в поле ФИО
    }

    @Test
    void nameFieldIsFilledInWithEnglishLetters() {
        open("http://localhost:9999");
        SelenideElement form = $("[action]");
        form.$("[name=name]").setValue("Bokov Alexander");
        form.$(".input__control[type=tel]").setValue("+95000000000");
        form.$(".checkbox__text").click();
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(Condition.exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void nameFieldForbiddenCharacters() {
        open("http://localhost:9999");
        SelenideElement form = $("[action]");
        form.$("[name=name]").setValue("Боков Александр?");
        form.$(".input__control[type=tel]").setValue("+95000000000");
        form.$(".checkbox__text").click();
        form.$(".button_theme_alfa-on-white").click();
        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(Condition.exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }


}
