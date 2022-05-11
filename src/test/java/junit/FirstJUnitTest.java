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
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9875995990");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1983");
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#currentAddress").setValue("Moscow");

        $("#uploadPicture").uploadFromClasspath("c:\\test\\1.png");


        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();






    }


}
