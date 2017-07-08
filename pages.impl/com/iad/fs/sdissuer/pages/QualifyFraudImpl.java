package com.iad.fs.sdissuer.pages;

import org.openqa.selenium.WebElement;

public class QualifyFraudImpl extends SDWorkObjectPageImpl implements QualifyFraud {

    public QualifyFraudImpl(WebElement elmt, String elmtId) {
        super(elmt, elmtId);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void processQualifyFraudDispute() {
        pegaDriver.handleWaits().waitForElementVisibility(FRAUD_LABEL);
        findSelectBox(CARDSTATUS_DROPDOWN).selectByVisibleText("Lost");
        findElement(POSESSIONCARD_RADIO).click();
        findElement(CARDPIN_RADIO).click();
        findElement(MERCHANTRECOGNIZE_RADIO).click();
        findElement(CHAUTHORIZE_RADIO).click();
        findElement(COMMENTS).sendKeys("Continue as fraud");
        findElement(CONTINUEFRAUD).click();
        findElement(SUBMIT_BUTTON).click();
    }

    @Override
    public void processCSRTimeFrameExpiryWO() {
        pegaDriver.handleWaits().waitForElementVisibility(CSRTIMEFRAMEEXPIRED_LABEL);
        findElement(WRITEOFF_RADIO).click();
        findElement(SUBMIT_BUTTON).click();
    }

    @Override
    public void processCSRTimeFrameExpiryCHLiable() {
        pegaDriver.handleWaits().waitForElementVisibility(CSRTIMEFRAMEEXPIRED_LABEL);
        findElement(CARDHOLDERLIABLE_RADIO).click();
        findElement(SUBMIT_BUTTON).click();
    }

    @Override
    public void processCSRTimeFrameExpiryContinueDispute() {
        pegaDriver.handleWaits().waitForElementVisibility(CSRTIMEFRAMEEXPIRED_LABEL);
        findElement(CONTINUEDISPUTE_RADIO).click();
        findElement(SUBMIT_BUTTON).click();
    }

    @Override
    public void extractClaimId() {
        pegaDriver.handleWaits().waitForElementVisibility(DISPUTEID);
        String disputeidtext = findElement(DISPUTEID).getText();
        extractClaimId(disputeidtext);
    }

    @Override
    public void extractDisputeId() {
        pegaDriver.handleWaits().waitForElementVisibility(DISPUTEID);
        String disputeidtext = findElement(DISPUTEID).getText();
        extractDisputeId(disputeidtext);
    }


}
