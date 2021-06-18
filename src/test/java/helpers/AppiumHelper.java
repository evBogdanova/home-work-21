package helpers;

import config.ProjectData;

import java.net.MalformedURLException;
import java.net.URL;

import static config.ProjectData.appiumConfig;

public class AppiumHelper {

    public static URL getAppiumServerUrl() {
        try {
            return new URL(isCredentials() ? String.format(appiumConfig.selenoidUrl(),
                    appiumConfig.selenoidUser(),
                    appiumConfig.selenoidPassword()) :
                    appiumConfig.selenoidUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Credentials are not used for local launch
     */
    public static boolean isCredentials() {
        return appiumConfig.selenoidPassword() != null && appiumConfig.selenoidUser() != null &&
                !appiumConfig.selenoidPassword().equals("") && !appiumConfig.selenoidUser().equals("");
    }

    public static String getSelenoidVideoUrl(String sessionId) {
        return ProjectData.appiumConfig.videoStorage() + sessionId + ".mp4";
    }
}
