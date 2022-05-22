package junit;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.SendKeysAction;


import java.security.Key;

import static com.codeborne.selenide.Condition.*;
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
       $("[data-statlog='notifications.mail.login.inbox.unread']").shouldBe(visible).click();
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
        //  Написание письма
        $("#cke_1_contents")
                .lastChild()
                .setValue("В чужбине свято наблюдаю\n" +
                        "Родной обычай старины:\n" +
                        "На волю птичку выпускаю\n" +
                        "При светлом празднике весны.\n\n" +
                        "Я стал доступен утешенью;\n" +
                        "За что на бога мне роптать,\n" +
                        "Когда хоть одному творенью\n" +
                        "Я мог свободу даровать!\n");
/* К разным частям текста письма применить следующие виды форматирования:
Жирный
Подчеркивание
Зачеркивание
Курсив
Маркированный список
Нумерованный список */














        sleep(5000);



/*
     */
    }
}
