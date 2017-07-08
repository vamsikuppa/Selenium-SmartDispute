/*
 * Copyright (c) 2017. Vamsi Kuppa
 */

package com.iad.fs.sdissuer.pages;

import com.google.common.cache.ForwardingCache;
import com.google.inject.Inject;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.testng.Assert;

import javax.xml.crypto.Data;

/**
 * Created by krisv7 on 4/2/2017.
 */

@ScenarioScoped
public class ComplianceFlowsFixture {

    private final CommonFlowsFixture commonflowsfixture;
    private final VCRDisputeQuestionnaire vcrdisputequesitonnairepage;
    private InitiatePreCompliance initiateprecompliancepage;
    private InitiateCaseFiling initiatecasefiling;

    @Inject
    public ComplianceFlowsFixture(CommonFlowsFixture commonFlowsFixture) {
        this.commonflowsfixture = commonFlowsFixture;
        vcrdisputequesitonnairepage = commonFlowsFixture.getVCRDisputeQuestionnaireInstance();
    }

    @And("^backend user takes initiate pre compliance flow action and processes the initiate pre compliance as follows$")
    public void backendTakesInitiatePreComplianceFlowActionAndProcessesTheInitiatePreComplianceAsFollows(DataTable precompdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        initiateprecompliancepage = vcrdisputequesitonnairepage.getInitiatePreCompliance();
        initiateprecompliancepage.processInitiatePreCompliance(precompdetails.asMap(String.class, String.class));
    }


    @Then("^backend user resolves the pre compliance as acquirer liable and validates the tab details as follows$")
    public void backendUserResolvesThePreComplianceAsAcquirerLiableAndValidatesTheTabDetailsAsFollows(DataTable tabdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        initiateprecompliancepage.processPrecomplianceResponseAcceptFull(tabdetails.asMap(String.class, String.class));
        initiateprecompliancepage.validateVCRTabPreCompliance(tabdetails.asMap(String.class, String.class));
        initiateprecompliancepage.validateOverviewTab(tabdetails.asMap(String.class, String.class));

    }

    @Then("^backend user resolves the dispute as Issuer liable by taking Cardholder liable action and validates the tab details as follows$")
    public void backendUserResolvesTheDisputeAsIssuerLiableByCardholderLiableActionAndValidatesTheTabDetailsAsFollows(DataTable tabdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        initiateprecompliancepage.processDeclinedCHLiablePreComplianceResponse(tabdetails.asMap(String.class, String.class));
        initiateprecompliancepage.validateVCRTabPreCompliance(tabdetails.asMap(String.class, String.class));
        initiateprecompliancepage.validateOverviewTab(tabdetails.asMap(String.class, String.class));

    }

    @Then("^backend user resolved the dispute as Issuer liable by taking Write off action and validates the tab details as follows$")
    public void backendUserResolvedTheDisputeAsIssuerLiableByTakingWriteOffActionAndValidatesTheTabDetailsAsFollows(DataTable tabdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        initiateprecompliancepage.processDeclinedWOPreComplianceResponse(tabdetails.asMap(String.class, String.class));
        initiateprecompliancepage.validateVCRTabPreCompliance(tabdetails.asMap(String.class, String.class));
        initiateprecompliancepage.validateOverviewTab(tabdetails.asMap(String.class, String.class));

    }


    @Then("^backend user initiates compliance and association ruling is given as acquirer liable and validates the tab details as follows$")
    public void backendUserInitiatesComplianceAndAssociationRulingIsGivenAsAcquirerLiableAndValidatesTheTabDetailsAsFollows(DataTable tabdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        initiateprecompliancepage.getPreComplianceResponsePage();
        initiatecasefiling = initiateprecompliancepage.getCompliance();
        initiatecasefiling.processInitiateCompliance();
        initiatecasefiling.processAssociationAcknowledgement();
        initiatecasefiling.processAcquirerLiableAssociationRuling();
        initiatecasefiling.validateVCRTabCompliance(tabdetails.asMap(String.class, String.class));
        initiatecasefiling.validateOverviewTab(tabdetails.asMap(String.class, String.class));
    }

