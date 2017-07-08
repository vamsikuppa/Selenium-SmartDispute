/*
 * Copyright (c) 2017. Vamsi Kuppa
 */

package com.iad.fs.sdissuer.pages;

import com.google.inject.Inject;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.testng.Assert;

/**
 * Created by krisv7 on 4/1/2017.
 */

@ScenarioScoped
public class RecallFlowsFixture {

    private final CommonFlowsFixture commonflowsfixture;
    private final VCRDisputeQuestionnaire vcrdisputequestionnairepage;
    private ProcessAcquirerResponse processacquirerresponsepage;
    private InitPreArb initprearbpage;
    private RecallPreArbitration recallprearbitration;

    @Inject
    public RecallFlowsFixture(CommonFlowsFixture commonFlowsFixture) {
        this.commonflowsfixture = commonFlowsFixture;
        vcrdisputequestionnairepage = commonFlowsFixture.getVCRDisputeQuestionnaireInstance();

    }

    @When("^backend user initiates pre arbitration in process acquirer response screen and recalls pre arbitration$")
    public void backend_user_initiates_pre_arbitration_in_process_acquirer_response_screen_and_recalls_pre_arbitration() throws Throwable {
        vcrdisputequestionnairepage.processAcquirerResponse();
        processacquirerresponsepage = vcrdisputequestionnairepage.getProcessAcquirerResponse();
        processacquirerresponsepage.takeInitPreArbAction();
        initprearbpage = processacquirerresponsepage.getInitPreArb();
        initprearbpage.processInitPreArb();
        initprearbpage.processAwaitingPreArbResponse();
        recallprearbitration = initprearbpage.getRecallPreArbitration();
        recallprearbitration.processRecallPreArbitration();
    }

    @Then("^backend user validates the tab details after successful pre arb recall$")
    public void backend_user_validates_the_tab_details_after_successful_recall(DataTable tabdetails) throws Throwable {
        recallprearbitration.validateVCRTabPreArbRecall(tabdetails.asMap(String.class, String.class));
        recallprearbitration.validateOverviewTab(tabdetails.asMap(String.class, String.class));

    }

    @Then("^backend user recalls the dispute and takes write off action validates the tab details after successful dispute recall as follows$")
    public void backendUserRecallsTheDisputeAndValidatesTheTabDetailsAfterSuccessfulDisputeRecall(DataTable tabdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(vcrdisputequestionnairepage.verifyElement(SDWorkObjectPage.AWAITINGACQUIRERRESPONSEASSIGNMENT_LINK));
        vcrdisputequestionnairepage.processWORecallDispute();
        vcrdisputequestionnairepage.validateVCRTabDisputeRecall(tabdetails.asMap(String.class, String.class));
        vcrdisputequestionnairepage.validateOverviewTab(tabdetails.asMap(String.class, String.class));


    }

    @Then("^backend user recalls the dispute and takes cardholder liable action validates the tab details after successful dispute recall as follows$")
    public void backendUserRecallsTheDisputeAndTakesCardholderLiableActionValidatesTheTabDetailsAfterSuccessfulDisputeRecall(DataTable tabdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(vcrdisputequestionnairepage.verifyElement(SDWorkObjectPage.AWAITINGACQUIRERRESPONSEASSIGNMENT_LINK));
        vcrdisputequestionnairepage.processCHLiableRecallDispute();
        vcrdisputequestionnairepage.validateVCRTabDisputeRecall(tabdetails.asMap(String.class, String.class));
        vcrdisputequestionnairepage.validateOverviewTab(tabdetails.asMap(String.class, String.class));
    }

}
