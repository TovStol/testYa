package junit;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;


public class FirstJUnitTest {
    @BeforeAll
    static void openBrowse() {
        Configuration.browserSize = "1920x1080";
        Selenide.open("https://demoqa.com/automation-practice-form");

    }

    @AfterAll
    static void closeBrowse() {
        Selenide.closeWebDriver();
    }

    @Test
    void firstTest() {

        $(".form-label").shouldHave(text("Name"));

        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("Alex@Ivanov.com");

        $(byText("Male")).click();

        $("#userNumber").setValue("9875995990");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOptionContainingText("1983");
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOptionContainingText("July");
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__day--001").click();

        $(byText("Sports")).click();
        $(byText("Music")).click();
        $(byText("Reading")).click();


        $("#subjectsInput").setValue("Maths").pressEnter();

        $(byText("Rading")).click();


    }


}
