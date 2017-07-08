/*
 *
 * Created by Vamsi Kuppa on 3/2/2017.
 * Copyright (c) 2017. Vamsi Kuppa
 */

package com.iad.fs.sdissuer.pages;

import com.google.inject.Inject;
import com.iad.fs.sdissuer.MyBrowser;
import com.iad.fs.sdissuer.portal.CaseManagerPortal;
import com.iad.fs.sdissuer.tiles.TopNavFixture;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.testng.Assert;

import java.io.IOException;

@ScenarioScoped
public class CommonFlowsFixture {

    private final CaseManagerPortal casemgrportal;
    private final Claim claim;
    private SearchforTransactions searchfortransactions;
    private ProcessPotentialDuplicates processpotentialduplicatespage;
    private QualifyDispute qualifydisputepage;
    private VCRDisputeQuestionnaire vcrdisputequestionnairepage;
    private SDWorkObjectPage processacquirerresponsepage;
    private QualifyFraud qualifyfraudpage;
    private ProcessIssuerLiability timeframeexpiryassignmentpage;

    @Inject
    public CommonFlowsFixture(MyBrowser browser, TopNavFixture topnavfixture) {
        casemgrportal = browser.getcasemanagerportal();
        claim = topnavfixture.getNewClaim();
        searchfortransactions = claim.getSearchforTransactions();
    }


    //CSR Flow begins here
    @When("^csr enters Transaction information as follows and clicks on search$")
    public void user_enters_Transaction_information_as_follows_and_clicks_on_search(DataTable transactionDetails) throws IOException {
        searchfortransactions.setDataforTransactions(transactionDetails.asMap(String.class, String.class));

    }

