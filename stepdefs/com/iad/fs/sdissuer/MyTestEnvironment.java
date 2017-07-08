package com.iad.fs.sdissuer;

import com.pega.Browser;
import com.pega.config.test.TestBase1S1D;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class MyTestEnvironment extends TestBase1S1D {

    private Browser browser;

    @Override
    public Browser getBrowser() {
        if (browser == null) {
            browser = new MyBrowser(this);
        }
        return browser;
    }


    @Before
    public void setup(Scenario scenario) {
        initializeStatus();
        startRecording(scenario);
        configureBrowser();
    }

    @After
    public void tearDown(Scenario scenario) {
        tearDown(scenario, false, false);
        terminate();
    }

}
