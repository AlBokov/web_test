package ru.netology.web;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class formTestV1 {

    // проверка формы с валлидными данными
    @Test
    void workingWithValidData() {
        open("http://0.0.0.0:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");
        form.$("[name=name]").setValue("Боков Александр");
        form.$("[name=phone]").setValue("+95000000000");
        form.$(".checkbox_theme_alfa-on-white").click();
        form.$("button").click();
        $(".paragraph").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }
}
