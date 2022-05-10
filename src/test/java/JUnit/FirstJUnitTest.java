package JUnit;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class FirstJUnitTest {
    @BeforeAll
    static void openBrowse(){
        Selenide.open("https://demoqa.com/automation-practice-form");


    }

    @AfterAll
    static void closeBrowse(){
        Selenide.closeWebDriver();
    }

    @Test
    void first(){

    }
}