    @Then("^backend user initiates compliance and association ruling is given as Issuer liable and Issuer selects the Cardholder liable and validates the tab details as follows$")
    public void backendUserIntiatesComplianceAndAssociationRulingIsGivenAsIssuerLiableAndIssuerSelectsTheCardholderLiableAndValidatesTheTabDetailsAsFollows(DataTable tabdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        initiateprecompliancepage.getPreComplianceResponsePage();
        initiatecasefiling = initiateprecompliancepage.getCompliance();
        initiatecasefiling.processInitiateCompliance();
        initiatecasefiling.processAssociationAcknowledgement();
        initiatecasefiling.processIssuerLiableCHLiableAssociationRuling();
        initiatecasefiling.validateVCRTabCompliance(tabdetails.asMap(String.class, String.class));
        initiatecasefiling.validateOverviewTab(tabdetails.asMap(String.class, String.class));
    }

    @Then("^backend user initiates compliance and association ruling is given as Issuer liable and Issuer selects the Write off and validates the tab details as follows$")
    public void backendUserInitiatesComplianceAndAssociationRulingIsGivenAsIssuerLiableAndIssuerSelectsTheWriteOffAndValidatesTheTabDetailsAsFollows(DataTable tabdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        initiateprecompliancepage.getPreComplianceResponsePage();
        initiatecasefiling = initiateprecompliancepage.getCompliance();
        initiatecasefiling.processInitiateCompliance();
        initiatecasefiling.processAssociationAcknowledgement();
        initiatecasefiling.processIssuerLiableWOAssociationRuling();
        initiatecasefiling.validateVCRTabCompliance(tabdetails.asMap(String.class, String.class));
        initiatecasefiling.validateOverviewTab(tabdetails.asMap(String.class, String.class));
    }

    @Then("^backend user resolved the dispute by taking Writeoff action for the partial amount and validates the tab details as follows$")
    public void backendUserResolvedTheDisputeByTakingWriteoffActionForThePartialAmountAndValidatesTheTabDetailsAsFollows(DataTable tabdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        initiateprecompliancepage.processAcceptPartialWOPreComplianceResponse(tabdetails.asMap(String.class, String.class));
        initiateprecompliancepage.validateVCRTabPreCompliance(tabdetails.asMap(String.class, String.class));
        initiateprecompliancepage.validateOverviewTab(tabdetails.asMap(String.class, String.class));

    }

    @Then("^backend user resolved the dispute by taking Cardholder liable action for the partial amount and validates the tab details as follows$")
    public void backendUserResolvedTheDisputeByTakingCardholderLiableActionForThePartialAmountAndValidatesTheTabDetailsAsFollows(DataTable tabdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        initiateprecompliancepage.processAcceptPartialCHLiablePreComplianceResponse(tabdetails.asMap(String.class, String.class));
        initiateprecompliancepage.validateVCRTabPreCompliance(tabdetails.asMap(String.class, String.class));
        initiateprecompliancepage.validateOverviewTab(tabdetails.asMap(String.class, String.class));
    }

    @Then("^backend user initiates compliance for the issuer liable amount and association ruling is Issuer liable and taking write off action and validates tab details as follows$")
    public void backendUserInitiatesComplianceForTheIssuerLiableAmountAndAssociationRulingIsIssuerLiableAndTakingWriteOffActionAndValidatesTabDetailsAsFollows(DataTable tabdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        initiateprecompliancepage.processAcceptPartialCompliance(tabdetails.asMap(String.class, String.class));
        initiatecasefiling = initiateprecompliancepage.getCompliance();
        initiatecasefiling.processInitiateCompliance();
        initiatecasefiling.processAssociationAcknowledgement();
        initiatecasefiling.processIssuerLiableWOAssociationRuling();
        initiatecasefiling.validateVCRTabCompliance(tabdetails.asMap(String.class, String.class));
        initiatecasefiling.validateOverviewTab(tabdetails.asMap(String.class, String.class));


    }

