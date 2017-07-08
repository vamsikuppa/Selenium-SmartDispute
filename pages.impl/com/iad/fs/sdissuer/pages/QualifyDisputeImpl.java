package com.iad.fs.sdissuer.pages;

import com.pega.iad.utils.DataTableUtils;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class QualifyDisputeImpl extends SDWorkObjectPageImpl implements QualifyDispute {

    public QualifyDisputeImpl(WebElement elmt, String elmtId) {
        super(elmt, elmtId);
        // TODO Auto-generated constructor stub
    }

    /**
     * This method is for processing paid by other means dispute reason for backend qualify dispute page
     *
     * @param disputedetails
     * @return VCRDisputeQuestionnaire Page
     */
    @Override
    public VCRDisputeQuestionnaire processPaidByOtherMeansReason(Map<String, String> disputedetails) {
        // TODO Auto-generated method stub

        pegaDriver.handleWaits().waitForElementVisibility(DISPUTEQUESTIONNAIREHEADER);
        pegaDriver.findSelectBox(DISPUTEREASONDROPDOWN).selectByVisibleText(DataTableUtils.getDataTableValue(disputedetails, "Dispute Reason"));
        pegaDriver.handleWaits().waitForElementVisibility(PAYMENTMETHOD);
        pegaDriver.findSelectBox(PAYMENTMETHOD).selectByVisibleText(DataTableUtils.getDataTableValue(disputedetails, "Payment method"));
        pegaDriver.handleWaits().waitForElementVisibility(PROOFOFPAYMENTLABEL);
        findElement(PROOFOFPAYMENTYESIND).click();
        findElement(BOTHTRANSONSAMEACCOUNTNUMBERNO_RADIO).click();
        findElement(CARDHOLDERATRYES_RADIO).click();
        pegaDriver.handleWaits().waitForElementVisibility(ATRCONTACTDATE);
        getYesterdaysDate("Date of contact", "ATRContactDate");
        pegaDriver.findSelectBox(ATRCONTACTMETHOD).selectByVisibleText(DataTableUtils.getDataTableValue(disputedetails, "Contact Method"));
        findElement(ATRCONTACTNAME).click();
        findElement(ATRCONTACTNAME).sendKeys(DataTableUtils.getDataTableValue(disputedetails, "Contact Name"));
        findElement(ATRMERCHANTRESPONSE).click();
        findElement(ATRMERCHANTRESPONSE).sendKeys(DataTableUtils.getDataTableValue(disputedetails, "Merchant Response"));
        findElement(SUBMIT_BUTTON).click();
        wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
        VCRDisputeQuestionnaire stage = new VCRDisputeQuestionnaireImpl(wizard, wizard.getId());
        stage._setEnvironment(testEnv, wizard.getId());
        return stage;

    }

    @Override
    public VCRDisputeQuestionnaire processAnotherIssueReason(Map<String, String> disputedetails) {
        pegaDriver.handleWaits().waitForElementVisibility(DISPUTEQUESTIONNAIREHEADER);
        pegaDriver.findSelectBox(DISPUTEREASONDROPDOWN).selectByVisibleText(DataTableUtils.getDataTableValue(disputedetails, "Dispute Reason"));
        findElement(CARDHOLDERATRYES_RADIO).click();
        getYesterdaysDate("Date of contact", "ATRContactDate");
        findSelectBox(ATRCONTACTMETHOD).selectByVisibleText("Telephone");
        findElement(ATRCONTACTNAME).sendKeys("John");
        findElement(ATRMERCHANTRESPONSE).sendKeys("Not helpful");
        findElement(SUBMIT_BUTTON).click();
        wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
        VCRDisputeQuestionnaire stage = new VCRDisputeQuestionnaireImpl(wizard, wizard.getId());
        stage._setEnvironment(testEnv, wizard.getId());
        return stage;
    }

    /**
     * This method is for processing CSR qualify dispute for paid by other means reason
     *
     * @param disputedetails
     */
    @Override
    public void processCSRQualifyDisputeforPaidByOtherMeans(Map<String, String> disputedetails) {
        // TODO Auto-generated method stub
        pegaDriver.handleWaits().waitForElementVisibility(CSR_QUALIFYDISPUTEHEADER_LABEL);
        pegaDriver.findSelectBox(DISPUTEREASONDROPDOWN).selectByVisibleText(DataTableUtils.getDataTableValue(disputedetails, "Dispute Reason"));
        findElement(CARDHOLDERATRYES_RADIO).click();
        pegaDriver.handleWaits().waitForElementVisibility(ATRCONTACTDATE);
        getYesterdaysDate("Date of contact", "ATRContactDate");
        pegaDriver.findSelectBox(ATRCONTACTMETHOD).selectByVisibleText(DataTableUtils.getDataTableValue(disputedetails, "Contact Method"));
        findElement(ATRCONTACTNAME).click();
        findElement(ATRCONTACTNAME).sendKeys(DataTableUtils.getDataTableValue(disputedetails, "Contact Name"));
        findElement(ATRMERCHANTRESPONSE).click();
        findElement(ATRMERCHANTRESPONSE).sendKeys(DataTableUtils.getDataTableValue(disputedetails, "Merchant Response"));
        pegaDriver.findSelectBox(PAYMENTMETHOD).selectByVisibleText(DataTableUtils.getDataTableValue(disputedetails, "Payment method"));
        pegaDriver.handleWaits().waitForElementVisibility(PROOFOFPAYMENTLABEL);
        findElement(PROOFOFPAYMENTYESIND).click();
        if (verifyElement(BOTHTRANSACTIONSSAMEACCTNUMBER_LABEL)) {
            findElement(BOTHTRANSACTIONSONSAMEACCOUNTYES_RADIO).click();
            findElement(ACQUIRERREFERENCENUMBER_TEXT).sendKeys(DataTableUtils.getDataTableValue(disputedetails, "Acquirer reference number"));
            findElement(TRANSACTIONID_TEXT).sendKeys(DataTableUtils.getDataTableValue(disputedetails, "Transaction Id"));
            findElement(TRANSACTIONDATE_TEXT).click();
            getYesterdaysDate("Transaction date", "DuplicateTranDate");
        }
        if (verifyElement(VISACARDANOTHERACCOUNT_LABEL)) {
            findElement(VISACARDANOTHERACCOUNT_RADIO).click();
            if (verifyElement(PREPAYMENTBALANCE_LABEL)) {
                findElement(PREPAYMENTBALANCEYESIND_RADIO).click();
            }
        }
        findElement(SUBMIT_BUTTON).click();
        pegaDriver.handleWaits().waitForElementVisibility(DISPUTEID);
        String disputeidtext = findElement(DISPUTEID).getText();
        extractDisputeId(disputeidtext);
    }

    @Override
    public void processCSRQualifyDisputeforDuplicate(Map<String, String> disputedetails) {
        pegaDriver.handleWaits().waitForElementVisibility(CSR_QUALIFYDISPUTEHEADER_LABEL);
        pegaDriver.findSelectBox(DISPUTEREASONDROPDOWN).selectByVisibleText(DataTableUtils.getDataTableValue(disputedetails, "Dispute Reason"));
        findElement(CARDHOLDERATRYES_RADIO).click();
        pegaDriver.handleWaits().waitForElementVisibility(ATRCONTACTDATE);
        getYesterdaysDate("Date of contact", "ATRContactDate");
        pegaDriver.findSelectBox(ATRCONTACTMETHOD).selectByVisibleText(DataTableUtils.getDataTableValue(disputedetails, "Contact Method"));
        findElement(ATRCONTACTNAME).click();
        findElement(ATRCONTACTNAME).sendKeys(DataTableUtils.getDataTableValue(disputedetails, "Contact Name"));
        findElement(ATRMERCHANTRESPONSE).click();
        findElement(ATRMERCHANTRESPONSE).sendKeys(DataTableUtils.getDataTableValue(disputedetails, "Merchant Response"));
        findElement(BOTHTRANSACTIONSONSAMEACCOUNTYES_RADIO).click();
        findElement(ACQUIRERREFERENCENUMBER_TEXT).sendKeys(DataTableUtils.getDataTableValue(disputedetails, "Acquirer reference number of the first transaction"));
        findElement(DUPLICATETRANSACTIONID_TEXT).sendKeys(DataTableUtils.getDataTableValue(disputedetails, "Transaction ID"));
        getYesterdaysDate("Transaction date", "DuplicateTranDate");
        findElement(SUBMIT_BUTTON).click();
        pegaDriver.handleWaits().waitForElementVisibility(DISPUTEID);
        String disputeidtext = findElement(DISPUTEID).getText();
        extractDisputeId(disputeidtext);
    }


}
