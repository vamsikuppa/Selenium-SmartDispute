/*
 *
 * Created by Vamsi Kuppa on 3/2/2017.
 * Copyright (c) 2017. Vamsi Kuppa
 */

package com.iad.fs.sdissuer.pages;


import com.google.inject.Inject;
import com.iad.fs.sdissuer.portal.CaseManagerPortal;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.testng.Assert;


@ScenarioScoped
public class AllocationFlowsFixture {

    private SearchforTransactions searchfortransactions;
    private Claim claim;
    private CaseManagerPortal casemgrportal;
    private VCRDisputeQuestionnaire vcrdisputequestionnairepage;
    private QualifyFraud qualifyfraudpage;
    private ProcessAcquirerResponse processacquirerresponsepage;
    private ProcessIssuerLiability processliabilityassignmentpage;
    private CommonFlowsFixture commonFlowsFixture;
    private ProcessPreArbResponse processprearbresponse;
    private CollaborationRequest collaborationrequestpage;

    @Inject
    public AllocationFlowsFixture(CommonFlowsFixture commonFlowsFixture) {
        this.commonFlowsFixture = commonFlowsFixture;
        vcrdisputequestionnairepage = commonFlowsFixture.getVCRDisputeQuestionnaireInstance();
    }


    //Scenario specific
    @When("^backend user validates the Fraud data in VCR Dispute Questionnaire Page as follows$")
    public void backend_user_validates_the_Fraud_data_in_VCR_Dispute_Questionnaire_Page_as_follows(DataTable frauddetails) throws Throwable {
        vcrdisputequestionnairepage.validateFraudQuestionnaire(frauddetails.asMap(String.class, String.class));
        processliabilityassignmentpage = vcrdisputequestionnairepage.getProcessIssuerLiability();
    }

    //Scenario specific
    @When("^backend user takes writeoff action in process Issuer Liability assignment and validates tab details as follows$")
    public void backend_user_takes_writeoff_action_in_process_Issuer_Liability_assignment_and_validates_tab_details_as_follows(DataTable tabdetails) throws Throwable {
        processliabilityassignmentpage.takeWriteOffAction();
        processliabilityassignmentpage.validateVCRTab(tabdetails.asMap(String.class, String.class));
        processliabilityassignmentpage.validateOverviewTab(tabdetails.asMap(String.class, String.class));
    }

    @Then("^user selects multipronged option in process issuer liability assignment and selects \"([^\"]*)\" and \"([^\"]*)\" action$")
    public void userSelectsMultiprongedOptionAndSelectsAndAction(String option1, String option2, DataTable amountdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        processliabilityassignmentpage.processMultiPronged(option1, option2, amountdetails.asMap(String.class, String.class));
    }

    //Scenario specific
    @When("^backend user takes Cardholder liable action in process Issuer Liability assignment and validates tab details as follows$")
    public void backend_user_takes_Cardholder_liable_action_in_process_Issuer_Liability_assignment_and_validates_tab_details_as_follows(DataTable tabdetails) throws Throwable {
        processliabilityassignmentpage.takeChLiableAction();
        processliabilityassignmentpage.validateVCRTab(tabdetails.asMap(String.class, String.class));
        processliabilityassignmentpage.validateOverviewTab(tabdetails.asMap(String.class, String.class));
    }

    @When("^backend user opens Process Acquirer response assignment and then reads the Pre Arbitration information$")
    public void backend_user_takes_open_Process_Acquirer_response_asignment_and_then_reads_the_Pre_Arbitration_information() throws Throwable {
        Assert.assertTrue(vcrdisputequestionnairepage.verifyElement(SDWorkObjectPage.AWAITINGACQUIRERRESPONSEASSIGNMENT_LINK));
        vcrdisputequestionnairepage.findElement(SDWorkObjectPage.AWAITINGACQUIRERRESPONSEASSIGNMENT_LINK).click();
        vcrdisputequestionnairepage.findElement(SDWorkObjectPage.SUBMIT_BUTTON).click();
        processprearbresponse = vcrdisputequestionnairepage.getProcessPreArbResponse();
        processprearbresponse.validatePreArbLabels();
    }

    @Then("^backend user Accepts fully the Pre Arb response and then takes Write-off action$")
    public void backend_user_Accepts_fully_the_Pre_Arb_response_and_then_takes_Write_off_action() throws Throwable {
        processprearbresponse.processPreArbRespAcceptFully();
        processprearbresponse.processPreArbResponseAcceptfullyWO();
    }

