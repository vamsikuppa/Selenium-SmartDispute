/*
 * Copyright (c) 2017. Vamsi Kuppa
 */

package com.iad.fs.sdissuer.pages;

import com.pega.util.LocalizationUtil;
import org.openqa.selenium.By;

import java.util.Map;

/**
 * Created by krisv7 on 4/10/2017.
 */
public interface CollaborationRequest extends SDWorkObjectPage {


    By INITIATECOLLABORATION_LABEL = By.xpath("//label[contains(text(),'" + LocalizationUtil.getLocalizedWord("Initiate Collaboration") + "')]");
    By GOODFAITH_RADIO = By.xpath("//input[@id='CollaborationTypeGF']");
    By COLLABORATIONAMOUNT_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Collaboration amount") + "')]");
    By GOODFATHREASON_TEXTAREA = By.id("ProvideInResponse");
    By NOTES_TEXTAREA = By.id("Notes");
    By COLLABORATIONREQUEST1_CHECKBOX = By.xpath("//input[@id='CBRepreTimeframeExpiredInd']");
    By AWAITINGGOODFAITH_LINK = By.linkText("Awaiting Good faith response");
    By AWAITINGGOODFAITH_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Awaiting Good Faith response") + "')]");
    By GOODFAITHRESPONSE_TEXT = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Response") + "')]//following::*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]");
    //By CONTINUEDISPUTE_RADIO = By.id("DisputeResolutionOptionsCD");
    By NMIYES_RADIO = By.id("CollabInqContinueY");
    By RESOLVEDGOODFAITHSTATUS_LABEL = By.xpath("//*[contains(text(),'Resolved-GoodFaith')]");

    void processInitiateGoodFaith();

    void processGoodFaithResponse();

    void processAcceptFullGoodFaithResponse(Map<String, String> goodfaithdetails);

    void processDeclinedCHLiableGoodFaithResponse(Map<String, String> goodfaithdetails);

    void processDeclinedWOGoodFaithResponse(Map<String, String> goodfaithdetails);

    void processDeclinedResumeDisputeGoodFaithResponseCHLiable(Map<String, String> goodfaithdetails);

    void processDeclinedResumeDisputeGoodFaithResponseWO(Map<String, String> goodfaithdetails);

    void processNMIGoodFaithResponse(Map<String, String> goodfaithdetails);

    void validateTimeFrameExpiryGoodFaithWO();

    void validateTimeFrameExpiryGoodFaithCHLiable();
}
