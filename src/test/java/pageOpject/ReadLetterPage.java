package pageOpject;

import com.codeborne.selenide.CollectionCondition;

public class ReadLetterPage {
    $("[title='n.surnametest@yandex.ru']").click();
    $("strong").shouldHave(text("В чужбине свято наблюдаю"));
    $("u").shouldHave(text("Родной обычай старины:"));

    $("span[style=\"text-decoration:line-through\"]").shouldHave(text("На волю птичку выпускаю"));
    $("em").shouldHave(text("При светлом празднике весны."));
    $$("ul").shouldHave(CollectionCondition.itemWithText("Я стал доступен утешенью;"));
    $$("ol").shouldHave(CollectionCondition.itemWithText("За что на бога мне роптать,"));

    $(".react-message-wrapper__body img").should(exist);
}