    @Then("^backend user Accepts fully the Pre Arb response and then takes Cardholder liable action$")
    public void backend_user_Accepts_fully_the_Pre_Arb_response_and_then_takes_Cardholder_liable_action() throws Throwable {
        processprearbresponse.processPreArbRespAcceptFully();
        processprearbresponse.processPreArbResponseAcceptfullyCH();
    }

    @Then("^backend user Accepts partially the Pre Arb response and then takes Write-off action$")
    public void backend_user_Accepts_partially_the_Pre_Arb_response_and_then_takes_Write_off_action() throws Throwable {
        processprearbresponse.processPreArbResponseAcceptPartially();
        processprearbresponse.processPreArbRespAcceptPartiallyWO();
    }

    @Then("^backend user Accepts partially the Pre Arb response and then takes cardholder liable action$")
    public void backend_user_Accepts_partially_the_Pre_Arb_response_and_then_takes_cardholder_liable_action() throws Throwable {
        processprearbresponse.processPreArbResponseAcceptPartially();
        processprearbresponse.processPreArbRespAcceptPartiallyCH();
    }

    @Then("^backend user Declines the Pre Arb response$")
    public void backend_user_Declines_the_Pre_Arb_response() throws Throwable {
        processprearbresponse.processPreArbResponseDeclined();

    }


    @And("^backend user validates the Fraud data and takes Initiate RFC action$")
    public void backendUserValidatesTheFraudDataAndTakesInitiateRFCAction(DataTable frauddetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        vcrdisputequestionnairepage = vcrdisputequestionnairepage.processInitiateRFC(frauddetails.asMap(String.class, String.class));

    }

    @Then("^backend validates RFC fulfillment message and validates tab details as follows$")
    public void backendValidatesRFCFulfillmentMessageAndValidatesTabDetailsAsFollows(DataTable rfcdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        vcrdisputequestionnairepage.processRFCResponse(rfcdetails.asMap(String.class, String.class));
        vcrdisputequestionnairepage.validateRetrievalRequestTab(rfcdetails.asMap(String.class, String.class));
        vcrdisputequestionnairepage.validateOverviewTab(rfcdetails.asMap(String.class, String.class));

    }

    @And("^backend user takes Submit Fraud Report action$")
    public void backendUserValidatesTheFraudDataAndTakesSubmitFraudReportAction() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        vcrdisputequestionnairepage.processSubmitFraudReport();
    }

    @And("^backend user edits the fraud report and validates the fraud data and submits it$")
    public void backendUserEditsTheFraudReportAndSubmitsIt(DataTable fraudetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        vcrdisputequestionnairepage.processEditFraudReport(fraudetails.asMap(String.class, String.class));
        vcrdisputequestionnairepage.validateVCRTabFraudReport(fraudetails.asMap(String.class, String.class));
        vcrdisputequestionnairepage.validateFraudQuestionnaire(fraudetails.asMap(String.class, String.class));

    }

    @Then("^backend user takes Submit Fraud Report action and closes the dispute$")
    public void backendUserTakesSubmitFraudReportActionAndClosesTheDispute(DataTable fraudetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        vcrdisputequestionnairepage.processSubmitFraudReportCloseDispute();
        vcrdisputequestionnairepage.validateVCRTabFraudReport(fraudetails.asMap(String.class, String.class));
    }


    @And("^user validates the tab details after multi pronged in process issuer liability$")
    public void userValidatesTheTabDetailsAfterMultiProngedInProcessIssuerLiability(DataTable tabdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        processliabilityassignmentpage.validateVCRTabDisputeRecall(tabdetails.asMap(String.class, String.class));
        processliabilityassignmentpage.validateOverviewTab(tabdetails.asMap(String.class, String.class));

    }

    @Then("^^user clicks on exceptions radio in process issuer liability and validates tab details$$")
    public void userClicksOnExceptionsRadioInProcessIssuerLiability(DataTable tabdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        processliabilityassignmentpage.processExceptionsAction();
        processliabilityassignmentpage.validateVCRTabDisputeRecall(tabdetails.asMap(String.class, String.class));
        processliabilityassignmentpage.validateOverviewTab(tabdetails.asMap(String.class, String.class));
    }


}


