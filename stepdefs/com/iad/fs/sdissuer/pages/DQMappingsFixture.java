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
 * Created by krisv7 on 4/10/2017.
 */

@ScenarioScoped
public class DQMappingsFixture {

    private final CommonBackendFlowsFixture backendflowsfixture;
    private final VCRDisputeQuestionnaire vcrdisputequestionnairepage;

    @Inject
    public DQMappingsFixture(CommonBackendFlowsFixture commonBackendFlowsFixture) {
        this.backendflowsfixture = commonBackendFlowsFixture;
        vcrdisputequestionnairepage = backendflowsfixture.getVCRDisputeQuestionnairePageInstance();
    }

    @And("^user enters the data in VCR Dispute Questionnaire assignment for Authorization Errors as follows$")
    public void userEntersTheDataInVCRDisputeQuestionnaireAssignmentAsFollows(DataTable disputedetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        vcrdisputequestionnairepage.processAEQuestionnaire(disputedetails.asMap(String.class, String.class));
    }

    @And("^user enters the data in VCR Dispute Questionnaire assignment for Fraud as follows$")
    public void userEntersTheDataInVCRDisputeQuestionnaireAssignmentForFraudAsFollows(DataTable disputedetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        vcrdisputequestionnairepage.processFraudQuestionnaire(disputedetails.asMap(String.class, String.class));
    }

    @And("^user enters the data in VCR Dispute Questionnaire assignment for Processing Errors Duplicate Reason as follows$")
    public void userEntersTheDataInVCRDisputeQuestionnaireAssignmentForProcessingErrorsDuplicateReasonAsFollows(DataTable disputedetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        vcrdisputequestionnairepage.processPEDuplicateOrPaidByOtherMeansQuestionnaire(disputedetails.asMap(String.class, String.class));
    }

    @Then("^user enters the data in VCR Dispute Questionnaire assignment for Processing Errors Incorrect currency Reason as follows$")
    public void userEntersTheDataInVCRDisputeQuestionnaireAssignmentForProcessingErrorsIncorrectCurrencyReasonAsFollows(DataTable disputedetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        vcrdisputequestionnairepage.processPEIncorrectCurrencyQuestionnaire(disputedetails.asMap(String.class, String.class));
    }

    @Then("^user enters the data in VCR Dispute Questionnaire assignment for Processing Errors Incorrect account number Reason as follows$")
    public void userEntersTheDataInVCRDisputeQuestionnaireAssignmentForProcessingErrorsIncorrectAccountNumberReasonAsFollows(DataTable disputedetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        vcrdisputequestionnairepage.processPEIncorrectAccountNumberQuestionnaire(disputedetails.asMap(String.class, String.class));

    }

    @Then("^user enters the data in VCR Dispute Questionnaire assignment for Processing Errors Incorrect Amount Reason as follows$")
    public void userEntersTheDataInVCRDisputeQuestionnaireAssignmentForProcessingErrorsIncorrectAmountReasonAsFollows(DataTable disputedetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        vcrdisputequestionnairepage.processPEIncorrectAmountQuestionnaire(disputedetails.asMap(String.class, String.class));
    }

    @Then("^user enters the data in VCR Dispute Questionnaire assignment for Processing Errors Incorrect Transaction code Reason as follows$")
    public void userEntersTheDataInVCRDisputeQuestionnaireAssignmentForProcessingErrorsTransactionCodeReasonAsFollows(DataTable disputedetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        vcrdisputequestionnairepage.processPEIncorrectTransCodeQuestionnaire(disputedetails.asMap(String.class, String.class));
    }

    @Then("^user enters the data in VCR Dispute Questionnaire assignment for Processing Errors Late Presentment Reason as follows$")
    public void userEntersTheDataInVCRDisputeQuestionnaireAssignmentForProcessingErrorsLatePresentmentReasonAsFollows(DataTable disputedetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        vcrdisputequestionnairepage.processPELatePresentmentQuesitonniare(disputedetails.asMap(String.class, String.class));
    }

    @Then("^user enters the data in VCR Dispute Questionnaire assignment for Processing Errors Paid by other means Reason as follows$")
    public void userEntersTheDataInVCRDisputeQuestionnaireAssignmentForProcessingErrorsPaidByOtherMeansReasonAsFollows(DataTable disputedetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        vcrdisputequestionnairepage.processPEDuplicateOrPaidByOtherMeansQuestionnaire(disputedetails.asMap(String.class, String.class));
    }

    @Then("^user enters the data in VCR Dispute Questionnaire assignment for CD-Merchandise Not Received Reason as follows$")
    public void userEntersTheDataInVCRDisputeQuestionnaireAssignmentForCDMerchandiseNotReceivedReasonAsFollows(DataTable disputedetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }
}
