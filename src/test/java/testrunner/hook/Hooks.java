package testrunner.hook;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import util.SetUp;
import util.Util;

public class Hooks {
    @Before(order = 0)
    public void setUp() {
        Util.printLog("---------------------Start of Scenario----------------------");
    }

    @After(order = 0)
    public void tearDown() throws Exception {
        SetUp.driver.quit();
        Util.printLog("--------------------End of Scenario--------------------------");
    }
}