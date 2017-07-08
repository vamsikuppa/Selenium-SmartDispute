package com.iad.fs.sdissuer.pages;

import com.pega.iad.page.IADWorkObjectPage;
import com.pega.util.LocalizationUtil;
import org.openqa.selenium.By;

import java.util.Map;


public interface SDWorkObjectPage extends IADWorkObjectPage {

    By CANCEL_BUTTON = By.xpath("//*[@id='HARNESS_CONTENT']//following::*[text()='" + LocalizationUtil.getLocalizedWord("Cancel") + "']");
    By PROCESSPOTENTIALDUPLICATESASSIGNMENTLINK = By.linkText("" + LocalizationUtil.getLocalizedWord("Process potential duplicates") + "");
    By QUALIFYDISPUTEASSIGNMENTLINK = By.linkText("" + LocalizationUtil.getLocalizedWord("Qualify Dispute") + "");
    By VCRDISPUTEQUESTIONNAIRE_LINK = By.linkText("" + LocalizationUtil.getLocalizedWord("Dispute questionnaire") + "");
    By CSR_PROCESSDUPLICATESHEADER = By.xpath("//label[contains(text(),'" + LocalizationUtil.getLocalizedWord("Process duplicates") + "')]");
    By CSR_QUALIFYDISPUTEHEADER_LABEL = By.xpath("//label[contains(text(),'" + LocalizationUtil.getLocalizedWord("Qualify Dispute") + "')]");
    By CSR_QUALIFYFRAUDHEADER_LABEL = By.xpath("//label[contains(text(),'" + LocalizationUtil.getLocalizedWord("Qualify fraud") + "')]");
    By DISPUTEQUESTIONNAIREHEADER = By.xpath("//label[contains(text(),'" + LocalizationUtil.getLocalizedWord("Dispute Questionnaire") + "')]");
    By ASSOCIATEDTRANSACTIONSHEADER = By.xpath("//label[contains(text(),'" + LocalizationUtil.getLocalizedWord("Process associated transactions") + "')]");
    By CARDHOLDERATRYES_RADIO = By.id("ATRIndTrue");
    By ATRCONTACTDATE = By.id("ATRContactDate");
    By DATEPICKER_IMG = By.xpath("//img[@class='inactvIcon']");
    By ATRCONTACTMETHOD = By.id("ATRContactMethod");
    By ATRCONTACTNAME = By.id("ATRContactName");
    By ATRMERCHANTRESPONSE = By.id("ATRMerchantResponse");
    By COMMENTS = By.id("Comments");
    By NOTE_TEXTAREA = By.id("Note");
    By AWAITINGACQUIRERRESPONSEASSIGNMENT_LINK = By.linkText("" + LocalizationUtil.getLocalizedWord("Awaiting Acquirer response") + "");
    By AWAITINGPREARBRESPONSE_LINK = By.linkText("" + LocalizationUtil.getLocalizedWord("Awaiting Pre-arbitration response") + "");
    By AWAITINGASSOCIATIONACKNOWLEDGEMENT_LINK = By.linkText("" + LocalizationUtil.getLocalizedWord("Awaiting Association Acknowledgement") + "");
    By INITIATECASEFILING_LINK = By.linkText("" + LocalizationUtil.getLocalizedWord("Initiate Case Filing") + "");
    By ASSOCIATIONRULING_LINK = By.linkText("" + LocalizationUtil.getLocalizedWord("Process Association ruling") + "");


