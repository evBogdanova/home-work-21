package pages;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class WikipediaSteps {

    @Step("Нажать на кнопку 'Continue'")
        public WikipediaSteps clickContinueButton() {
        $(MobileBy.className("android.widget.Button")).click();
        return this;
    }

    @Step("Проверка заголовка страницы")
    public WikipediaSteps titleCheck(HeaderText headerText) {
        $(MobileBy.className("android.widget.TextView"))
                .shouldHave(Condition.text(headerText.getHeaderText()));
        return this;
    }
}