    @Then("^backend user initiates compliance for the issuer liable amount and association ruling is Issuer liable and taking Cardholder liable action and validates tab details as follows$")
    public void backendUserInitiatesComplianceForTheIssuerLiableAmountAndAssociationRulingIsIssuerLiableAndTakingCardholderLiableActionAndValidatesTabDetailsAsFollows(DataTable tabdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        initiateprecompliancepage.processAcceptPartialCompliance(tabdetails.asMap(String.class, String.class));
        initiatecasefiling = initiateprecompliancepage.getCompliance();
        initiatecasefiling.processInitiateCompliance();
        initiatecasefiling.processAssociationAcknowledgement();
        initiatecasefiling.processIssuerLiableCHLiableAssociationRuling();
        initiatecasefiling.validateVCRTabCompliance(tabdetails.asMap(String.class, String.class));
        initiatecasefiling.validateOverviewTab(tabdetails.asMap(String.class, String.class));
    }

    @Then("^backend user initiates compliance for the issuer liable amount and association ruling is Acquirer liable and resolving the dispute and validates tab details as follows$")
    public void backendUserInitiatesComplianceForTheIssuerLiableAmountAndAssociationRulingIsAcquirerLiableAndResolvingTheDisputeAndValidatesTabDetailsAsFollows(DataTable tabdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        initiateprecompliancepage.processAcceptPartialCompliance(tabdetails.asMap(String.class, String.class));
        initiatecasefiling = initiateprecompliancepage.getCompliance();
        initiatecasefiling.processInitiateCompliance();
        initiatecasefiling.processAssociationAcknowledgement();
        initiatecasefiling.processAcquirerLiableAssociationRuling();
        initiatecasefiling.validateVCRTabCompliance(tabdetails.asMap(String.class, String.class));
        initiatecasefiling.validateOverviewTab(tabdetails.asMap(String.class, String.class));
    }


    @Then("^backend recalls precompliance and resolves the dispute$")
    public void backendRecallsPrecomplianceAndResolvesTheDispute(DataTable tabdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        initiateprecompliancepage.processRecallPreCompliance();
        initiateprecompliancepage.validateVCRTabRecallPreCompliance();
        initiateprecompliancepage.validateOverviewTab(tabdetails.asMap(String.class, String.class));
    }

    @Then("^backend user initiates compliance and withdraws compliance and takes Cardholder liable action$")
    public void backendUserInitiatedComplianceAndWithdrawsComplinaceAndTakesCardholderLiableAction(DataTable tabdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        initiateprecompliancepage.getPreComplianceResponsePage();
        initiatecasefiling = initiateprecompliancepage.getCompliance();
        initiatecasefiling.processInitiateCompliance();
        initiatecasefiling.processWithdrawComplianceCHLiable();
        initiatecasefiling.validateVCRTabWithdrawCompliance();
        initiatecasefiling.validateOverviewTab(tabdetails.asMap(String.class,String.class));
    }

    @Then("^backend user initiates compliance and withdraws compliance and takes Write off action$")
    public void backendUserInitiatesComplianceAndWithdrawsComplianceAndTakesWriteOffAction(DataTable tabdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        initiateprecompliancepage.getPreComplianceResponsePage();
        initiatecasefiling = initiateprecompliancepage.getCompliance();
        initiatecasefiling.processInitiateCompliance();
        initiatecasefiling.processWithdrawComplianceWO();
        initiatecasefiling.validateVCRTabWithdrawCompliance();
        initiatecasefiling.validateOverviewTab(tabdetails.asMap(String.class,String.class));
    }


}
