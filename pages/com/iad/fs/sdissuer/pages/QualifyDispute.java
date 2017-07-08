package com.iad.fs.sdissuer.pages;

import com.pega.util.LocalizationUtil;
import org.openqa.selenium.By;

import java.util.Map;

/**
 * This Interface is about Qualify Dispute page and its web elements and on this page consists of various dispute-
 * categories each will have the respective methods that can process the further questionnaire displayed
 *
 * @author Vamsi Kuppa
 * @since 02 Feb 2017
 */
public interface QualifyDispute extends SDWorkObjectPage {

    By DISPUTEREASONDROPDOWN = By.id("ManualDisputeReasons");
    By PAYMENTMETHOD = By.id("PaymentMethodDesc");
    By BOTHTRANSONSAMEACCOUNTNUMBERNO_RADIO = By.xpath("//input[@id='BothTransactionsOnSameAcctNumberIndN']");
    By BOTHTRANSACTIONSONSAMEACCOUNTYES_RADIO = By.xpath("//input[@id='BothTransactionsOnSameAcctNumberIndY']");
    By PROOFOFPAYMENTLABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Do you have proof of payment?") + "')]");
    By PROOFOFPAYMENTYESIND = By.id("CardMemProvidedProofOfPaymntTrue");
    By TRANSACTIONID_TEXT = By.id("DuplicateTranId");
    By TRANSACTIONDATE_TEXT = By.id("DuplicateTranDate");
    By VISACARDANOTHERACCOUNT_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Is the other account on a different Visa card owned by the same issuer/cardholder?") + "')]");
    By VISACARDANOTHERACCOUNT_RADIO = By.id("IssuerOrCardholderOtherAcctWithDiffVisaCardIndN");
    By PREPAYMENTBALANCE_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Was this a pre-payment transaction and balance was not paid?") + "')]");
    By PREPAYMENTBALANCEYESIND_RADIO = By.id("PrepaymentBalanceNotPaidIndY");
    By DUPLICATETRANSACTIONID_TEXT = By.id("DuplicateTranId");
    By DUPLICATETRANSACTION_DATE = By.id("DuplicateTranDate");

    VCRDisputeQuestionnaire processPaidByOtherMeansReason(Map<String, String> disputedetails);

    void processCSRQualifyDisputeforPaidByOtherMeans(Map<String, String> disputedetails);

    void processCSRQualifyDisputeforDuplicate(Map<String, String> disputedetails);

    VCRDisputeQuestionnaire processAnotherIssueReason(Map<String, String> disputedetails);

}
