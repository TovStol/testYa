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
import static org.openqa.selenium.Keys.ALT;
import static org.openqa.selenium.Keys.TAB;


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

       $("[data-statlog='notifications.mail.login.inbox.unread']").sendKeys(TAB + ALT );
       $( "[href='#compose']").click();







        sleep(5000);



/*
     */
    }
}
