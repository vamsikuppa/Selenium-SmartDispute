/*
 *
 * Created by Vamsi Kuppa on 3/2/2017.
 * Copyright (c) 2017. Vamsi Kuppa
 */

package com.iad.fs.sdissuer.pages;

import com.google.inject.Inject;
import com.iad.fs.sdissuer.tiles.TopNavFixture;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

import java.io.IOException;


@ScenarioScoped
public class CommonBackendFlowsFixture {

    private Claim claim;
    private SearchforTransactions searchfortransactions;
    private ProcessPotentialDuplicates processpotentialduplicatespage;
    private QualifyDispute qualifydisputepage;
    private VCRDisputeQuestionnaire vcrdisputequestionnairepage;
    private ProcessAcquirerResponse processacquirerresponsepage;

    @Inject
    public CommonBackendFlowsFixture(TopNavFixture topNavFixture) {
        claim = topNavFixture.getNewClaim();

    }

    //Common flow
    @When("^user enters Transaction information as follows and clicks on search$")
    public void user_enters_Transaction_information_as_follows_and_clicks_on_search(DataTable transactionDetails) throws IOException {

        searchfortransactions = claim.getSearchforTransactions();
        searchfortransactions.setDataforTransactions(transactionDetails.asMap(String.class, String.class));

    }

    //Common flow
    @When("^user selects single transaction to create a single dispute$")
    public void user_selects_the_transaction_to_create_a_single_dispute() throws Throwable {

        searchfortransactions.selectSingleTransaction();
        if (searchfortransactions.verifyElement(searchfortransactions.PROCESSPOTENTIALDUPLICATESASSIGNMENTLINK)) {
            searchfortransactions.findElement(searchfortransactions.PROCESSPOTENTIALDUPLICATESASSIGNMENTLINK).click();
            processpotentialduplicatespage = searchfortransactions.getProcessPotentialDuplicates();
            userprocessduplicateassignments();

        } else {
            searchfortransactions.findElement(searchfortransactions.QUALIFYDISPUTEASSIGNMENTLINK).click();
            qualifydisputepage = searchfortransactions.getQualifyDispute();
        }

    }

    public void userprocessduplicateassignments() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        qualifydisputepage = processpotentialduplicatespage.processDuplicatesAssignment();

    }


    @When("^user process the qualify dispute screen for paid by other means as follows and lands on VCR Dispute Questionnaire screen$")
    public void user_process_the_qualify_dispute_screen_as_follows_and_lands_on_VCR_Dispute_Questionnaire_screen(DataTable disputedetails) throws Throwable {

        vcrdisputequestionnairepage = qualifydisputepage.processPaidByOtherMeansReason(disputedetails.asMap(String.class, String.class));

    }

    @When("^user validates the data in VCR Dispute Questionnaire assignment as follows$")
    public void user_validates_the_data_in_VCR_Dispute_Questionnaire_as_follows(DataTable disputedetails) throws Throwable {

        vcrdisputequestionnairepage.validatePaidByOtherMeansQuestionnaire(disputedetails.asMap(String.class, String.class));

    }

    @When("^user takes writeoff action in process acquirer response screen to resolve the dispute$")
    public void user_takes_writeoff_action_in_process_acquirer_response_screen_to_resolve_the_dispute() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if (vcrdisputequestionnairepage.verifyElement(vcrdisputequestionnairepage.AWAITINGACQUIRERRESPONSEASSIGNMENT_LINK)) {
            vcrdisputequestionnairepage.findElement(vcrdisputequestionnairepage.AWAITINGACQUIRERRESPONSEASSIGNMENT_LINK).click();
            vcrdisputequestionnairepage.getProcessAcquirerResponse();
        }
        processacquirerresponsepage.takeWriteOffAction();
    }

    @When("^user validates the information on Interview tab as follows$")
    public void user_validates_the_information_on_Interview_tab_as_follows(DataTable interviewtabdetails) throws Throwable {
        processacquirerresponsepage.validateInterviewTabPaidByOtherMeans(interviewtabdetails.asMap(String.class, String.class));
    }

    @When("^user validates the information on Overview tab as follows$")
    public void user_validates_the_information_on_Overview_tab_as_follows(DataTable overviewtabdetails) throws Throwable {
        processacquirerresponsepage.validateOverviewTab(overviewtabdetails.asMap(String.class, String.class));
    }

    @When("^user validates the information on VCR tab as follows$")
    public void user_validates_the_information_on_VCR_tab_as_follows(DataTable vcrtabdetails) throws Throwable {
        processacquirerresponsepage.validateVCRTab(vcrtabdetails.asMap(String.class, String.class));

    }

    @And("^user process the qualify dispute screen for another issue and lands on VCR Dispute Questionnaire screen$")
    public void userProcessTheQualifyDisputeScreenForAnotherIssueAndLandsOnVCRDisputeQuestionnaireScreen(DataTable disputedetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        vcrdisputequestionnairepage = qualifydisputepage.processAnotherIssueReason(disputedetails.asMap(String.class, String.class));
    }

    VCRDisputeQuestionnaire getVCRDisputeQuestionnairePageInstance() {
        return vcrdisputequestionnairepage;
    }
}
