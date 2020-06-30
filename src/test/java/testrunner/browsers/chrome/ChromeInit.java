package testrunner.browsers.chrome;

import cucumber.api.java.Before;
import util.SetUp;

public class ChromeInit {
    @Before
    public static void initChromeBrowser() throws Exception {
        SetUp.initDriver("Chrome");
    }
}
