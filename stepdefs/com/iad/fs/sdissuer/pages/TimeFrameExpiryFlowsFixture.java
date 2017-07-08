/*
 * Copyright (c) 2017. Vamsi Kuppa
 */

package com.iad.fs.sdissuer.pages;

import com.google.inject.Inject;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class TimeFrameExpiryFlowsFixture {

    private final ProcessIssuerLiability processissuerliablepage;
    private CollaborationRequest collaborationrequestpage;

    @Inject
    public TimeFrameExpiryFlowsFixture(CommonFlowsFixture commonFlowsFixture) {
        processissuerliablepage = commonFlowsFixture.getTimeFrameExpiryPageInstance();
    }

    @Then("^Exception radio button should not be displayed in time frame expiry flow assignment$")
    public void exceptionRadioButtonShouldNotBeDisplayedInTimeFrameExpiryFlowAssignment() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        processissuerliablepage.validateTimeFrameExpiryNoException();
    }

    @Then("^user initiates good faith at time frame expiry flow$")
    public void userInitiatesGoodFaithAtTimeFrameExpiryFlow() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        collaborationrequestpage = processissuerliablepage.takeInitiateCollaborationAction();
        collaborationrequestpage.processInitiateGoodFaith();
    }

    @Then("^user takes write off action at good faith response and validates tab details$")
    public void userTakesWriteOffActionAtGoodFaithResponseAndValidatesTabDetails(DataTable goodfaithdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        collaborationrequestpage.processDeclinedWOGoodFaithResponse(goodfaithdetails.asMap(String.class, String.class));
        collaborationrequestpage.validateTimeFrameExpiryGoodFaithWO();
    }

    @Then("^user takes cardholder liable off action at good faith response and validates tab details$")
    public void userTakesCardholderLiableOffActionAtGoodFaithResponseAndValidatesTabDetails(DataTable goodfaithdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        collaborationrequestpage.processDeclinedCHLiableGoodFaithResponse(goodfaithdetails.asMap(String.class, String.class));
        collaborationrequestpage.validateTimeFrameExpiryGoodFaithCHLiable();
    }


    @Then("^user selects cardholder liable in Time Frame Expiry Flow and resolves the dispute$")
    public void userSelectsCardholderLiableInTimeFrameExpiryFlowAndResolvesTheDisputeAndValidatesTabDetails() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        processissuerliablepage.takeChLiableAction();

    }

    @Then("^user selects write off in Time Frame Expiry Flow and resolves the dispute$")
    public void userSelectsWriteOffInTimeFrameExpiryFlowAndResolvesTheDispute() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        processissuerliablepage.takeWriteOffAction();
    }

    @Then("^user selects multipronged option and selects \"([^\"]*)\" and \"([^\"]*)\" action$")
    public void userSelectsMultiprongedOptionAndSelectsAndAction(String option1, String option2, DataTable amountdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        processissuerliablepage.processMultiPronged(option1, option2, amountdetails.asMap(String.class, String.class));
    }
}
