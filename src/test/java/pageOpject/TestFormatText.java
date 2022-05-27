package pageOpject;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

public class TestFormatText {

    @Test
    void writeTest() {
        Selenide.open("https://yandex.ru");
        LoginPage.login("n.surnametest", "!N.surnametest!");
        WriteLetterPage.write();
        Selenide.closeWebDriver();
        Selenide.open("https://yandex.ru");
        LoginPage.login("n.surnametest2", "!N.surnametest!");
        ReadLetterPage.read();

    }


}
