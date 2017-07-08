package com.iad.fs.sdissuer.pages;

import com.pega.util.LocalizationUtil;
import org.openqa.selenium.By;

import java.util.Map;

public interface VCRDisputeQuestionnaire extends SDWorkObjectPage {

    By DISPUTECATEGORY = By.xpath("//label[text()='%s']/preceding-sibling::input[@type='radio']");
    By DISPUTEREASON = By.xpath("//select[@id='WhatIncorrectAboutTransaction']");
    By BOTHTRANSACTIONONSAMEACCOUNTNUMBERNO_LABEL = By.xpath("//input[@id='BothTransactionsOnSameAcctNumberIndN'][@type='radio'][@value='%s']");
    By MODEOFPAYMENT = By.xpath("//label[text()='%s']/preceding-sibling::input[@type='radio']");
    By CARDSTATUS_DROPDOWN = By.id("CardStatusWhenTransactionHappened");
    By CHAUTHORIZE_RADIO = By.id("CardholderDidNotAuthorizeOrParticipateNo");
    By CHIPCARD_RADIO = By.id("ChipOnCardN");
    By PINPREFCHICARD_RADIO = By.id("PinPreferringCardN");
    By RECALLDISPUTE_LINK = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Process recall Dispute") + "')]");
    By RECALLREASON_TEXTAREA = By.id("RecallReason");
    By RECALLDISPUTE_HEADER = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Process recalled Dispute") + "')]");
    By INITIATEPRECOMPLIANCE_LINK = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Initiate Pre-compliance") + "')]");
    By PROCESSRECALLEDDISPUTE_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Process recalled Dispute") + "')]");
    By INITIATECOLLABORATION_LABEL = By.xpath("//label[contains(text(),'" + LocalizationUtil.getLocalizedWord("Initiate Collaboration") + "')]");
    By GOODFAITH_RADIO = By.xpath("//input[@id='CollaborationTypeGF']");
    By COLLABORATIONAMOUNT_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Collaboration amount") + "')]");
    By GOODFATHREASON_TEXTAREA = By.id("ProvideInResponse");
    By NOTES_TEXTAREA = By.id("Notes");
    By COLLABORATIONREQUEST1_CHECKBOX = By.xpath("//input[@id='CBRepreTimeframeExpiredInd']");
    By AWAITINGGOODFAITH_LINK = By.linkText("Awaiting Good faith response");
    By AWAITINGGOODFAITH_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Awaiting Good Faith response") + "')]");
    By GOODFAITHRESPONSE_TEXT = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Response") + "')]//following::*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]");
    By PROCESSISSUERLIABILITY_LINK = By.partialLinkText("" + LocalizationUtil.getLocalizedWord("Process Issuer liability") + "");


