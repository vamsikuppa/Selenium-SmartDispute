/*
 *
 * Created by Vamsi Kuppa on 3/2/2017.
 * Copyright (c) 2017. Vamsi Kuppa
 */

package com.iad.fs.sdissuer.pages;


import com.google.inject.Inject;
import com.iad.fs.sdissuer.portal.CaseManagerPortal;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.testng.Assert;

/**
 * This Fixture is about the Acquirer Declined Flows for Dispute response, Pre Arbitration Response flows and Case Filing flows
 */
@ScenarioScoped
public class DisputeResponseFlowsFixture {

    private SearchforTransactions searchfortransactions;
    private Claim claim;
    private CaseManagerPortal casemgrportal;
    private VCRDisputeQuestionnaire vcrdisputequestionnairepage;
    private QualifyFraud qualifyfraudpage;
    private ProcessAcquirerResponse processacquirerresponsepage;
    private ProcessIssuerLiability processliabilityassignmentpage;
    private CommonFlowsFixture commonFlowsFixture;
    private InitPreArb initprearbpage;
    private ProcessPreArbResponse processprearbresponsepage;
    private InitiateCaseFiling initiatecasefiling;
    private RecallPreArbitration recallprearbitration;

    @Inject
    public DisputeResponseFlowsFixture(CommonFlowsFixture commonFlowsFixture) {
        this.commonFlowsFixture = commonFlowsFixture;
        vcrdisputequestionnairepage = commonFlowsFixture.getVCRDisputeQuestionnaireInstance();

    }

    //Scenario specific
    @When("^backend user takes writeoff action in process acquirer response screen to resolve the dispute and validates the tab details$")
    public void backend_user_takes_writeoff_action_in_process_acquirer_response_screen_to_resolve_the_dispute(DataTable tabdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        vcrdisputequestionnairepage.processAcquirerResponse();
        processacquirerresponsepage = vcrdisputequestionnairepage.getProcessAcquirerResponse();
        processacquirerresponsepage.takeWriteOffAction();
        processacquirerresponsepage.validateVCRTab(tabdetails.asMap(String.class, String.class));
        processacquirerresponsepage.validateOverviewTab(tabdetails.asMap(String.class, String.class));
    }

    //Scenario specific
    @When("^backend user takes cardholder liable action in process acquirer response screen to resolve the dispute and validates tab details$")
    public void backend_user_takes_cardholder_liable_action_in_process_acquirer_response_screen_to_resolve_the_dispute(DataTable tabdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        vcrdisputequestionnairepage.processAcquirerResponse();
        processacquirerresponsepage = vcrdisputequestionnairepage.getProcessAcquirerResponse();
        processacquirerresponsepage.takeChLiableAction();
        processacquirerresponsepage.validateVCRTab(tabdetails.asMap(String.class, String.class));
        processacquirerresponsepage.validateOverviewTab(tabdetails.asMap(String.class, String.class));
    }

    //scenario specific
    @When("^backend user initiates pre arbitration in process acquirer response screen$")
    public void backend_user_initiates_pre_arbitration_in_process_acquirer_response_screen() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        vcrdisputequestionnairepage.processAcquirerResponse();
        processacquirerresponsepage = vcrdisputequestionnairepage.getProcessAcquirerResponse();
        processacquirerresponsepage.takeInitPreArbAction();
        initprearbpage = processacquirerresponsepage.getInitPreArb();
        initprearbpage.processInitPreArb();
        Assert.assertTrue(initprearbpage.verifyElement(SDWorkObjectPage.AWAITINGPREARBRESPONSE_LINK));
        initprearbpage.findElement(SDWorkObjectPage.AWAITINGPREARBRESPONSE_LINK).click();
        processprearbresponsepage = initprearbpage.getProcessPreArbResponse();

    }

    public ProcessPreArbResponse getProcessPreArbResponseInstance() {
        return processprearbresponsepage;
    }


    @When("^backend user initiates arbitration in process acquirer response screen$")
    public void backend_user_intiates_arbitration_in_process_acquirer_response_screen() throws Throwable {
        Assert.assertTrue(processprearbresponsepage.verifyElement(ProcessPreArbResponse.PREARBRESPONSEFROMACQUIRER_LABEL));
        processprearbresponsepage.takeInitArbAction();
        initiatecasefiling = processprearbresponsepage.getInitiateCaseFiling();
        initiatecasefiling.processInitiateArbitrationCaseFiling();
    }


    public InitiateCaseFiling getInitiateCaseFilingInstance() {
        return initiatecasefiling;
    }


    @Then("^backend user resolves the dispute as Acquirer liable and validates the tab details as follows$")
    public void backendUserResolvesTheDisputeAsAcquirerLiableAndValidatesTheTabDetailsAsFollows(DataTable tabdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        vcrdisputequestionnairepage.processAcquirerResponse();
        processacquirerresponsepage = vcrdisputequestionnairepage.getProcessAcquirerResponse();
        processacquirerresponsepage.processAcceptFullAcquirerResponse(tabdetails.asMap(String.class, String.class));
        processacquirerresponsepage.validateVCRTabDisputeResponse(tabdetails.asMap(String.class, String.class));
        processacquirerresponsepage.validateOverviewTab(tabdetails.asMap(String.class, String.class));

    }

    @Then("^backend takes cardholder liable for partial amount liable and resolves the dispute$")
    public void backendTakesCardholderLiableForPartialAmountLiableAndResolvesTheDispute(DataTable tabdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        vcrdisputequestionnairepage.processAcquirerResponse();
        processacquirerresponsepage = vcrdisputequestionnairepage.getProcessAcquirerResponse();
        processacquirerresponsepage.processAcceptPartialCHLiableAcquirerResponse(tabdetails.asMap(String.class, String.class));
        processacquirerresponsepage.validateVCRTab(tabdetails.asMap(String.class, String.class));
        processacquirerresponsepage.validateOverviewTab(tabdetails.asMap(String.class, String.class));

    }

    @Then("^backend writes off for partial amount liable and resolves the dispute$")
    public void backendWritesOffForPartialAmountLiableAndResolvesTheDispute(DataTable tabdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        vcrdisputequestionnairepage.processAcquirerResponse();
        processacquirerresponsepage = vcrdisputequestionnairepage.getProcessAcquirerResponse();
        processacquirerresponsepage.processAcceptPartialWOAcquirerResponse(tabdetails.asMap(String.class, String.class));
        processacquirerresponsepage.validateVCRTab(tabdetails.asMap(String.class, String.class));
        processacquirerresponsepage.validateOverviewTab(tabdetails.asMap(String.class, String.class));
    }


}
