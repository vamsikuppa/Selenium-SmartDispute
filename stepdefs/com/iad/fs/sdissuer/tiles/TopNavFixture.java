package com.iad.fs.sdissuer.tiles;

import com.google.inject.Inject;
import com.iad.fs.sdissuer.MyBrowser;
import com.iad.fs.sdissuer.pages.Claim;
import com.iad.fs.sdissuer.portal.CaseManagerPortal;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class TopNavFixture {

    private CaseManagerPortal casemgrportal;
    private Claim claim;


    @Inject
    public TopNavFixture(MyBrowser browser) {
        casemgrportal = browser.getcasemanagerportal();
    }


    @When("^Claim is initiated from Create Menu$")
    public void claim_is_initiated_from_Create_Menu() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        claim = casemgrportal.getTopNav().createClaim();

    }

    public Claim getNewClaim() {
        return claim;

    }
}
