package junit;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;


public class FirstJUnitTest {
    @BeforeAll
    static void openBrowse() {
       // Configuration.browserSize = "1366x768";
        //Configuration.browserCapabilities.setCapability("Zoom", "50" );
        Selenide.open("https://yandex.ru");

    }

    @AfterAll
    static void closeBrowse() {
        Selenide.closeWebDriver();
    }

    @Test
    void firstTest() {

        $("[data-statlog='notifications.mail.logout.enter']").shouldBe(visible).click();
        $("[id='passp-field-login']").setValue("n.surnametest");
        $("[id='passp:sign-in']").click();
        $("[id='passp-field-passwd']").setValue("!N.surnametest!").pressEnter();
        $("[data-statlog='notifications.mail.login.disk']").click();


        $$(".listing__items").filterBy(text("Горы.jpg"));
        $$(".listing__items").filterBy(text("Москва.jpg"));



        sleep(5000);
        sleep(5000);


/*
     */
    }
}
