/*
 * Copyright (c) 2017. Vamsi Kuppa
 */

package com.iad.fs.sdissuer.pages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Created by krisv7 on 3/5/2017.
 * This page implementation is about the Initiate case filing and this will process the intitiation of arbitration and take the action of WO and CH Liable
 */
public class InitiateCaseFilingImpl extends SDWorkObjectPageImpl implements InitiateCaseFiling {


    public InitiateCaseFilingImpl(WebElement elmt, String elmtId) {
        super(elmt, elmtId);
    }


    @Override
    public void processInitiateArbitrationCaseFiling() {
        findElement(ARBITRATONREASON_TEXTAREA).sendKeys("Arbitration is initiated");
        findElement(SUBMIT_BUTTON).click();
    }

    @Override
    public void processAssociationAcknowledgement() {
        Assert.assertTrue(verifyElement(SDWorkObjectPage.AWAITINGASSOCIATIONACKNOWLEDGEMENT_LINK));
        findElement(SDWorkObjectPage.AWAITINGASSOCIATIONACKNOWLEDGEMENT_LINK).click();
        findElement(SUBMIT_BUTTON).click();

    }

    @Override
    public void processIssuerLiableWOAssociationRuling() {
        Assert.assertTrue(verifyElement(SDWorkObjectPage.ASSOCIATIONRULING_LINK));
        findElement(SDWorkObjectPage.ASSOCIATIONRULING_LINK).click();
        findElement(ISSUERLIABLE_RADIO).click();
        takeWriteOffAction();

    }

    @Override
    public void processIssuerLiableCHLiableAssociationRuling() {
        findElement(ASSOCIATIONRULING_LINK).click();
        findElement(ISSUERLIABLE_RADIO).click();
        takeChLiableAction();
    }

    @Override
    public void processAcquirerLiableAssociationRuling() {
        Assert.assertTrue(verifyElement(SDWorkObjectPage.ASSOCIATIONRULING_LINK));
        findElement(ASSOCIATIONRULING_LINK).click();
        findElement(ACQUIRERLIABLE_RADIO).click();
        //Assert.assertEquals(findElement(ACQUIRERLIABLE_INFOTEXT).isDisplayed(),true);
        findElement(SUBMIT_BUTTON).click();
        //Assert.assertEquals(findElement(FINALCREDITLETTER).isDisplayed(),true);
        assertCompareIgnoreCaseStrings(findElement(ATTACHMENTS_SECTION).getText(), "Final credit letter");
    }

    @Override
    public void processWithdrawArbitration() {
        pegaDriver.handleWaits().waitForElementVisibility(AWAITINGASSOCIATIONACKNOWLEDGEMENT_LINK);
        findElement(ACTIONS_BUTTON).click();
        findElement(WITHDRAWCASEFILING_LINK).click();
        pegaDriver.handleWaits().waitForElementVisibility(WITHDRAWCASEFILING_LABEL);
        findElement(ARBITRATIONWITHDRAWREASON_TEXTAREA).sendKeys("Withdrawing Arbitration");
        findElement(SUBMIT_BUTTON).click();

    }

    @Override
    public void processWOCaseFilingWithdraw() {
        pegaDriver.handleWaits().waitForElementVisibility(CASEFILEWITHDRAWHEADER_LABEL);
        Assert.assertTrue(verifyElement(CASEFILINGAMOUNT_LABEL));
        takeWriteOffAction();
    }

    @Override
    public void processCHLiableCaseFilingWithdraw() {
        pegaDriver.handleWaits().waitForElementVisibility(CASEFILEWITHDRAWHEADER_LABEL);
        Assert.assertTrue(verifyElement(CASEFILINGAMOUNT_LABEL));
        takeChLiableAction();
    }

    @Override
    public void processInitiateCompliance() {
        pegaDriver.handleWaits().waitForElementVisibility(INITIATECASEFILING_HEADER);
        findElement(COMPLIANCEREASON_TEXTAREA).sendKeys("Initiating Compliance");
        findElement(SUBMIT_BUTTON).click();
    }

    @Override
    public void processComplianceAppeal() {
        pegaDriver.handleWaits().waitForElementVisibility(PENDINGCLOSUREASSIGNMENT_LINK);
    }

    @Override
    public void processWithdrawComplianceCHLiable() {
        Assert.assertTrue(verifyElement(SDWorkObjectPage.AWAITINGASSOCIATIONACKNOWLEDGEMENT_LINK));
        findElement(SDWorkObjectPage.AWAITINGASSOCIATIONACKNOWLEDGEMENT_LINK).click();
        findElement(OTHERACTIONS_BUTTON).click();
        findElement(WITHDRAWCASEFILING_LINK).click();
        Assert.assertTrue(verifyElement(WITHDRAWCASEFILING_LABEL));
        findElement(ARBITRATIONWITHDRAWREASON_TEXTAREA).sendKeys("test");
        findElement(SUBMIT_BUTTON).click();
        takeChLiableAction();
    }

    @Override
    public void processWithdrawComplianceWO() {
        Assert.assertTrue(verifyElement(SDWorkObjectPage.AWAITINGASSOCIATIONACKNOWLEDGEMENT_LINK));
        findElement(SDWorkObjectPage.AWAITINGASSOCIATIONACKNOWLEDGEMENT_LINK).click();
        findElement(OTHERACTIONS_BUTTON).click();
        findElement(WITHDRAWCASEFILING_LINK).click();
        Assert.assertTrue(verifyElement(WITHDRAWCASEFILING_LABEL));
        findElement(ARBITRATIONWITHDRAWREASON_TEXTAREA).sendKeys("test");
        findElement(SUBMIT_BUTTON).click();
        takeWriteOffAction();
    }
}
