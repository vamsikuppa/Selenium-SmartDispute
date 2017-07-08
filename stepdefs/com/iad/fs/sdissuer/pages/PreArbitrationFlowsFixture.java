/*
 * Copyright (c) 2017. Vamsi Kuppa
 */

package com.iad.fs.sdissuer.pages;

import com.google.inject.Inject;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;
import org.testng.Assert;

/**
 * Created by krisv7 on 4/8/2017.
 */
@ScenarioScoped
public class PreArbitrationFlowsFixture {

    private final DisputeResponseFlowsFixture disputeresponseflowsfixture;
    private final ProcessPreArbResponse processprearbresponsepage;

    @Inject
    public PreArbitrationFlowsFixture(DisputeResponseFlowsFixture disputeResponseFlowsFixture) {
        this.disputeresponseflowsfixture = disputeResponseFlowsFixture;
        processprearbresponsepage = disputeresponseflowsfixture.getProcessPreArbResponseInstance();
    }


    @When("^backend user takes write off action at process pre arb response screen to resolve the dispute and validates the tab details$")
    public void backend_user_takes_write_off_action_at_process_pre_arb_response_screen_to_resolve_the_dispute_and_validates_the_tab_details(DataTable tabdetails) throws Throwable {
        Assert.assertTrue(processprearbresponsepage.verifyElement(ProcessPreArbResponse.PREARBRESPONSEFROMACQUIRER_LABEL));
        processprearbresponsepage.takeWriteOffAction();

        processprearbresponsepage.validateVCRTab(tabdetails.asMap(String.class, String.class));
        processprearbresponsepage.validateOverviewTab(tabdetails.asMap(String.class, String.class));

    }

    @When("^backend user takes cardholder liable action at process pre arb response screen to resolve the dispute and validates the tab details$")
    public void backend_user_takes_cardholder_liable_action_at_process_pre_arb_response_screen_to_resolve_the_dispute_and_validates_the_tab_details(DataTable tabdetails) throws Throwable {
        Assert.assertTrue(processprearbresponsepage.verifyElement(ProcessPreArbResponse.PREARBRESPONSEFROMACQUIRER_LABEL));
        processprearbresponsepage.takeChLiableAction();

        processprearbresponsepage.validateVCRTab(tabdetails.asMap(String.class, String.class));
        processprearbresponsepage.validateOverviewTab(tabdetails.asMap(String.class, String.class));


    }


    @Then("^backend user resolves the dispute as Acquirer liable and validates the tab details$")
    public void backendUserResolvesTheDisputeAsAcquirerLiableAndValidatesTheTabDetails(DataTable tabdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(processprearbresponsepage.verifyElement(ProcessPreArbResponse.PREARBRESPONSEFROMACQUIRER_LABEL));
        processprearbresponsepage.processPreArbResponseAcquirerLiable(tabdetails.asMap(String.class, String.class));
        processprearbresponsepage.validateVCRTab(tabdetails.asMap(String.class, String.class));
        processprearbresponsepage.validateOverviewTab(tabdetails.asMap(String.class, String.class));
    }


    @And("^backend user resolves the dispute as cardholder liable for partial amount$")
    public void backendUserResolvesTheDisputeAsCardholderLiableForPartialAmount(DataTable tabdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(processprearbresponsepage.verifyElement(ProcessPreArbResponse.PREARBRESPONSEFROMACQUIRER_LABEL));
        processprearbresponsepage.processPreArbResponseCHLiableAcceptPartial(tabdetails.asMap(String.class, String.class));
        processprearbresponsepage.validateVCRTab(tabdetails.asMap(String.class, String.class));
        processprearbresponsepage.validateOverviewTab(tabdetails.asMap(String.class, String.class));
    }

    @Then("^backend user resolves the dispute as write off for partial amount$")
    public void backendUserResolvesTheDisputeAsWriteOffForPartialAmount(DataTable tabdetails) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue(processprearbresponsepage.verifyElement(ProcessPreArbResponse.PREARBRESPONSEFROMACQUIRER_LABEL));
        processprearbresponsepage.processPreArbResponseWOAcceptPartial(tabdetails.asMap(String.class, String.class));
        processprearbresponsepage.validateVCRTab(tabdetails.asMap(String.class, String.class));
        processprearbresponsepage.validateOverviewTab(tabdetails.asMap(String.class, String.class));
    }
}