    @When("^csr selects single transaction to create a single dispute$")
    public void csr_selects_single_transaction_to_create_a_single_dispute() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        searchfortransactions.selectSingleTransaction();
        if (searchfortransactions.verifyElement(SDWorkObjectPage.CSR_PROCESSDUPLICATESHEADER)) {
            processpotentialduplicatespage = searchfortransactions.getProcessPotentialDuplicates();
            processpotentialduplicatespage.processCSRDuplicatesAssignment();
            qualifydisputepage = processpotentialduplicatespage.getQualifyDispute();

        } else {
            searchfortransactions.findElement(SDWorkObjectPage.CSR_QUALIFYDISPUTEHEADER_LABEL).click();
            qualifydisputepage = searchfortransactions.getQualifyDispute();
        }

    }

    @When("^csr selects transaction to create a fraud claim$")
    public void csr_selects_transaction_to_create_a_fraud_claim() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        searchfortransactions.selectFraudClaim();
        if (searchfortransactions.verifyElement(SDWorkObjectPage.CSR_PROCESSDUPLICATESHEADER)) {
            processpotentialduplicatespage = searchfortransactions.getProcessPotentialDuplicates();
            processpotentialduplicatespage.processCSRDuplicatesAssignment();
            qualifyfraudpage = processpotentialduplicatespage.getQualifyFraud();

        } else {
            searchfortransactions.findElement(SDWorkObjectPage.CSR_QUALIFYFRAUDHEADER_LABEL).click();
            qualifyfraudpage = searchfortransactions.getQualifyFraud();
        }

    }

    @When("^csr process the qualify dispute screen for paid by other means as follows$")
    public void user_process_the_csr_qualify_dispute_screen_as_follows(DataTable qualifydisputedetails) throws Throwable {
        qualifydisputepage.processCSRQualifyDisputeforPaidByOtherMeans(qualifydisputedetails.asMap(String.class, String.class));

    }

    @When("^csr process the qualify dispute screen for duplicate as follows$")
    public void csr_process_the_qualify_dispute_screen_for_duplicate_as_follows(DataTable qualifydisputedetails) throws Throwable {
        qualifydisputepage.processCSRQualifyDisputeforDuplicate(qualifydisputedetails.asMap(String.class, String.class));
    }


    @When("^user process the csr qualify fraud dispute screen$")
    public void user_process_the_csr_qualify_fraud_dispute_screen() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        qualifyfraudpage.processQualifyFraudDispute();
        qualifyfraudpage.extractClaimId();
    }

    @And("^user process the csr qualify fraud dispute screen and selects continue dispute in time frame expiry$")
    public void userProcessTheCsrQualifyFraudDisputeScreenAndLandsOnTimeFrameExpiryFlow() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        qualifyfraudpage.processQualifyFraudDispute();
        qualifyfraudpage.processCSRTimeFrameExpiryContinueDispute();
        qualifyfraudpage.extractClaimId();
    }


    //End of the CSR Flow

    //Start of backend user flow

    @When("^backend user clicks on customer initiated workbasket and filters the dispute$")
    public void user_clicks_on_customer_intiated_workbasket_and_filters_the_dispute() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if (casemgrportal.processCustomerIntiatedWB()) { //Returns true if potential duplicates assignment is found
            processpotentialduplicatespage.processBackendDuplicatesAssignment();
            vcrdisputequestionnairepage = processpotentialduplicatespage.getVCRDisputeQuestionnaire();

        } else { //Otherwise get the VCR Dispute questionnaire assignment
            vcrdisputequestionnairepage = casemgrportal.getVCRDisputeQuestionnaire();

        }

    }

    @When("^user clicks on fraud workbasket and filters the claim$")
    public void backend_user_clicks_on_fraud_workbasket_and_filters_the_claim() throws Throwable {
        if (casemgrportal.processFraudWB()) {
            casemgrportal.findElement(CaseManagerPortal.PROCESSPOTENTIALDUPLICATESASSIGNMENTLINK).click();
            processpotentialduplicatespage = casemgrportal.getProcessPotentialDuplicates();
            processpotentialduplicatespage.processBackendDuplicatesAssignment();
            vcrdisputequestionnairepage = processpotentialduplicatespage.getVCRDisputeQuestionnaire();

        } else {
            casemgrportal.findElement(CaseManagerPortal.VCRDISPUTEQUESTIONNAIRE_LINK).click();
            vcrdisputequestionnairepage = casemgrportal.getVCRDisputeQuestionnaire();
        }

    }

    @When("^user filters the claim from fraud wb and lands on time frame expiry assignment$")
    public void userFiltersTheClaimFromFraudWbAndLandsOnTimeFrameExpiryAssignment() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if (casemgrportal.processFraudWB()) {
            casemgrportal.findElement(CaseManagerPortal.PROCESSPOTENTIALDUPLICATESASSIGNMENTLINK).click();
            processpotentialduplicatespage = casemgrportal.getProcessPotentialDuplicates();
            processpotentialduplicatespage.processBackendDuplicatesAssignment();
            timeframeexpiryassignmentpage = processpotentialduplicatespage.getTimeFrameExpiry();
        } else {
            Assert.assertTrue(casemgrportal.verifyElement(CaseManagerPortal.TIMEFRAMEEXPIRYFLOW_LINK));
            casemgrportal.findElement(CaseManagerPortal.TIMEFRAMEEXPIRYFLOW_LINK).click();
            timeframeexpiryassignmentpage = casemgrportal.getTimeFrameExpiryFlow();
        }

    }

    @When("^backend user validates the data in VCR Dispute Questionnaire assignment for Paid by other means dispute reason as follows$")
    public void user_validates_the_data_in_VCR_Dispute_Questionnaire_as_follows(DataTable disputedetails) throws Throwable {

        vcrdisputequestionnairepage.validatePaidByOtherMeansQuestionnaire(disputedetails.asMap(String.class, String.class));

    }

    @When("^backend user validates the data in VCR Dispute Questionnaire assignment for Duplicates dispute reason as follows$")
    public void backend_user_validates_the_data_in_VCR_Dispute_Questionnaire_assignment_for_Duplicates_dispute_reason_as_follows(DataTable disputedetails) throws Throwable {
        vcrdisputequestionnairepage.validateDuplicatesQuestionnaire(disputedetails.asMap(String.class, String.class));
    }

    /**
     * This method returns the Instance of VCRDisputeQuestionnaireImpl to the calling method
     *
     * @return VCRDisputeQuestionnaire Page
     */
    public VCRDisputeQuestionnaire getVCRDisputeQuestionnaireInstance() {
        return vcrdisputequestionnairepage;
    }

    /**
     * This method returns the instance of process issuer liability impl to the calling method
     *
     * @return
     */
    public ProcessIssuerLiability getTimeFrameExpiryPageInstance() {
        return timeframeexpiryassignmentpage;
    }





    /*//This is when dispute is initiated from backend
    @When("^user selects single transaction to create a single dispute$")
    public void user_selects_the_transaction_to_create_a_single_dispute() throws Throwable {

        searchfortransactions.selectSingleTransaction();
        if(searchfortransactions.verifyElement(searchfortransactions.PROCESSPOTENTIALDUPLICATESASSIGNMENTLINK)){
            searchfortransactions.findElement(searchfortransactions.PROCESSPOTENTIALDUPLICATESASSIGNMENTLINK).click();
            processpotentialduplicatespage = searchfortransactions.getProcessPotentialDuplicates();
            userprocessduplicateassignments();

        }
        else
        {
            searchfortransactions.findElement(searchfortransactions.QUALIFYDISPUTEASSIGNMENTLINK).click();
            qualifydisputepage = searchfortransactions.getQualifyDispute();
        }

    }
    
    //Re usable flow for processing potential duplicates page in backend
    public void userprocessduplicateassignments() throws Throwable { 

        qualifydisputepage = processpotentialduplicatespage.processDuplicatesAssignment();

    }*/

}
