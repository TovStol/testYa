package pageOpject;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class LoginPage {
    final private String entryMainButton = "[data-statlog='notifications.mail.logout.enter']";
    final private String entryMode = "input[type=tel]";
    final private String changeMode = ".Button2-Text";
    final private String loginField = "[id='passp-field-login']";
    final private String entBatton = "[id='passp:sign-in']";
    final private String passwordField = "[id='passp-field-passwd']";



    void one (){
        $(entryMainButton).shouldBe(visible).click();

        if ($(entryMode).exists()) {
            $(changeMode, 0).parent().click();
        }
        $(loginField).setValue("n.surnametest");
        $(entBatton).click();


        $(passwordField).setValue("!N.surnametest!").pressEnter();
        $(".desk-notif-card__mail-title").shouldBe(visible).click();
        switchTo().window(1);

 /*   $("[id='passp-field-passwd']").setValue("!N.surnametest!").pressEnter();
    $(".desk-notif-card__mail-title").shouldBe(visible).click();
    switchTo().window(1);
$("[id='passp-field-login']").setValue("n.surnametest2");
    $("[id='passp:sign-in']").click();
  */
    }

}
