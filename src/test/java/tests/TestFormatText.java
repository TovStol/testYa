package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import pageOpject.LoginPage;
import pageOpject.ReadLetterPage;
import pageOpject.WriteLetterPage;

public class TestFormatText {

    @Test
    public void writeTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        LoginPage loginPage = new LoginPage();
        WriteLetterPage writeLetterPage = new WriteLetterPage();
        ReadLetterPage readLetterPage = new ReadLetterPage();

        Selenide.open("https://yandex.ru");
        loginPage.login("n.surnametest", "!N.surnametest!");
        writeLetterPage.write();
        Selenide.closeWebDriver();
        Selenide.open("https://yandex.ru");
        loginPage.login("n.surnametest2", "!N.surnametest!");
        readLetterPage.read();

    }


}
