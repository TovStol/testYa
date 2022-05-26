package junit;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class YandexTest1 {
    @BeforeAll
    static void openBrowse() {

        Selenide.open("https://yandex.ru");

    }

    @AfterAll
    static void closeBrowse() {
        Selenide.closeWebDriver();
    }


    @Test
    void firstTest() {

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

//Шаг 1: Нажать на кнопку Написать.
        $("[href='#compose']").click();

//Ожидание: Открывается экран написания нового письма
        $(".ComposePopup-Content").shouldHave(text("Новое письмо"));
/*
//Шаг 2: Заполнить поля Кому, Тема, в поле для ввода текста письма вставить
//текст из нескольких абзацев.
// Заполнение поля адреса
        $$(".MultipleAddressesDesktop-Field.ComposeYabblesField")
                .first()
                .lastChild()
                .sendKeys("n.surnametest@yandex.ru");
//Заполнение поля темы
        $("[name='subject']").setValue("Тестовое письмо");

//Написание письма
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
// К разным частям текста письма применить следующие виды форматирования:
//Жирный
    $(byText("В чужбине свято наблюдаю")).click();
    $(byText("В чужбине свято наблюдаю")).sendKeys(SHIFT,HOME);
    $(byText("В чужбине свято наблюдаю")).sendKeys(CONTROL, "b");
//Подчеркивание
    $(byText("Родной обычай старины:")).click();
    $(byText("Родной обычай старины:")).sendKeys(SHIFT,HOME);
    $(byText("Родной обычай старины:")).sendKeys(CONTROL, "u");
//Зачеркивание
        $(byText("На волю птичку выпускаю")).click();
        $(byText("На волю птичку выпускаю")).sendKeys(SHIFT,HOME);
        $("[data-cke-csp-href-useless-javascript=\"void('Перечёркнутый')\"]").click();
//Курсив
        $(byText("При светлом празднике весны.")).click();
        $(byText("При светлом празднике весны.")).sendKeys(SHIFT,HOME);
        $(byText("При светлом празднике весны.")).sendKeys(CONTROL, "i");
//Маркированный список
        $(byText("Я стал доступен утешенью;")).click();
        $(byText("Я стал доступен утешенью;")).sendKeys(SHIFT,HOME);
        $("[data-cke-csp-href-useless-javascript=\"void('Маркированный список')\"]").click();
//Нумерованный список
        $(byText("За что на бога мне роптать,")).click();
        $(byText("За что на бога мне роптать,")).sendKeys(SHIFT,HOME);
        $("[data-cke-csp-href-useless-javascript=\"void('Нумерованный список')\"]").click();


//  Ожидание: Текст отображается с учетом форматирования.
        $("strong").shouldHave(text("В чужбине свято наблюдаю"));
        $("u").shouldHave(text("Родной обычай старины:"));
        $("[style='text-decoration:line-through;']").shouldHave(text("На волю птичку выпускаю"));
        $("em").shouldHave(text("При светлом празднике весны."));
        $$("ul").shouldHave(CollectionCondition.itemWithText("Я стал доступен утешенью;"));
        $$("ol").shouldHave(CollectionCondition.itemWithText("За что на бога мне роптать,"));

//Шаг 3: Вставить валидные картинки выбором с компьютера и ссылкой.

// Вставка картинки ссылкой
        $(byText("Я мог свободу даровать!")).click();
        $(byText("Я мог свободу даровать!")).pressEnter();

 */
        $("[data-cke-csp-href-useless-javascript=\"void('Добавить изображение')\"]").click();
        $$(".CKInlineImageMenu-Text").last().click();
        $(".CKEnterUrlForm-Input")
                .$("input.textinput__control")
                .setValue("https://img1.freepng.ru/20180328/dtw/kisspng-blog-ansichtkaart-clip-art-joyeux-anniversaire-5abb5f8c8dc578.2983252515222291325807.jpg")
                .pressEnter();
//Вставка картинки с компа

        //  $("[data-cke-csp-href-useless-javascript=\"void('Добавить изображение')\"]").click();
        //  $$(".CKInlineImageMenu-Text").first().sendKeys("C:\\временная\\обучение\\java\\тест.jpg");

// Ожидание: Картинки корректно вставились.
        $("[data-cke-saved-src^=\"https://\"]").exists();
//Шаг 4: Отправить письмо.


         sleep(5000);



        /*
         */
    }
}
