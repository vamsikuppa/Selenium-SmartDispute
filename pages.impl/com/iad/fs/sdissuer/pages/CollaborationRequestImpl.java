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
 * Created by krisv7 on 4/10/2017.
 */
public class CollaborationRequestImpl extends SDWorkObjectPageImpl implements CollaborationRequest {
    public CollaborationRequestImpl(WebElement elmt, String elmtId) {
        super(elmt, elmtId);
    }

    @Override
    public void processGoodFaithResponse() {
        pegaDriver.handleWaits().waitForElementVisibility(AWAITINGGOODFAITH_LINK);
        findElement(AWAITINGGOODFAITH_LINK).click();
        pegaDriver.handleWaits().waitForElementVisibility(AWAITINGGOODFAITH_LABEL);
        findElement(SUBMIT_BUTTON).click();
    }

    @Override
    public void processAcceptFullGoodFaithResponse(Map<String, String> goodfaithdetails) {
        processGoodFaithResponse();
        boolean acquirerrespdisplayed = verifyElement(IADUtils.parameterizeBy(GOODFAITHRESPONSE_TEXT, DataTableUtils.getDataTableValue(goodfaithdetails, "Acquirer response")));
        Assert.assertEquals(acquirerrespdisplayed, true);
        findElement(SUBMIT_BUTTON).click();
    }

    @Override
    public void processDeclinedCHLiableGoodFaithResponse(Map<String, String> goodfaithdetails) {
        processGoodFaithResponse();
        boolean acquirerrespdisplayed = verifyElement(IADUtils.parameterizeBy(GOODFAITHRESPONSE_TEXT, DataTableUtils.getDataTableValue(goodfaithdetails, "Acquirer response")));
        Assert.assertEquals(acquirerrespdisplayed, true);
        findElement(CARDHOLDERLIABLE_RADIO).click();
        findElement(SUBMIT_BUTTON).click();
    }

    @Override
    public void processDeclinedWOGoodFaithResponse(Map<String, String> goodfaithdetails) {
        processGoodFaithResponse();
        boolean acquirerrespdisplayed = verifyElement(IADUtils.parameterizeBy(GOODFAITHRESPONSE_TEXT, DataTableUtils.getDataTableValue(goodfaithdetails, "Acquirer response")));
        Assert.assertEquals(acquirerrespdisplayed, true);
        findElement(WRITEOFF_RADIO).click();
        findElement(SUBMIT_BUTTON).click();
    }

    @Override
    public void processDeclinedResumeDisputeGoodFaithResponseCHLiable(Map<String, String> goodfaithdetails) {
        processGoodFaithResponse();
        boolean acquirerrespdisplayed = verifyElement(IADUtils.parameterizeBy(GOODFAITHRESPONSE_TEXT, DataTableUtils.getDataTableValue(goodfaithdetails, "Acquirer response")));
        Assert.assertEquals(acquirerrespdisplayed, true);
        findElement(CONTINUEDISPUTE_RADIO).click();
        findElement(SUBMIT_BUTTON).click();
        processAwaitingAcquirerResponseAssignment();
        if (verifyElement(PROCESSACQUIRERRESPONSE_LINK)) {
            findElement(PROCESSACQUIRERRESPONSE_LINK).click();
        }
        Assert.assertTrue(verifyElement(SDWorkObjectPage.PROCESSACQUIRERRESPONSE_LABEL));
        takeChLiableAction();
    }

    @Override
    public void processDeclinedResumeDisputeGoodFaithResponseWO(Map<String, String> goodfaithdetails) {
        processGoodFaithResponse();
        boolean acquirerrespdisplayed = verifyElement(IADUtils.parameterizeBy(GOODFAITHRESPONSE_TEXT, DataTableUtils.getDataTableValue(goodfaithdetails, "Acquirer response")));
        Assert.assertEquals(acquirerrespdisplayed, true);
        findElement(CONTINUEDISPUTE_RADIO).click();
        findElement(SUBMIT_BUTTON).click();
        processAwaitingAcquirerResponseAssignment();
        if (verifyElement(PROCESSACQUIRERRESPONSE_LINK)) {
            findElement(PROCESSACQUIRERRESPONSE_LINK).click();
        }
        Assert.assertTrue(verifyElement(SDWorkObjectPage.PROCESSACQUIRERRESPONSE_LABEL));
        takeWriteOffAction();
    }

    @Override
    public void processNMIGoodFaithResponse(Map<String, String> goodfaithdetails) {
        boolean acquirerrespdisplayed = verifyElement(IADUtils.parameterizeBy(GOODFAITHRESPONSE_TEXT, DataTableUtils.getDataTableValue(goodfaithdetails, "Acquirer response")));
        Assert.assertEquals(acquirerrespdisplayed, true);
        findElement(NMIYES_RADIO).click();
        findElement(SUBMIT_BUTTON).click();
        //Processing the initiate good faith
        findElement(SUBMIT_BUTTON).click();
    }

    @Override
    public void validateTimeFrameExpiryGoodFaithWO() {
        findElement(VCRTABLINK).click();
        Assert.assertTrue(verifyElement(GOODFAITHATTEMPT_HEADER));
        Assert.assertTrue(verifyElement(GOODFAITHRESPONSE_HEADER));
        findElement(OVERVIEWTABLINK).click();
        Assert.assertTrue(verifyElement(RESOLVEDGOODFAITHSTATUS_LABEL));
        assertCompareIgnoreCaseStrings(findElement(ATTACHMENTS_SECTION).getText(), "Final credit letter");
    }

    @Override
    public void validateTimeFrameExpiryGoodFaithCHLiable() {
        findElement(VCRTABLINK).click();
        Assert.assertTrue(verifyElement(GOODFAITHATTEMPT_HEADER));
        Assert.assertTrue(verifyElement(GOODFAITHRESPONSE_HEADER));
        findElement(OVERVIEWTABLINK).click();
        Assert.assertTrue(verifyElement(RESOLVEDCARDHOLDERLIABLE_LABEL));
        assertCompareIgnoreCaseStrings(findElement(ATTACHMENTS_SECTION).getText(), "Cardholder liable letter");
    }


    @Override
    public void processInitiateGoodFaith() {
        pegaDriver.handleWaits().waitForElementVisibility(INITIATECOLLABORATION_LABEL);
        findElement(GOODFAITH_RADIO).click();
        getFutureDate("Last day to respond", "LastDayToRespond", 5);
        Assert.assertTrue(verifyElement(COLLABORATIONAMOUNT_LABEL));
        findElement(COLLABORATIONREQUEST1_CHECKBOX).click();
        findElement(GOODFATHREASON_TEXTAREA).sendKeys("test");
        findElement(NOTES_TEXTAREA).sendKeys("test");
        findElement(SUBMIT_BUTTON).click();

    }
}
