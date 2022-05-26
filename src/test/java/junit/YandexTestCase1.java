package junit;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.*;


public class YandexTestCase1 {
    @BeforeEach
    void openBrowse() {

        Selenide.open("https://yandex.ru");
        $("[data-statlog='notifications.mail.logout.enter']").shouldBe(visible).click();
        $(".Button2-Text", 0).parent().click();
        if ($("input[type=tel]").exists()) {
            $(".Button2-Text", 0).parent().click();
        }
        $("[id='passp-field-login']").setValue("n.surnametest");
        $("[id='passp:sign-in']").click();
        $("[id='passp-field-passwd']").setValue("!N.surnametest!").pressEnter();
        $(".desk-notif-card__mail-title").shouldBe(visible).click();
        switchTo().window(1);

    }

    @AfterEach
    void closeBrowse() {
        Selenide.closeWebDriver();

    }

    @Test
    void caseOne() {
        $("[href='#compose']").click();
        $(".ComposePopup-Content").shouldHave(text("Новое письмо"));

        $$(".MultipleAddressesDesktop-Field.ComposeYabblesField")
                .first()
                .lastChild()
                .sendKeys("n.surnametest2@yandex.ru");
        $("[name='subject']").setValue("Тестовое письмо");
        $("#cke_1_contents")
                .lastChild()
                .setValue("В чужбине свято наблюдаю\n" +
                        "Родной обычай старины:\n" +
                        "На волю птичку выпускаю\n" +
                        "При светлом празднике весны.\n\n" +
                        "Я стал доступен утешенью;\n" +
                        "За что на бога мне роптать,\n" +
                        "Когда хоть одному творенью\n" +
                        "Я мог свободу даровать!");
        $(byText("В чужбине свято наблюдаю")).click();
        $(byText("В чужбине свято наблюдаю")).sendKeys(SHIFT, HOME);
        $(byText("В чужбине свято наблюдаю")).sendKeys(CONTROL, "b");

        $(byText("Родной обычай старины:")).click();
        $(byText("Родной обычай старины:")).sendKeys(SHIFT, HOME);
        $(byText("Родной обычай старины:")).sendKeys(CONTROL, "u");

        $(byText("На волю птичку выпускаю")).click();
        $(byText("На волю птичку выпускаю")).sendKeys(SHIFT, HOME);
        $("[data-cke-csp-href-useless-javascript=\"void('Перечёркнутый')\"]").click();

        $(byText("При светлом празднике весны.")).click();
        $(byText("При светлом празднике весны.")).sendKeys(SHIFT, HOME);
        $(byText("При светлом празднике весны.")).sendKeys(CONTROL, "i");

        $(byText("Я стал доступен утешенью;")).click();
        $(byText("Я стал доступен утешенью;")).sendKeys(SHIFT, HOME);
        $("[data-cke-csp-href-useless-javascript=\"void('Маркированный список')\"]").click();

        $(byText("За что на бога мне роптать,")).click();
        $(byText("За что на бога мне роптать,")).sendKeys(SHIFT, HOME);
        $("[data-cke-csp-href-useless-javascript=\"void('Нумерованный список')\"]").click();

        $("strong").shouldHave(text("В чужбине свято наблюдаю"));
        $("u").shouldHave(text("Родной обычай старины:"));
        $("[style='text-decoration:line-through;']").shouldHave(text("На волю птичку выпускаю"));
        $("em").shouldHave(text("При светлом празднике весны."));
        $$("ul").shouldHave(CollectionCondition.itemWithText("Я стал доступен утешенью;"));
        $$("ol").shouldHave(CollectionCondition.itemWithText("За что на бога мне роптать,"));
        $(byText("Я мог свободу даровать!")).click();
        $(byText("Я мог свободу даровать!")).pressEnter();

        $("[data-cke-csp-href-useless-javascript=\"void('Добавить изображение')\"]").click();
        $$(".CKInlineImageMenu-Text").last().click();
        $(".CKEnterUrlForm-Input")
                .$("input.textinput__control")
                .setValue("https://img1.freepng.ru/20180328/dtw/kisspng-blog-ansichtkaart-clip-art-joyeux-anniversaire-5abb5f8c8dc578.2983252515222291325807.jpg")
                .pressEnter();
        $("#cke_1_contents img").pressEnter();

        $("#cke_1_contents img").should(exist);
//Вставка картинки с компа
        $("[data-cke-csp-href-useless-javascript=\"void('Добавить изображение')\"]").click();
        $(".CKInlineImageMenu-Item").click();
        $(".CKInlineImageMenu-Item").sendKeys(ARROW_LEFT);

        $("button.Button2.Button2_pin_circle-circle.Button2_view_default").click();
        Selenide.closeWebDriver();

        Selenide.open("https://yandex.ru");
        $("[data-statlog='notifications.mail.logout.enter']").shouldBe(visible).click();
        $(".Button2-Text", 0).parent().click();
        if ($("input[type=tel]").exists()) {
            $(".Button2-Text", 0).parent().click();
        }
        $("[id='passp-field-login']").setValue("n.surnametest2");
        $("[id='passp:sign-in']").click();
        $("[id='passp-field-passwd']").setValue("!N.surnametest!").pressEnter();
        $(".desk-notif-card__mail-title").shouldBe(visible).click();
        switchTo().window(1);

        $("[title='n.surnametest@yandex.ru']").click();
        $("strong").shouldHave(text("В чужбине свято наблюдаю"));
        $("u").shouldHave(text("Родной обычай старины:"));

        $("span[style=\"text-decoration:line-through\"]").shouldHave(text("На волю птичку выпускаю"));
        $("em").shouldHave(text("При светлом празднике весны."));
        $$("ul").shouldHave(CollectionCondition.itemWithText("Я стал доступен утешенью;"));
        $$("ol").shouldHave(CollectionCondition.itemWithText("За что на бога мне роптать,"));

        $(".react-message-wrapper__body img").should(exist);


    }

}