    //Authorization Errors Questionnaire
    By AUTHORIZATIONERROR_RADIO = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]//preceding-sibling::input[@id='VCRDispCategoryAuth']");
    By EXCEPTIONFILELISTING_SELECT = By.id("EFLReg");
    By AUTHORIZATIONOBTAINEDYES_RADIO = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]//preceding-sibling::input[@id='WasAuthObtainedUsingInvalidFallbackDataY']");
    By AUTHORIZATIONONTAINEDNO_RADIO = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]//preceding-sibling::input[@id='WasAuthObtainedUsingInvalidFallbackDataN']");
    By AUTHORIZATIONERRORINVALIDREASON_TEXTAREA = By.id("ExplainWhatWasInvalid");
    By AUTHORIZATIONOBTAINED_SELECT = By.id("ExplanationOfAuthorizationsPresented");
    By MOREDETAILS_TEXTAREA = By.id("OtherExplanation");

    //Fraud Questionnaire
    By FRAUD_RADIO = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]//preceding-sibling::input[@id='VCRDispCategoryFraud']");
    By FRAUDTYPE_SELECT = By.id("FraudTypeVisa");
    By CARDHOLDERAUTHORIZENO_RADIO = By.id("CardholderDidNotAuthorizeOrParticipateNo");
    By CHIPONCARDYES_RADIO = By.id("ChipOnCardY");
    By CHIPONCARDNO_RADIO = By.id("ChipOnCardN");
    By PINPREFERRINGCARDYES_RADIO = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]//preceding-sibling::input[@id='PinPreferringCardY']");
    By PINPREFERRINGCARDNO_RADIO = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]//preceding-sibling::input[@id='PinPreferringCardN']");
    By PINPADPRESENT_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Was a PIN pad present and working") + "')]");
    By PINPADPRESENTYES_RADIO = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]//preceding-sibling::input[@id='PINPadPresentWorkingY']");
    By PINPADPRESENTNO_RADIO = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]//preceding-sibling::input[@id='PINPadPresentWorkingN']");
    By MOREDETAILS2_TEXTAREA = By.xpath("//textarea[@id='OtherExplanation2']");

    //Processing Erros Questionnaire
    By PROCESSINGERRORS_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Processing errors questionnaire") + "')]");
    By PE_RADIO = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]//preceding-sibling::input[@id='VCRDispCategoryProcErr']");
    By INCORRECTABOUTTRANSACTION_DROPDOWN = By.id("WhatIncorrectAboutTransaction");
    By TRANSACTIONAMOUNT_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Transaction amount") + "')]");
    By TRANSACTIONID_TEXT = By.id("DuplicateTranId");
    By ROLTRANSACIONID_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("ROLTransactionID") + "')]");
    By DUPLICATEARN_TEXT = By.id("ARNOrTracingData");
    By DIFFERENTVISACARD_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Is the other account on a different Visa card") + "')]");
    By DIFFERENTVISACARDYES_RADIO = By.id("IssuerOrCardholderOtherAcctWithDiffVisaCardIndY");
    By FIRSTMERCHANTPASSEDONFUNDSNO_RADIO = By.id("IssuerEvidenceMerchantPassedOnFundsIndN");
    By CORRECTCURRENCY_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("What was the correct currency as processed through visanet?") + "')]");
    By CORRECTCURRENCY_AUTOCOMPLETE = By.id("CorrectCurrency");
    By NANO_RADIO = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]//preceding-sibling::input[@type='radio']");
    By CARDHOLDERACCOUNTNUMBER_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Does the account number on the receipt match") + "')]");
    By CARDHOLDERACCOUNTNUMBERNO_RADIO = By.id("ReceiptAccountNumberMatchIndN");
    By ACCOUNTNUMBERONMASTERFILE_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Is the account number on the issuer") + "')]");
    By ACCOUNTNUMBERONMASTERFILEYES_RADIO = By.id("IssuerMasterFileAccountNumberIndY");
    By ACCOUNTNUMBERONRECEIPT_TEXT = By.id("SalesDraftAccountNum");
    By NOSHOWTRANSACTION_TEXT = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Is this a no-show transaction or pre-payment partial transaction") + "')]");
    By NOSHOWTRANSACTIONNO_RADIO = By.id("PrepaymentPartialTransactionIndN");
    By AMOUNTONCARDHOLDERRECEIPT_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("amount on the cardholder") + "')]");
    By AMOUNYONCARDHOLDERRECEIPT_TEXT = By.id("CardholderReceiptAmt");
    By TRANSACTIONINCORRECT_DROPDOWN = By.id("TransactionCodeIncorrect");
    By ACCOUNTSTATUS_DROPDOWN = By.id("AccountStatus");
    By OTHERMODEOFPAYMENT_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Select the other mode of payment") + "')]");
    By CHEQUEPAYMENT_RADIO = By.id("ProvidingPaymentProofOtherMeansC");


    //RFC Details
    By INITIATERFC_LINK = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Initiate Retrieval") + "')]");
    By INITIATERFC_LABEL = By.xpath("//label[contains(text(),'" + LocalizationUtil.getLocalizedWord("Initiate Retrieval Request") + "')]");
    By REQUESTREASONCODE_DROPDOWN = By.id("ReasonRequestForCopy");
    By DOMESTICPROCESSING_CHECKBOX = By.id("DomesticProcessingInd");
    By CONTROLNUMBER_TEXT = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Control number") + "')]");
    By AWAITINGRFCRESPONSE_LABEL = By.xpath("//label[contains(text(),'" + LocalizationUtil.getLocalizedWord("Awaiting RFC response") + "')]");
    By REVIEWRFCRESPONSE_LINK = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Review RFC response") + "')]");
    By REVIEWRFCRESPONSE_LABEL = By.xpath("//label[contains(text(),'" + LocalizationUtil.getLocalizedWord("Review RFC response") + "')]");


    //Submit Fraud Report Details
    By SUBMITFRAUDREPORT_LINK = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Submit Fraud Report") + "')]");
    By SUBMITFRAUDREPORT_LABEL = By.xpath("//label[contains(text(),'" + LocalizationUtil.getLocalizedWord("Submit Fraud Report") + "')]");
    By EDITFRAUDREPORT_LINK = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Edit Fraud Report") + "')]");
    By EDITFRAUDREPORT_LABEL = By.xpath("//label[contains(text(),'" + LocalizationUtil.getLocalizedWord("Edit Fraud Report") + "')]");
    By FRAUDREPORTMODIFY_RADIO = By.id("FraudReportEditActionModify");
    By FRAUDREPORTDELETE_RADIO = By.id("FraudReportEditActionDelete");
    By CLOSEFRAUDCASE_CHECKBOX = By.id("CloseFraudCaseInd");


    void validatePaidByOtherMeansQuestionnaire(Map<String, String> map);

    void validateFraudQuestionnaire(Map<String, String> map);

    void validateDuplicatesQuestionnaire(Map<String, String> map);

    ProcessIssuerLiability getProcessIssuerLiability();

    ProcessAcquirerResponse getProcessAcquirerResponse();

    ProcessPreArbResponse getProcessPreArbResponse();

    InitiatePreCompliance getInitiatePreCompliance();

    CollaborationRequest getCollaborationRequestScreen();

    void processAcquirerResponse();

    void processCHLiableRecallDispute();

    void processWORecallDispute();

    void processAEQuestionnaire(Map<String, String> disputedetails);

    void processFraudQuestionnaire(Map<String, String> disputedetails);

    VCRDisputeQuestionnaire processInitiateRFC(Map<String, String> rfcdetails);

    void processRFCResponse(Map<String, String> rfcdetails);

    void processSubmitFraudReport();

    void processEditFraudReport(Map<String, String> frauddetails);

    void processSubmitFraudReportCloseDispute();

    void processPEDuplicateOrPaidByOtherMeansQuestionnaire(Map<String, String> disputedetails);

    void processPEIncorrectCurrencyQuestionnaire(Map<String, String> disputedetails);

    void processPEIncorrectAccountNumberQuestionnaire(Map<String, String> disputedetails);

    void processPEIncorrectAmountQuestionnaire(Map<String, String> disputedetails);

    void processPEIncorrectTransCodeQuestionnaire(Map<String, String> disputedetails);

    void processPELatePresentmentQuesitonniare(Map<String, String> disputedetails);

    void processCDNRMerchandise(Map<String, String> disputedetails);

}
