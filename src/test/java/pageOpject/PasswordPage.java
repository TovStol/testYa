package pageOpject;

public class PasswordPage {
    $("[id='passp-field-passwd']").setValue("!N.surnametest!").pressEnter();
    $(".desk-notif-card__mail-title").shouldBe(visible).click();
    switchTo().window(1);

 /*   $("[id='passp-field-passwd']").setValue("!N.surnametest!").pressEnter();
    $(".desk-notif-card__mail-title").shouldBe(visible).click();
    switchTo().window(1);

  */
}
