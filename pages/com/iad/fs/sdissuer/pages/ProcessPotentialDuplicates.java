package com.iad.fs.sdissuer.pages;

import com.pega.util.LocalizationUtil;
import org.openqa.selenium.By;

/**
 * This Interface is about Process potential duplicates page and its web elements and on processing this page it navigates to
 * either Qualify Dispute page or VCR Dispute Questionnaire page in case of CSR Flows
 *
 * @author Vamsi Kuppa
 * @since 02 Feb 2017
 */
public interface ProcessPotentialDuplicates extends SDWorkObjectPage {

    By PROCESSPOTENTIALDUPLICATESASSIGNMENT = By.linkText("Process potential duplicates");
    By PROCESSPOTENTIALDUPLICATESHEADER = By.xpath("//*[contains(text(),'Process potential duplicates')]");
    By DUPLICATESCOMMENTSTEXTAREA = By.id("DuplicateProcessingComments");
    By CSR_PRIORDISPUTELABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("This transaction is involved in a prior dispute. Do you want to continue?") + "')]");
    By CSR_PRIORDISPUTERADIO = By.xpath("//input[@id='IncludeTransactionTrue'][@type='radio']");
    By CSR_NEXTBUTTON = By.xpath("//button[contains(text(),'" + LocalizationUtil.getLocalizedWord("Next") + "')]");
    By TIMEFRAMEEXPIRY_LINK = By.partialLinkText("" + LocalizationUtil.getLocalizedWord("Time frame expiry") + "");

    QualifyDispute processDuplicatesAssignment();

    void processCSRDuplicatesAssignment();

    QualifyDispute getQualifyDispute();

    void processBackendDuplicatesAssignment();

    ProcessIssuerLiability getTimeFrameExpiry();

    VCRDisputeQuestionnaire getVCRDisputeQuestionnaire();

    QualifyFraud getQualifyFraud();
}
