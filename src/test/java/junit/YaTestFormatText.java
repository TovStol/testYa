package junit;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.*;

public class YaTestFormatText {

    @BeforeAll
    void openBrowse() {
        Selenide.open("https://yandex.ru");
    }

    @AfterAll
    void closeBrowse() {
        Selenide.closeWebDriver();
    }

    @Test
    void caseOne() {
    }






}
