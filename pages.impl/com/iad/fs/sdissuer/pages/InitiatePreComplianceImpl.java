/*
 * Copyright (c) 2017. Vamsi Kuppa
 */

package com.iad.fs.sdissuer.pages;

import com.pega.iad.utils.DataTableUtils;
import com.pega.iad.utils.IADUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Map;

/**
 * Created by krisv7 on 4/2/2017.
 */
public class InitiatePreComplianceImpl extends SDWorkObjectPageImpl implements InitiatePreCompliance {

    public InitiatePreComplianceImpl(WebElement elmt, String elmtId) {
        super(elmt, elmtId);
    }


    @Override
    public void processInitiatePreCompliance(Map<String, String> precompdetails) {
        /*This is for populating and initiating pre compliance*/
        pegaDriver.handleWaits().waitForElementVisibility(INITIATEPRECOMPLIANCE_HEADER);
        findSelectBox(INTIIATORANDSOURCE_DROPDOWN).selectByVisibleText("CARDHOLDER INIT EMAIL");
        if (verifyElement(PROCESSASSOCIATEDTRANSACTIONS_HEADER)) {
            findElement(ASSOCIATEDTRANSACTIONSNOTVALID_TEXTAREA).sendKeys("Associated transactions are not valid");
            findElement(SUBMIT_BUTTON).click();
        }

        /*This is for populating the create pre compliance screen */

        findSelectBox(PRIMARYVIOLATION_SELECT).selectByVisibleText(DataTableUtils.getDataTableValue(precompdetails, "Primary Violation"));
        findSelectBox(SECONDARYVIOLATION_SELECT).selectByVisibleText(DataTableUtils.getDataTableValue(precompdetails, "Secondary Violation"));
        findSelectBox(ADDITIONALVIOLATION_SELECT).selectByVisibleText(DataTableUtils.getDataTableValue(precompdetails, "Additional Violation"));
        getPreviousDate("Date of violation", "DateofViolation", 3);
        getYesterdaysDate("Date of discovery", "DateOfDiscovery");
        findElement(DISCOVERYDATEREASON_TEXTAREA).sendKeys("Discovery date is required");
        getFutureDate("Planned filing date","PlannedFilingDate",1);
        findElement(INITATINGPRECOMPLIANCEREASON_TEXTAREA).sendKeys(DataTableUtils.getDataTableValue(precompdetails, "Reason for pre compliance"));
        findElement(FINANCIALLOSSYESIND_RADIO).click();
        findElement(FINANCIALLOSSEXPLANATION_TEXTAREA).sendKeys("test");
        findElement(SUBMIT_BUTTON).click();
    }

    @Override
    public void getPreComplianceResponsePage() {
        if (verifyElement(AWAITINGPRECOMPLIANCERESPONSE_LINK)) {
            findElement(AWAITINGPRECOMPLIANCERESPONSE_LINK).click();
        }
        pegaDriver.handleWaits().waitForElementVisibility(AWAITINGPRECOMPLANCERESPONSE_HEADER);
        findElement(SUBMIT_BUTTON).click();
        if (verifyElement(PROCESSPRECOMPLIANCERESPONSE_LINK)) {
            findElement(PROCESSPRECOMPLIANCERESPONSE_LINK).click();
        }

    }


    @Override
    public void processPrecomplianceResponseAcceptFull(Map<String, String> precomprespdetails) {
        getPreComplianceResponsePage();
        boolean acquirerrespdisplayed = verifyElement(IADUtils.parameterizeBy(ACQUIRERRESPONSE_TEXT, DataTableUtils.getDataTableValue(precomprespdetails, "Acquirer response")));
        Assert.assertEquals(acquirerrespdisplayed, true);
        findElement(SUBMIT_BUTTON).click();
    }

    @Override
    public void processAcceptPartialWOPreComplianceResponse(Map<String, String> precomprespdetails) {
        getPreComplianceResponsePage();
        boolean acquirerrespdisplayed = verifyElement(IADUtils.parameterizeBy(ACQUIRERRESPONSE_TEXT, DataTableUtils.getDataTableValue(precomprespdetails, "Acquirer response")));
        Assert.assertEquals(acquirerrespdisplayed, true);
        Assert.assertTrue(verifyElement(ACCEPTANCEAMOUNT_LABEL));
        takeWriteOffAction();
    }

    @Override
    public void processAcceptPartialCHLiablePreComplianceResponse(Map<String, String> precomprespdetails) {
        getPreComplianceResponsePage();
        boolean acquirerrespdisplayed = verifyElement(IADUtils.parameterizeBy(ACQUIRERRESPONSE_TEXT, DataTableUtils.getDataTableValue(precomprespdetails, "Acquirer response")));
        Assert.assertEquals(acquirerrespdisplayed, true);
        Assert.assertTrue(verifyElement(ACCEPTANCEAMOUNT_LABEL));
        takeChLiableAction();
    }

    @Override
    public void processAcceptPartialCompliance(Map<String, String> precomprespdetails) {
        getPreComplianceResponsePage();
        boolean acquirerrespdisplayed = verifyElement(IADUtils.parameterizeBy(ACQUIRERRESPONSE_TEXT, DataTableUtils.getDataTableValue(precomprespdetails, "Acquirer response")));
        Assert.assertEquals(acquirerrespdisplayed, true);
        Assert.assertTrue(verifyElement(ACCEPTANCEAMOUNT_LABEL));
        findElement(INITIATECOMPLIANCE_RADIO).click();
        findElement(SUBMIT_BUTTON).click();
    }

    @Override
    public void processDeclinedWOPreComplianceResponse(Map<String, String> precomprespdetails) {
        getPreComplianceResponsePage();
        boolean acquirerrespdisplayed = verifyElement(IADUtils.parameterizeBy(ACQUIRERRESPONSE_TEXT, DataTableUtils.getDataTableValue(precomprespdetails, "Acquirer response")));
        Assert.assertEquals(acquirerrespdisplayed, true);
        takeWriteOffAction();

    }

    @Override
    public void processDeclinedCHLiablePreComplianceResponse(Map<String, String> precomprespdetails) {
        getPreComplianceResponsePage();
        boolean acquirerrespdisplayed = verifyElement(IADUtils.parameterizeBy(ACQUIRERRESPONSE_TEXT, DataTableUtils.getDataTableValue(precomprespdetails, "Acquirer response")));
        Assert.assertEquals(acquirerrespdisplayed, true);
        takeChLiableAction();
    }

    @Override
    public void processRecallPreCompliance() {
        if (verifyElement(AWAITINGPRECOMPLIANCERESPONSE_LINK)) {
            findElement(AWAITINGPRECOMPLIANCERESPONSE_LINK).click();
        }
        findElement(OTHERACTIONS_BUTTON).click();
        findElement(RECALLPRECOMPLIANCE_LINK).click();
        pegaDriver.handleWaits().waitForElementVisibility(RECALLPRECOMPLIANCE_LINK);
        findElement(RECALLREASON_TEXTAREA).sendKeys("Recalling Pre compliance");
        findElement(SUBMIT_BUTTON).click();
    }


    @Override
    public InitiateCaseFiling getCompliance() {
        findElement(INITIATECOMPLIANCE_RADIO).click();
        findElement(SUBMIT_BUTTON).click();
        findElement(SDWorkObjectPage.INITIATECASEFILING_LINK).click();
        wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
        InitiateCaseFiling stage = new InitiateCaseFilingImpl(wizard, wizard.getId());
        stage._setEnvironment(testEnv, wizard.getId());
        return stage;
    }


}
