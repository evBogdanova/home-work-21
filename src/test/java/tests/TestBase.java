package tests;

import com.codeborne.selenide.Configuration;
import config.DeviceHost;
import config.ProjectData;
import drivers.AndroidMobileDriver;
import helpers.AttachmentHelper;
import helpers.BrowserstackHelper;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentHelper.getSessionId;


public class TestBase {

    @BeforeAll
    public static void setup() {
        addListener("AllureSelenide", new AllureSelenide());

        Configuration.browser = AndroidMobileDriver.class.getName();
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    @AfterEach
    public void afterEach() {
        AttachmentHelper.screenshotAs("Last screenshot");

        if (!ProjectData.deviceHost().equals(DeviceHost.EMULATION)) {
            String sessionId = getSessionId();
            AttachmentHelper.attachVideo(sessionId);
            if (ProjectData.deviceHost().equals(DeviceHost.BROWSERSTACK))
                AttachmentHelper.attachAsText("Browserstack build link",
                        BrowserstackHelper.getBSPublicLink(sessionId));
        }

        closeWebDriver();
    }
}