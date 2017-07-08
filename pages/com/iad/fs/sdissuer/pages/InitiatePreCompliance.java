/*
 * Copyright (c) 2017. Vamsi Kuppa
 */

package com.iad.fs.sdissuer.pages;

import com.pega.util.LocalizationUtil;
import org.openqa.selenium.By;

import java.util.Map;

/**
 * Created by krisv7 on 4/2/2017.
 */
public interface InitiatePreCompliance extends SDWorkObjectPage {
    //Initiate pre compliance web elements
    By INITIATEPRECOMPLIANCE_HEADER = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Initiate Pre-compliance") + "')]");
    By INTIIATORANDSOURCE_DROPDOWN = By.id("InitiatorAndSource");
    By DISPUTEAMOUNT_TEXT = By.id("DisputeAmount");
    By FOLLOWUPDATE_TEXT = By.id("FollowUpDate");
    //Create pre compliance web elements
    By CREATEPRECOMPLIANCE_HEADER = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Create Pre-compliance") + "')]");
    By PRECOMPLIANCEAMOUNT_TEXT = By.id("PreComplianceAmount");
    By PRIMARYVIOLATION_SELECT = By.xpath("//select[@id='TypeOfViolationSource']");
    By SECONDARYVIOLATION_SELECT = By.xpath("//select[@id='SecondaryViolationSource']");
    By ADDITIONALVIOLATION_SELECT = By.xpath("//select[@id='AdditionalViolationSource']");
    By VIOLATIONDATE_TEXT = By.xpath("//input[@id='DateofViolation']");
    By DISCOVERYDATE_TEXT = By.xpath("//input[@id='DateOfDiscovery']");
    By DISCOVERYDATEREASON_TEXTAREA = By.id("ReasonForDateOfDiscovery");
    By PLANNEDFILINGDATE_TEXT = By.xpath("//input[@id='PlannedFilingDate']");
    By DAYSTORESPOND_TEXT = By.xpath("//input[@id='DaysToRespond']");
    By INITATINGPRECOMPLIANCEREASON_TEXTAREA = By.id("ReasonForInitiatingPreComp");
    By FINANCIALLOSS_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Was there a financial loss?") + "')]");
    By FINANCIALLOSSYESIND_RADIO = By.id("FinancialLossOccurIndY");
    By FINANCIALLOSSEXPLANATION_TEXTAREA = By.id("ExplanationOfFinLoss");
    By AWAITINGPRECOMPLIANCERESPONSE_LINK = By.xpath("//a[contains(text(),'" + LocalizationUtil.getLocalizedWord("Awaiting Pre-compliance response") + "')]");
    By AWAITINGPRECOMPLANCERESPONSE_HEADER = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Awaiting Pre-compliance response") + "')]");
    By PROCESSPRECOMPLIANCERESPONSE_LINK = By.xpath("//a[contains(text(),'" + LocalizationUtil.getLocalizedWord("Process Pre-compliance response") + "')]");
    By ACQUIRERRESPONSE_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Acquirer response") + "')]");
    By ACQUIRERRESPONSE_TEXT = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Acquirer response") + "')]//following::*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]");
    By INITIATECOMPLIANCE_RADIO = By.id("PreCompRespOptionCOMP");
    By ACCEPTANCEAMOUNT_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Acceptance amount") + "')]");
    By AWAITINGPRECOMPLIANCEOTHERACTIONS_LINK = By.xpath("//ul[@role='menu']//following::*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Awaiting Pre-compliance") + "')]");
    By RECALLPRECOMPLIANCE_LINK = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Recall Pre-compliance") + "')]");
    By RECALLREASON_TEXTAREA = By.id("RecallReason");

    void processInitiatePreCompliance(Map<String, String> precompdetails);

    void getPreComplianceResponsePage();

    void processPrecomplianceResponseAcceptFull(Map<String, String> precomprespdetails);

    void processAcceptPartialWOPreComplianceResponse(Map<String, String> precomprespdetails);

    void processAcceptPartialCHLiablePreComplianceResponse(Map<String, String> precomprespdetails);

    void processAcceptPartialCompliance(Map<String, String> precomprespdetails);

    void processDeclinedWOPreComplianceResponse(Map<String, String> precomprespdetails);

    void processDeclinedCHLiablePreComplianceResponse(Map<String, String> precomprespdetails);

    void processRecallPreCompliance();

    InitiateCaseFiling getCompliance();
}
