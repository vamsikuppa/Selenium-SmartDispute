/*
 * Copyright (c) 2017. Vamsi Kuppa
 */

package com.iad.fs.sdissuer.pages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;


/**
 * Created by krisv7 on 3/3/2017.
 */
public class InitPreArbImpl extends SDWorkObjectPageImpl implements InitPreArb {

    public InitPreArbImpl(WebElement elmt, String elmtId) {
        super(elmt, elmtId);
    }

    @Override
    public void processInitPreArb() {
        pegaDriver.handleWaits().waitForElementVisibility(INITIATEPREARB_LABEL);
        //findSelectBox(INITIATEPREARBREASON_DROPDOWN).selectByVisibleText("" + LocalizationUtil.getLocalizedWord("Credit Processed") + "");
        if (verifyElement(INITPREARBREASON_TEXTAREA)) {
            findElement(INITPREARBREASON_TEXTAREA).sendKeys("Pre Arb is initiated as cardholder is not liable");
        }
        if (verifyElement(CREDITPROCESSEDDATE_TEXT)) {
            getYesterdaysDate("What is the credit processed date?", "CreditProcessedDate");
        }
        if (verifyElement(ACQUIRERREFERENCENUMBER_TEXT)) {
            findElement(ACQUIRERREFERENCENUMBER_TEXT).sendKeys("24610432650004020160855");
        }
        if (verifyElement(CONTINUEDISPUTE_TEXTAREA)) {
            findElement(CONTINUEDISPUTE_TEXTAREA).sendKeys("Pre Arbitration is initialized");
        }
        if (verifyElement(ISSUERCERTIFESCEQUESTION_LABEL)) {
            findElement(ISSUERCERTIFIESCEYES_RADIO).click();
            findElement(CARDHOLDERCONTINUESDISPUTE_TEXTAREA).sendKeys("test");
        }
        findElement(PREARBNOTES_TEXTAREA).sendKeys("Initiating pre arbitration");
        findElement(SUBMIT_BUTTON).click();

    }

    @Override
    public ProcessPreArbResponse getProcessPreArbResponse() {
        findElement(SUBMIT_BUTTON).click();
        wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
        ProcessPreArbResponse stage = new ProcessPreArbResponseImpl(wizard, wizard.getId());
        stage._setEnvironment(testEnv, wizard.getId());
        return stage;
    }

    @Override
    public RecallPreArbitration getRecallPreArbitration() {
        findElement(OTHERACTIONS_BUTTON).click();
        findElement(RECALLPREARBITRATION_LINK).click();
        wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
        RecallPreArbitration stage = new RecallPreArbitrationImpl(wizard, wizard.getId());
        stage._setEnvironment(testEnv, wizard.getId());
        return stage;

    }

    @Override
    public void processAwaitingPreArbResponse() {
        Assert.assertTrue(verifyElement(SDWorkObjectPage.AWAITINGPREARBRESPONSE_LINK));
        findElement(SDWorkObjectPage.AWAITINGPREARBRESPONSE_LINK).click();
    }

}