    //interview tab details
    By SUGGESTEDDISPUTECATEGORYLABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Suggested dispute category") + "')]//following::*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]");
    By SELECTEDDISPUTEREASONLABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Selected dispute reason") + "')]//following::*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]");
    By ATRMERCHANTLABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Did you attempt to resolve with the merchant?") + "')]//following::*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]");
    By ATRCONTACTMETHODLABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Contact method") + "')]//following::*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]");
    By ATRCONTACTNAMELABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Contact name") + "')]//following::*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]");
    By ATRMERCHANTRESPONSELABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Merchant response") + "')]//following::*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]");
    By PAYMENTMETHODLABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Payment method") + "')]//following::*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]");
    By PAYMENTPROOFINDLABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Do you have proof of payment?") + "')]//following::*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]");
    By BOTHTRANSACTIONSSAMEACCTIND = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Are both transactions on the same account number") + "')]//following::*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]");
    By ACQREFFIRSTTRANSIND_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Acquirer reference number of the first transaction") + "')]//following::*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]");
    By TRANSID_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Transaction ID") + "')]//following::*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]");
    By ACQUIRERREFERENCENUMBER_TEXT = By.xpath("//input[@id='ARN' or @id='ARNOrTracingData']");
    By PROCESSACQUIRERRESPONSE_LINK = By.partialLinkText("" + LocalizationUtil.getLocalizedWord("Process Acquirer response") + "");
    By PROCESSACQUIRERRESPONSE_LABEL = By.xpath("//label[contains(text(),'" + LocalizationUtil.getLocalizedWord("Process Acquirer response") + "')]");
    By PREARBRESPONSEFROMACQUIRER_LABEL = By.xpath("//label[contains(text(),'" + LocalizationUtil.getLocalizedWord("Process Pre-arbitration response from Acquirer") + "')]");
    By PROCESSPREARBRESP_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Process Pre-arbitration response") + "')]");
    By PREARBDETAILS_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Pre-arbitration details") + "')]");
    By PROCESSASSOCIATEDTXN_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Process associated transactions") + "')]");
    By ASSOCIATEDTXN_TEXTAREA = By.id("ExplanationOfCreditPresented");
    By PROCESSPREARBLIABILITY_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Process Pre-arbitration liability") + "')]");
    By BOTHTRANSACTIONSSAMEACCTNUMBER_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Are both transactions on the same account number?") + "')]");

    //Common questionnaire
    By BOTHTRANACTIONSONSAMEACCOUNTNUMBERYES_RADIO = By.id("BothTransactionsOnSameAcctNumberIndY");
    By BOTHTRANSACTIONSONSAMEACCOUNTNUMBERNO_RADIO = By.id("BothTransactionsOnSameAcctNumberIndN");


    // Pre-Arbitration page Element identifications
    By PREARBRESPONSE_TEXTAREA = By.id("PreArbResponseNote");
    By PREARBACCEPTANCEAMOUNT_TEXTINPUT = By.id("PreArbAcceptanceAmount");
    By NEWINFO_RADIO = By.id("ProvidingNewInfoIndN");
    By PREARBNOTACCEPTINGFULLLREASON = By.id("PreArbRespLiabilityNotAcceptedFully");
    By CHCONTACTCE_RADIO = By.id("IssuerCertifiesCardholderCompEvidenceY");
    By CHWANSTOCONTINUE_TEXTAREA = By.id("CardholderContinuesDispute");
    By PROCESSPREARBRESPONSE_LINK = By.partialLinkText("" + LocalizationUtil.getLocalizedWord("Process Pre-arbitration response") + "");
    By PREARBPENDCLOSURE_LINK = By.partialLinkText("" + LocalizationUtil.getLocalizedWord("Pre-arbitration - pending-closure") + "");

    // Response element identifications
    By ACCEPTFULLY_RADIO = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Accept fully") + "')]/preceding-sibling::input[@type='radio']");
    By ACCEPTPARTIALLY_RADIO = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Accept partially") + "')]/preceding-sibling::input[@type='radio']");
    By DECLINED_RADIO = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Decline") + "')]/preceding-sibling::input[@type='radio']");

