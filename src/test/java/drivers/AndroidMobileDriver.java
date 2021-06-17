package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.DeviceHost;
import config.ProjectData;
import helpers.AppiumHelper;
import helpers.BrowserstackHelper;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import static config.ProjectData.*;

public class AndroidMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        if (ProjectData.deviceHost().equals(DeviceHost.BROWSERSTACK))
            return getBrowserstackMobileDriver(desiredCapabilities);
        else
            return getAppiumMobileDriver(desiredCapabilities);
    }

    public AndroidDriver<WebElement> getAppiumMobileDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("platformName", appiumConfig.platformName());
        desiredCapabilities.setCapability("deviceName", appiumConfig.deviceName());
        desiredCapabilities.setCapability("version", appiumConfig.version());
        desiredCapabilities.setCapability("locale", appiumConfig.locale());
        desiredCapabilities.setCapability("language", appiumConfig.language());
        desiredCapabilities.setCapability("appPackage", appiumConfig.appPackage());
        desiredCapabilities.setCapability("appActivity", appiumConfig.appActivity());
        desiredCapabilities.setCapability("app", appiumConfig.appUrl());

        if (deviceHost().equals(DeviceHost.SELENOID)) {
            desiredCapabilities.setCapability("enableVNC", true);
            desiredCapabilities.setCapability("enableVideo", true);
        }

        return new AndroidDriver<>(AppiumHelper.getAppiumServerUrl(), desiredCapabilities);
    }

    public AndroidDriver<WebElement> getBrowserstackMobileDriver(DesiredCapabilities desiredCapabilities) {
        desiredCapabilities.setCapability("project", "qa_guru_21");
        desiredCapabilities.setCapability("build", "Android");
        desiredCapabilities.setCapability("name", "WikiMobileTests");
        desiredCapabilities.setCapability("autoGrantPermissions", "true");

        desiredCapabilities.setCapability("device", browserstackConfig.device());
        desiredCapabilities.setCapability("os_version", browserstackConfig.osVersion());
        desiredCapabilities.setCapability("app", browserstackConfig.app());

        return new AndroidDriver<>(BrowserstackHelper.getBrowserstackUrl(), desiredCapabilities);
    }
}