package ru.netology.web;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class formTestV1 {

    @BeforeEach
    public void beforeEach() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage"); // Аргумент для работы с памятью в CI
        options.addArguments("--no-sandbox"); // Аргумент для работы с памятью в CI
        options.addArguments("--headless"); // Этот аргумент отвечает за режим headless

    }

    // проверка формы с валлидными данными
    @Test
    public void workingWithValidData() {
        open("http://0.0.0.0:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");
        form.$("[name=name]").setValue("Боков Александр");
        form.$("[name=phone]").setValue("+95000000000");
        form.$(".checkbox_theme_alfa-on-white").click();
        form.$("button").click();
        $(".paragraph").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }
}