    // Tab element identifications
    By INTERVIEWTABLINK = By.xpath("//*[text()='Interview']");
    By ACCOUNTING_TAB = By.xpath("//*[@role='tab']//*[text()='" + LocalizationUtil.getLocalizedWord("Accounting") + "']");
    By VCRTABLINK = By.xpath("//*[text()='VCR']");
    By ACCOUTINGTABLINK = By.xpath("//*[text()='Accounting']");
    By RETRIEVALREQUEST_TAB = By.xpath("//div[@role='tab']//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Retrieval Request") + "')]");


    // Status element identifications
    By CASESTATUS = By.xpath("//label[text()='Status']//following::*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]");
    By WRITEOFF_STATUS = By.xpath("//*[text()='" + LocalizationUtil.getLocalizedWord("Status") + "']//following::*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Resolved-WriteOff") + "')]");
    By CHLIABLE_STATUS = By.xpath("//*[text()='" + LocalizationUtil.getLocalizedWord("Status") + "']//following::*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Resolved-CardholderLiable") + "')]");
    By PENDCLOSURE_STATUS = By.xpath("//*[text()='" + LocalizationUtil.getLocalizedWord("Status") + "']//following::*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Pending-Closure") + "')]");

    //VCR tab section details
    By PREARBDETAILSSECTION_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Pre-arbitration details") + "')]");
    By PREARBRESPONSESECTION_LABEL = By.xpath("//*[text()='" + LocalizationUtil.getLocalizedWord("Pre-arbitration response") + "']");
    By DISPUTEDETAILS_HEADING = By.xpath("//*[text()='" + LocalizationUtil.getLocalizedWord("Dispute details") + "']");
    By DISPUTERESPONSE_HEADING = By.xpath("//*[text()='" + LocalizationUtil.getLocalizedWord("Dispute response") + "']");
    By PREARBDETAILS_HEADING = By.xpath("//*[text()='" + LocalizationUtil.getLocalizedWord("Pre-arbitration details") + "']");
    By PREARBRESPONSEDETAILS_HEADING = By.xpath("//*[text()='" + LocalizationUtil.getLocalizedWord("Pre-arbitration response") + "']");
    By ARBITRATIONDETAILS_HEADING = By.xpath("//*[text()='" + LocalizationUtil.getLocalizedWord("Arbitration details") + "']");
    By PRECOMPDETAILS_HEADING = By.xpath("//*[text()='" + LocalizationUtil.getLocalizedWord("Pre-compliance details") + "']");
    By PRECOMPRESPDETAILS_HEADING = By.xpath("//*[text()='" + LocalizationUtil.getLocalizedWord("Pre-compliance response details") + "']");
    By COMPLIANCEDETAILS_HEADER = By.xpath("//*[text()='" + LocalizationUtil.getLocalizedWord("Compliance details") + "']");
    By COMPLIANCERULING_HEADER = By.xpath("//*[text()='" + LocalizationUtil.getLocalizedWord("Compliance ruling") + "']");
    By GOODFAITHATTEMPT_HEADER = By.xpath("//*[text()='" + LocalizationUtil.getLocalizedWord("Good Faith Attempt") + "']");
    By GOODFAITHRESPONSE_HEADER = By.xpath("//*[text()='" + LocalizationUtil.getLocalizedWord("Good Faith Response") + "']");
    By FRAUDREPORTID_TEXT = By.xpath("//*[text()='" + LocalizationUtil.getLocalizedWord("Fraud Report ID") + "']");

    //overview tab details
    By OVERVIEWTABLINK = By.xpath("//*[text()='" + LocalizationUtil.getLocalizedWord("Overview") + "']");
    By FRAUDINDICATORLABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Fraud indicator") + "')]//following::*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]");
    By DISPUTECATEGORYLABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Dispute category") + "')]//following::*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]");


    //write off radio button
    By WRITEOFF_RADIO = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Write-off") + "')]/preceding-sibling::input[@type='radio']");
    //By FINALCREDITLETTER = By.partialLinkText("" + LocalizationUtil.getLocalizedWord("Final credit letter") + "");

    //Attachments section
    By ATTACHMENTS_SECTION = By.xpath("//*[@data-node-id='pyCaseAttachments']//following-sibling::table[@pl_prop='AllAttachments.pxResults']");

    //card holder liable action
    By CARDHOLDERLIABLE_RADIO = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Cardholder liable") + "')]/preceding-sibling::input[@type='radio']");

    //Multi pronged option
    By MULTIPRONGEDOPTIONS_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Multi-pronged options") + "')]");
    By MULTIPRONGED_RADIO = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Multi-pronged") + "')]/preceding-sibling::input[@type='radio']");
    By WRITEOFF_CHECKBOX = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Write-off") + "')]/preceding-sibling::input[@type='checkbox']");
    By CARDHOLDERLIABLE_CHECKBOX = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Cardholder liable") + "')]/preceding-sibling::input[@type='checkbox']");


    //Continue dispute radio
    By CONTINUEDISPUTE_RADIO = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Continue dispute") + "')]/preceding-sibling::input[@type='radio']");

    //Dispute id
    By DISPUTEID = By.xpath("//*[contains(@data-node-id,'ConfirmMessage')]");

    //Other actions
    By ACTIONS_BUTTON = By.xpath("//button[contains(text(),'" + LocalizationUtil.getLocalizedWord("Actions") + "')]");
    By OTHERACTIONS_BUTTON = By.xpath("//button[contains(text(),'" + LocalizationUtil.getLocalizedWord("Other actions") + "')]");

    // Accounting element identifications
    By SUSPENSE_LABEL = By.xpath("//*[text()='" + LocalizationUtil.getLocalizedWord("Suspense details") + "']");
    By SUSPENSECLOSE_LABEL = By.xpath("//*[text()='" + LocalizationUtil.getLocalizedWord("Action") + "']//following::*[text()='" + LocalizationUtil.getLocalizedWord("Close") + "']");
    By SUSPENSEWRITEOFFACCOUNT_LABEL = By.xpath("//*[text()='" + LocalizationUtil.getLocalizedWord("Step") + "']//following::*[contains(text(),'" + LocalizationUtil.getLocalizedWord("WriteOff") + "')]");
    By CHLIABLEACCOUNT_LABEL = By.xpath("//*[text()='" + LocalizationUtil.getLocalizedWord("Step") + "']//following::*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Dr CardHolder Cr Receivable") + "')]");
    By SUSPENSEZERO_LABEL = By.xpath("//*[text()='" + LocalizationUtil.getLocalizedWord("Outstanding balance") + "']//following::*[contains(text(),'" + LocalizationUtil.getLocalizedWord("0.00") + "')]");


    //RFC Response Elements
    By AWAITINGRFCRESPONSEASSIGMENT_LINK = By.partialLinkText("" + LocalizationUtil.getLocalizedWord("Awaiting RFC response") + "");
    By RFCRESPONSE_TEXT = By.xpath("//*[contains(text(),'Response')]//following::*[text()='" + LocalizationUtil.getLocalizedWord("%s") + "']");

    //Process associated transactions
    By PROCESSASSOCIATEDTRANSACTIONS_HEADER = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Process associated transactions") + "')]");
    By ASSOCIATEDTRANSACTIONSNOTVALID_TEXTAREA = By.xpath("//textarea[@id='ExplanationOfCreditPresented']");


    //Backend dispute id
    By BACKENDDISPUTEID_TEXT = By.xpath("//*[@id='RULE_KEY'][@data-node-id='pyCaseHeader']");

    //OK BUTTON
    By OK_BUTTON = By.xpath("//button[@type='button']//following::*[contains(text(),'" + LocalizationUtil.getLocalizedWord("OK") + "')]");

    //Other actions
    By INITIATECOLLABORATOIN_LINK = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Initiate Collaboration") + "')]");

    //Status
    By RESOLVEDCARDHOLDERLIABLE_LABEL = By.xpath("//*[contains(text(),'Resolved-CardholderLiable')]");

    //CSR Time frame expiry page and elements
    By CSRTIMEFRAMEEXPIRED_LABEL = By.xpath("//label[contains(text(),'" + LocalizationUtil.getLocalizedWord("Dispute timeframe expired") + "')]");


    /**
     *
     */

    void processAwaitingAcquirerResponseAssignment();

    /**
     * @param overviewtabdetails
     */
    void validateOverviewTab(Map<String, String> overviewtabdetails);

    /**
     * @param interviewdetails
     */
    void validateInterviewTabPaidByOtherMeans(Map<String, String> interviewdetails);

    /**
     * @param interviewdetails
     */
    void validateInterviewTabChargedMoreThanOnce(Map<String, String> interviewdetails);

    /**
     * @param accountingdetails
     */
    void validateAccountingTab(Map<String, String> accountingdetails);

    /**
     * @param vcrtabdetails
     */
    void validateVCRTab(Map<String, String> vcrtabdetails);

    /**
     *
     */
    void validateGoodFaithResponseVCRTab();

    /**
     * @param vcrtabdetails
     */
    void validateVCRTabDisputeResponse(Map<String, String> vcrtabdetails);

    /**
     * @param vcrtabdetails
     */
    void validateVCRTabPreArbRecall(Map<String, String> vcrtabdetails);

    /**
     * @param vcrtabdetails
     */
    void validateVCRTabDisputeRecall(Map<String, String> vcrtabdetails);

    /**
     * @param vcrtabdetails
     */
    void validateVCRTabPreCompliance(Map<String, String> vcrtabdetails);

    /**
     *
     *
     */
    void validateVCRTabRecallPreCompliance();

    /**
     *
     */
    void validateVCRTabWithDrawArbitration();

    /**
     * @param vcrtabdetails
     */
    void validateVCRTabCompliance(Map<String, String> vcrtabdetails);

    /**
     * @param rfcdetails
     */
    void validateRetrievalRequestTab(Map<String, String> rfcdetails);

    /**
     *
     */
    void validateVCRTabWithdrawCompliance();

    /**
     *
     */
    void validateVCRTabFraudReport(Map<String, String> reportdetails);

    /**
     * This method will compare two strings by ignoring the case and asserts the compare result
     *
     * @param str1
     * @param str2
     */
    void assertCompareIgnoreCaseStrings(String str1, String str2);

    /**
     *
     */
    void takeWriteOffAction();

    /**
     *
     */
    void takeChLiableAction();

    /**
     *
     */
    void takeMultiProngedAction(String option1, String option2);

    /**
     *
     */
    void takeMultiProngedAction(String option1, String option2, String option3);

    /**
     * This method takes the Date field label and the id of the date field and enters the yesterdays date
     *
     * @param datefield
     * @param id
     */
    void getYesterdaysDate(String datefield, String id);

    /**
     * This method takes the date field and the id of the date field and enters the previous date with mentioned noofdays as argument
     *
     * @param datefield
     * @param id
     */
    void getPreviousDate(String datefield, String id, int noofdays);

    /**
     * @param datefield
     * @param id
     * @param noofdays
     */
    void getFutureDate(String datefield, String id, int noofdays);

    /**
     * @param datefield
     * @param id
     * @param date
     * @param month
     * @param year
     */
    void getExactDate(String datefield, String id, int date, int month, int year);

    /**
     *
     */
    void accountingSuspenseDetails();

    /**
     *
     */
    void accountingSuspenseWriteOff();

    /**
     *
     */
    void accountingSuspenseCHLiable();

    /**
     *
     */
    void suspenseZeroCheck();

    /**
     *
     */

    void validatePreArbLabels();

    /**
     *
     */
    void validatePreArbSectionsVcrTab();

    /**
     *
     */
    void processPreArbRespAcceptFully();

    /**
     *
     */
    void processPreArbResponseAcceptfullyWO();

    /**
     *
     */
    void processPreArbResponseAcceptfullyCH();

    /**
     *
     */
    void processPreArbResponseAcceptPartially();

    /**
     *
     */
    void processPreArbRespAcceptPartiallyWO();

    /**
     *
     */
    void processPreArbRespAcceptPartiallyCH();

    /**
     *
     */
    void processPreArbResponseDeclined();
}
