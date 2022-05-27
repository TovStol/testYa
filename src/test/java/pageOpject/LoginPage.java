package pageOpject;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    $("[data-statlog='notifications.mail.logout.enter']").shouldBe(visible).click();

        if ($("input[type=tel]").exists()) {
        $(".Button2-Text", 0).parent().click();
    }
    $("[id='passp-field-login']").setValue("n.surnametest");
    $("[id='passp:sign-in']").click();


 /*   $("[data-statlog='notifications.mail.logout.enter']").shouldBe(visible).click();

        if ($("input[type=tel]").exists()) {
        $(".Button2-Text", 0).parent().click();
    }
    $("[id='passp-field-login']").setValue("n.surnametest2");
    $("[id='passp:sign-in']").click();

  */
}
