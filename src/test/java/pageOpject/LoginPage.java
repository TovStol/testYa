package pageOpject;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class LoginPage {
    static final private String entryMainButton = "[data-statlog='notifications.mail.logout.enter']";
    static final private String entryMode = "input[type=tel]";
    static final private String changeMode = ".Button2-Text";
    static final private String loginField = "[id='passp-field-login']";
    static final private String entBatton = "[id='passp:sign-in']";
    static final private String passwordField = "[id='passp-field-passwd']";
    static final private String mailList = ".desk-notif-card__mail-title";

    public void login(String login, String password) {

        $(entryMainButton).shouldBe(visible).click();
        if ($(entryMode).exists()) {
            $(changeMode, 0).parent().click();
        }
        $(loginField).setValue(login);
        $(entBatton).click();
        $(passwordField).setValue(password).pressEnter();
        $(mailList).shouldBe(visible).click();
        switchTo().window(1);
    }


}
