package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HeaderText;
import pages.WikipediaSteps;

@DisplayName("Проверка приложения 'Википедия'")
public class HeaderTextTest extends TestBase{

    @Test
    @DisplayName("Проверка заголовков приложения 'Википедия'")
    void headerText() {
        new WikipediaSteps()
                .titleCheck(HeaderText.FIRST_HEADER)
                .clickContinueButton()
                .titleCheck(HeaderText.SECOND_HEADER)
                .clickContinueButton()
                .titleCheck(HeaderText.THIRD_HEADER)
                .clickContinueButton()
                .titleCheck(HeaderText.FOURTH_HEADER);
    }
}
