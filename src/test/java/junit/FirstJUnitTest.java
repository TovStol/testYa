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
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
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
        //$("[id='passp:sign-in']").click();
        $("[id='passp-field-login']").setValue("n.surnametest");
        $("[id='passp:sign-in']").click();
        $("[id='passp-field-passwd']").setValue("!N.surnametest!").pressEnter();
        $(".PSHeaderIcon-Image_Disk").shouldBe(visible);
        sleep(5000);

/*
<div class="PSHeaderIcon-Image PSHeaderIcon-Image_Disk PSHeaderIcon-Image_theme_light PSHeaderIcon-Image_lang_ru"></div>

<a class="PSHeaderService PSHeaderService_theme_light PSHeader-ServiceList-MainService" href="https://disk.yandex.ru" rel="noopener noreferrer">
<div class="PSHeaderService-Icon">
<div class="PSHeaderIcon PSHeaderIcon_Disk">
<div class="PSHeaderIcon-Image PSHeaderIcon-Image_Disk PSHeaderIcon-Image_theme_light PSHeaderIcon-Image_lang_ru">
</div>
</div>
</div><span class="PSHeaderService-Text">Диск</span></a>

     */


    }


}
