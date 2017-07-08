/*
 * Copyright (c) 2017. Vamsi Kuppa
 */

package com.iad.fs.sdissuer.pages;

import com.google.inject.Inject;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.runtime.java.guice.ScenarioScoped;

/**
 * Created by krisv7 on 4/9/2017.
 */

@ScenarioScoped
public class GoodFaithFlowsFixture {

    private final CommonFlowsFixture commonflowsfixture;
    private final VCRDisputeQuestionnaire vcrdisputequestionnairepage;
    private CollaborationRequest collaborationrequestpage;

    @Inject
    public GoodFaithFlowsFixture(CommonFlowsFixture commonFlowsFixture) {
        this.commonflowsfixture = commonFlowsFixture;
        vcrdisputequestionnairepage = commonflowsfixture.getVCRDisputeQuestionnaireInstance();
    }

    @Then("^backend user takes initiate good faith action$")
    public void backendUserTakesInitiateGoodFaithAction() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        collaborationrequestpage = vcrdisputequestionnairepage.getCollaborationRequestScreen();
        collaborationrequestpage.processInitiateGoodFaith();
    }

    @And("^backend resolves the good faith as Acquirer Liable$")
    public void backendResolvesTheGoodFaithAsAcquirerLiable(DataTable goodfaithdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        collaborationrequestpage.processAcceptFullGoodFaithResponse(goodfaithdetails.asMap(String.class, String.class));
        collaborationrequestpage.validateVCRTab(goodfaithdetails.asMap(String.class, String.class));
        collaborationrequestpage.validateOverviewTab(goodfaithdetails.asMap(String.class, String.class));

    }

    @And("^backend resolves the good faith as CH Liable Issuer liable$")
    public void backendResolvesTheGoodFaithAsCHLiableIssuerLiable(DataTable goodfaithdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        collaborationrequestpage.processDeclinedCHLiableGoodFaithResponse(goodfaithdetails.asMap(String.class, String.class));
        collaborationrequestpage.validateGoodFaithResponseVCRTab();
    }

    @And("^backend continues the dispute as response is declined and takes CHLiable action$")
    public void backendContinuesTheDisputeAsResponseIsDeclined(DataTable goodfaithdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        collaborationrequestpage.processDeclinedResumeDisputeGoodFaithResponseCHLiable(goodfaithdetails.asMap(String.class, String.class));
        collaborationrequestpage.validateGoodFaithResponseVCRTab();

    }

    @And("^backend resolves the good faith as Write off Issuer liable$")
    public void backendResolvesTheGoodFaithAsWriteOffIssuerLiable(DataTable goodfaithdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        collaborationrequestpage.processDeclinedWOGoodFaithResponse(goodfaithdetails.asMap(String.class, String.class));
        collaborationrequestpage.validateGoodFaithResponseVCRTab();
    }

    @And("^backend user process good faith with more info$")
    public void backendUserProcessGoodFaithWithMoreInfo(DataTable goodfaithdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        collaborationrequestpage.processNMIGoodFaithResponse(goodfaithdetails.asMap(String.class, String.class));
    }

    @And("^backend continues the dispute as response is declined and takes WO action$")
    public void backendContinuesTheDisputeAsResponseIsDeclinedAndTakesWOAction(DataTable goodfaithdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        collaborationrequestpage.processDeclinedResumeDisputeGoodFaithResponseWO(goodfaithdetails.asMap(String.class, String.class));
        collaborationrequestpage.validateGoodFaithResponseVCRTab();
    }
}
