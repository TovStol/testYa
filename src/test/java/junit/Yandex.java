package junit;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.SendKeysAction;


import java.security.Key;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.*;


public class Yandex {
    @BeforeAll
    static void openBrowse() {
        Selenide.open("https://yandex.ru");

    }

    @AfterAll
    static void closeBrowse() {
        Selenide.closeWebDriver();
    }

    @Test
    void name() {
    }

    @Test
    void firstTest() {

       $("[data-statlog='notifications.mail.logout.enter']").shouldBe(visible).click();
       $("[id='passp-field-login']").setValue("n.surnametest");
       $("[id='passp:sign-in']").click();
       $("[id='passp-field-passwd']").setValue("!N.surnametest!").pressEnter();
       $(".desk-notif-card__mail-title").shouldBe(visible).click();
       switchTo().window(1);

//Шаг 1: Нажать на кнопку Написать.
       $( "[href='#compose']").click();

//Ожидание: Открывается экран написания нового письма
        $(".ComposePopup-Content").shouldHave(text("Новое письмо"));

//Шаг 2: Заполнить поля Кому, Тема, в поле для ввода текста письма вставить
//текст из нескольких абзацев.
// Заполнение поля адреса
        $$(".MultipleAddressesDesktop-Field.ComposeYabblesField")
                .first()
                .lastChild()
                .sendKeys("alex_a_s@inbox.ru");
//Заполнение поля темы
        $("[name='subject']").setValue("Тестовое письмо");
//Написание письма
        $("#cke_1_contents")
                .lastChild()
                .setValue("В чужбине свято наблюдаю\n" +
                        "Родной обычай старины:\n" +
                        "На волю птичку выпускаю\n" +
                        "При светлом празднике весны.\n\n" +
                        "Я стал доступен утешенью;\n" +
                        "За что на бога мне роптать,\n" +
                        "Когда хоть одному творенью\n" +
                        "Я мог свободу даровать!");
// К разным частям текста письма применить следующие виды форматирования:
//Жирный
    $(byText("В чужбине свято наблюдаю")).click();
    $(byText("В чужбине свято наблюдаю")).sendKeys(SHIFT,HOME);
    $(byText("В чужбине свято наблюдаю")).sendKeys(CONTROL, "b");
//Подчеркивание
    $(byText("Родной обычай старины:")).click();
    $(byText("Родной обычай старины:")).sendKeys(SHIFT,HOME);
    $(byText("Родной обычай старины:")).sendKeys(CONTROL, "u");
//Зачеркивание
        $(byText("На волю птичку выпускаю")).click();
        $(byText("На волю птичку выпускаю")).sendKeys(SHIFT,HOME);
        $("[data-cke-csp-href-useless-javascript=\"void('Перечёркнутый')\"]").click();
//Курсив
        $(byText("При светлом празднике весны.")).click();
        $(byText("При светлом празднике весны.")).sendKeys(SHIFT,HOME);
        $(byText("При светлом празднике весны.")).sendKeys(CONTROL, "i");
//Маркированный список
        $(byText("Я стал доступен утешенью;")).click();
        $(byText("Я стал доступен утешенью;")).sendKeys(SHIFT,HOME);
        $("[data-cke-csp-href-useless-javascript=\"void('Маркированный список')\"]").click();
//Нумерованный список
        $(byText("За что на бога мне роптать,")).click();
        $(byText("За что на бога мне роптать,")).sendKeys(SHIFT,HOME);
        $("[data-cke-csp-href-useless-javascript=\"void('Нумерованный список')\"]").click();


//  Ожидание: Текст отображается с учетом форматирования.
        $("strong").shouldHave(text("В чужбине свято наблюдаю"));
        $("u").shouldHave(text("Родной обычай старины:"));
        $("[style='text-decoration:line-through;']").shouldHave(text("На волю птичку выпускаю"));
        $("em").shouldHave(text("При светлом празднике весны."));
        $$("ul").shouldHave(CollectionCondition.itemWithText("Я стал доступен утешенью;"));
        $$("ol").shouldHave(CollectionCondition.itemWithText("За что на бога мне роптать,"));

//Шаг 3: Вставить валидные картинки выбором с компьютера и ссылкой.













        sleep(5000);



/*
     */
    }
}
