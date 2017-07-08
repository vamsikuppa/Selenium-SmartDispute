/*
 * Copyright (c) 2017. Vamsi Kuppa
 */

package com.iad.fs.sdissuer.pages;

import com.google.inject.Inject;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

/**
 * Created by krisv7 on 4/6/2017.
 */
@ScenarioScoped
public class ArbitrationFlowsFixture {


    private final DisputeResponseFlowsFixture disputeresponseflowsfixture;
    private final InitiateCaseFiling initiatecasefiling;

    @Inject
    public ArbitrationFlowsFixture(DisputeResponseFlowsFixture disputeResponseFlowsFixture) {
        this.disputeresponseflowsfixture = disputeResponseFlowsFixture;
        initiatecasefiling = disputeresponseflowsfixture.getInitiateCaseFilingInstance();
    }

    @Then("^backend user processes the association ruling as Issuer Liable and Write off to resolve the dispute and validates the tab details$")
    public void backend_user_processes_the_association_ruling_as_Issuer_Liable_and_Write_off_to_resolve_the_dispute_and_validates_the_tab_details
            (DataTable tabdetails) throws Throwable {
        initiatecasefiling.processAssociationAcknowledgement();
        initiatecasefiling.processIssuerLiableWOAssociationRuling();
        initiatecasefiling.validateVCRTab(tabdetails.asMap(String.class, String.class));
        initiatecasefiling.validateOverviewTab(tabdetails.asMap(String.class, String.class));
    }

    @When("^backend user processes the association ruling as Issuer Liable and cardholder liable action to resolve the dispute and validates the tab details$")
    public void backend_user_processes_the_association_ruling_as_Issuer_Liable_and_cardholder_liable_action_to_resolve_the_dispute_and_validates_the_tab_details
            (DataTable tabdetails) throws Throwable {
        initiatecasefiling.processAssociationAcknowledgement();
        initiatecasefiling.processIssuerLiableCHLiableAssociationRuling();
        initiatecasefiling.validateVCRTab(tabdetails.asMap(String.class, String.class));
        initiatecasefiling.validateOverviewTab(tabdetails.asMap(String.class, String.class));
    }

    @When("^backend user processes the association ruling as Acquirer liable resolve the dispute and validates the tab details$")
    public void backend_user_processes_the_association_ruling_as_Acquirer_liable_resolve_the_dispute_and_validates_the_tab_details
            (DataTable tabdetails) throws Throwable {
        initiatecasefiling.processAssociationAcknowledgement();
        initiatecasefiling.processAcquirerLiableAssociationRuling();
        initiatecasefiling.validateVCRTab(tabdetails.asMap(String.class, String.class));
        initiatecasefiling.validateOverviewTab(tabdetails.asMap(String.class, String.class));

    }

    @Then("^backend user withdraws arbitration at awaiting acquirer response and resolves the dispute as CH Liable$")
    public void backendUserWithdrawsArbitrationAtAwaitingAcquirerResponseAndResolvesTheDisputeAsCHLiable(DataTable tabdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        initiatecasefiling.processWithdrawArbitration();
        initiatecasefiling.processCHLiableCaseFilingWithdraw();
        initiatecasefiling.validateVCRTabWithDrawArbitration();
        initiatecasefiling.validateOverviewTab(tabdetails.asMap(String.class, String.class));
    }

    @Then("^backend user withdraws arbitration at awaiting acquirer response and resolves the dispute as Write off$")
    public void backendUserWithdrawsArbitrationAtAwaitingAcquirerResponseAndResolvesTheDisputeAsWriteOff(DataTable tabdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        initiatecasefiling.processWithdrawArbitration();
        initiatecasefiling.processWOCaseFilingWithdraw();
        initiatecasefiling.validateVCRTabWithDrawArbitration();
        initiatecasefiling.validateOverviewTab(tabdetails.asMap(String.class, String.class));
    }
}
