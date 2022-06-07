package pageOpject;

import com.codeborne.selenide.CollectionCondition;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.Keys.*;

public class WriteLetterPage {
    static final private String crossedOutText = "[data-cke-csp-href-useless-javascript=\"void('Перечёркнутый')\"]";
    static final private String markedText = "[data-cke-csp-href-useless-javascript=\"void('Маркированный список')\"]";
    static final private String numberedText = "[data-cke-csp-href-useless-javascript=\"void('Нумерованный список')\"]";
    final static String[] textLetter = {"В чужбине свято наблюдаю",
            "Родной обычай старины:",
            "На волю птичку выпускаю",
            "При светлом празднике весны.",
            "Я стал доступен утешенью;",
            "За что на бога мне роптать,",
            "Когда хоть одному творенью",
            "Я мог свободу даровать!"};

   public void write() {
        $("[href='#compose']").click();
        $(".ComposePopup-Content").shouldHave(text("Новое письмо"));
        $$(".MultipleAddressesDesktop-Field.ComposeYabblesField").first().lastChild()
                .sendKeys("n.surnametest2@yandex.ru");
        $("[name='subject']").setValue("Тестовое письмо");
        $("#cke_1_contents").lastChild().setValue(textLetter[0] + '\n' + textLetter[1] + '\n' + textLetter[2] + '\n'
                + textLetter[3] + '\n' + textLetter[4] + '\n' + textLetter[5] + '\n'
                + textLetter[6] + '\n' + textLetter[7]);
        $(byText(textLetter[0])).click();
        $(byText(textLetter[0])).sendKeys(SHIFT, HOME);
        $(byText(textLetter[0])).sendKeys(CONTROL, "b");
        $(byText(textLetter[1])).click();
        $(byText(textLetter[1])).sendKeys(SHIFT, HOME);
        $(byText(textLetter[1])).sendKeys(CONTROL, "u");
        $(byText(textLetter[2])).click();
        $(byText(textLetter[2])).sendKeys(SHIFT, HOME);
        $(crossedOutText).click();
        $(byText(textLetter[3])).click();
        $(byText(textLetter[3])).sendKeys(SHIFT, HOME);
        $(byText(textLetter[3])).sendKeys(CONTROL, "i");
        $(byText(textLetter[4])).click();
        $(byText(textLetter[4])).sendKeys(SHIFT, HOME);
        $(markedText).click();
        $(byText(textLetter[5])).click();
        $(byText(textLetter[5])).sendKeys(SHIFT, HOME);
        $(numberedText).click();
        $("strong").shouldHave(text(textLetter[0]));
        $("u").shouldHave(text(textLetter[1]));
        $("[style='text-decoration:line-through;']").shouldHave(text(textLetter[2]));
        $("em").shouldHave(text(textLetter[3]));
        $$("ul").shouldHave(CollectionCondition.itemWithText(textLetter[4]));
        $$("ol").shouldHave(CollectionCondition.itemWithText(textLetter[5]));
        $(byText(textLetter[7])).click();
        $(byText(textLetter[7])).pressEnter();
        $("[data-cke-csp-href-useless-javascript=\"void('Добавить изображение')\"]").click();
        $$(".CKInlineImageMenu-Text").last().click();
        $(".CKEnterUrlForm-Input")
                .$("input.textinput__control")
                .setValue("https://img1.freepng.ru/20180328/dtw/kisspng-blog-" +
                        "ansichtkaart-clip-art-joyeux-anniversaire-5abb5f8c8dc578.2983252515222291325807.jpg")
                .pressEnter();
        $("#cke_1_contents img").pressEnter();
        $("#cke_1_contents img").should(exist);
        $("button.Button2.Button2_pin_circle-circle.Button2_view_default").click();
    }
}
