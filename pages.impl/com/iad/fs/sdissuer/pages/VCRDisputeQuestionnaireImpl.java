package com.iad.fs.sdissuer.pages;

import com.pega.iad.utils.DataTableUtils;
import com.pega.iad.utils.IADUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Map;

public class VCRDisputeQuestionnaireImpl extends SDWorkObjectPageImpl implements VCRDisputeQuestionnaire {

    public VCRDisputeQuestionnaireImpl(WebElement elmt, String elmtId) {
        super(elmt, elmtId);
        // TODO Auto-generated constructor stub
    }

    /**
     * This method validates the paid by other means questionnaire in backend vcr dispute questionnaire page
     *
     * @param disputedetails A map that contains dispute details
     */
    @Override
    public void validatePaidByOtherMeansQuestionnaire(Map<String, String> disputedetails) {
        // TODO Auto-generated method stub
        boolean selecteddisputecategory = findElement(IADUtils.parameterizeBy(DISPUTECATEGORY, DataTableUtils.getDataTableValue(disputedetails, "Dispute category"))).isSelected();
        Assert.assertEquals(selecteddisputecategory, true);
        String selecteddisputereason = findSelectBox(DISPUTEREASON).getFirstSelectedOption().getText();
        Assert.assertEquals(selecteddisputereason, DataTableUtils.getDataTableValue(disputedetails, "Dispute Reason"));
        boolean modeofpayment = findElement(IADUtils.parameterizeBy(MODEOFPAYMENT, DataTableUtils.getDataTableValue(disputedetails, "Payment method"))).isSelected();
        Assert.assertEquals(modeofpayment, true);
        if (verifyElement(BOTHTRANSACTIONONSAMEACCOUNTNUMBERNO_LABEL)) {
            boolean bothtransactionssameaccountnumberno = findElement(IADUtils.parameterizeBy(BOTHTRANSACTIONSSAMEACCTIND, DataTableUtils.getDataTableValue(disputedetails, "Are both transactions on same account number"))).isSelected();
            Assert.assertEquals(bothtransactionssameaccountnumberno, true);
            boolean acqnumberdisplayed = findElement(IADUtils.parameterizeBy(ACQREFFIRSTTRANSIND_LABEL, DataTableUtils.getDataTableValue(disputedetails, "Acquirer reference number"))).isDisplayed();
            Assert.assertEquals(acqnumberdisplayed, true);
            boolean traniddisplayed = findElement(IADUtils.parameterizeBy(TRANSID_LABEL, DataTableUtils.getDataTableValue(disputedetails, "Transaction Id"))).isDisplayed();
            Assert.assertEquals(traniddisplayed, true);
        }
        findElement(SUBMIT_BUTTON).click();
    }

    /**
     * @param frauddetails A map that contains Fraud details
     */

    @Override
    public void validateFraudQuestionnaire(Map<String, String> frauddetails) {
        // TODO Auto-generated method stub
        boolean selecteddisputecategory = findElement(IADUtils.parameterizeBy(DISPUTECATEGORY, DataTableUtils.getDataTableValue(frauddetails, "Dispute category"))).isSelected();
        Assert.assertEquals(selecteddisputecategory, true);
        String selectedcardstatus = findSelectBox(CARDSTATUS_DROPDOWN).getFirstSelectedOption().getText();
        Assert.assertEquals(selectedcardstatus, DataTableUtils.getDataTableValue(frauddetails, "Card Status"));
        boolean chauthorizeorparticipate = findElement(IADUtils.parameterizeBy(CHAUTHORIZE_RADIO, DataTableUtils.getDataTableValue(frauddetails, "CH Authorize"))).isSelected();
        Assert.assertEquals(chauthorizeorparticipate, true);
        findSelectBox(FRAUDTYPE_SELECT).selectByVisibleText("Lost");
        findElement(CHIPCARD_RADIO).click();
        findElement(PINPREFCHICARD_RADIO).click();
        findElement(SUBMIT_BUTTON).click();

    }

    /**
     * To validate Duplicate Dispute reason questionnaire
     */

    @Override
    public void validateDuplicatesQuestionnaire(Map<String, String> disputedetails) {
        boolean selecteddisputecategory = findElement(IADUtils.parameterizeBy(DISPUTECATEGORY, DataTableUtils.getDataTableValue(disputedetails, "Dispute category"))).isSelected();
        Assert.assertEquals(selecteddisputecategory, true);
        //findElement(NOTES_TEXTAREA).sendKeys("test");
        /*ScriptExecutorImpl s = new ScriptExecutorImpl(testEnv);
        s.sendKeys(findElement(ACQUIRERREFERENCENUMBER_TEXT), DataTableUtils.getDataTableValue(disputedetails, "Acquirer reference number of the first transaction"),"change");
       s.executeJavaScript("$(arguments[0]).change(); return true;");
        ((JavascriptExecutor)driver).executeScript("$(arguments[0]).change();",driver.findElement(ACQUIRERREFERENCENUMBER_TEXT));
       ((JavascriptExecutor) pegaDriver).executeScript("$(arguments[0]).change();",findElement(ACQUIRERREFERENCENUMBER_TEXT));*/
        findElement(SUBMIT_BUTTON).click();
    }

    /**
     * To return the ProcessIssuerLiablity Page instance
     *
     * @return ProcessIssuerLiability Page Instance
     */

    @Override
    public ProcessIssuerLiability getProcessIssuerLiability() {
        // TODO Auto-generated method stub
        if (verifyElement(PROCESSISSUERLIABILITY_LINK)) {
            findElement(PROCESSISSUERLIABILITY_LINK).click();
        }
        wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
        ProcessIssuerLiability stage = new ProcessIssuerLiabilityImpl(wizard, wizard.getId());
        stage._setEnvironment(testEnv, wizard.getId());
        return stage;
    }

    /**
     * To return the process acquirer response
     *
     * @return ProcessAcquirerResponse Page instance
     */

    @Override
    public ProcessAcquirerResponse getProcessAcquirerResponse() {
        Assert.assertTrue(verifyElement(PROCESSACQUIRERRESPONSE_LINK));
        findElement(PROCESSACQUIRERRESPONSE_LINK).click();
        Assert.assertTrue(verifyElement(PROCESSACQUIRERRESPONSE_LABEL));
        wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
        ProcessAcquirerResponse stage = new ProcessAcquirerResponseImpl(wizard, wizard.getId());
        stage._setEnvironment(testEnv, wizard.getId());
        return stage;
    }

    /**
     *
     * @return ProcessPreArbResponse Page Instance
     */
    @Override
    public ProcessPreArbResponse getProcessPreArbResponse() {
        wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
        ProcessPreArbResponse stage = new ProcessPreArbResponseImpl(wizard, wizard.getId());
        stage._setEnvironment(testEnv, wizard.getId());
        return stage;
    }

    /**
     * @return Initiate Pre Compliance Page
     */
    @Override
    public InitiatePreCompliance getInitiatePreCompliance() {
        findElement(ACTIONS_BUTTON).click();
        pegaDriver.handleWaits().waitForElementVisibility(INITIATEPRECOMPLIANCE_LINK);
        findElement(INITIATEPRECOMPLIANCE_LINK).click();
        wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
        InitiatePreCompliance stage = new InitiatePreComplianceImpl(wizard, wizard.getId());
        stage._setEnvironment(testEnv, wizard.getId());
        return stage;
    }

    @Override
    public void processAcquirerResponse() {
        Assert.assertTrue(verifyElement(SDWorkObjectPage.AWAITINGACQUIRERRESPONSEASSIGNMENT_LINK));
        findElement(SDWorkObjectPage.AWAITINGACQUIRERRESPONSEASSIGNMENT_LINK).click();
        findElement(SUBMIT_BUTTON).click();
    }


    @Override
    public void processCHLiableRecallDispute() {
        findElement(ACTIONS_BUTTON).click();
        pegaDriver.handleWaits().waitForElementVisibility(RECALLDISPUTE_LINK);
        findElement(RECALLDISPUTE_LINK).click();
        pegaDriver.handleWaits().waitForElementVisibility(RECALLDISPUTE_LINK);
        findElement(RECALLREASON_TEXTAREA).sendKeys("Recalling dispute");
        findElement(SUBMIT_BUTTON).click();
        pegaDriver.handleWaits().waitForElementVisibility(RECALLDISPUTE_HEADER);
        takeChLiableAction();
    }

    @Override
    public void processWORecallDispute() {
        findElement(ACTIONS_BUTTON).click();
        pegaDriver.handleWaits().waitForElementVisibility(RECALLDISPUTE_LINK);
        findElement(RECALLDISPUTE_LINK).click();
        pegaDriver.handleWaits().waitForElementVisibility(RECALLDISPUTE_LINK);
        findElement(RECALLREASON_TEXTAREA).sendKeys("Recalling dispute");
        findElement(SUBMIT_BUTTON).click();
        pegaDriver.handleWaits().waitForElementVisibility(RECALLDISPUTE_HEADER);
        takeWriteOffAction();
    }

    @Override
    public void processAEQuestionnaire(Map<String, String> disputedetails) {
        extractBackendDisputeId(findElement(BACKENDDISPUTEID_TEXT).getText());
        findElement(IADUtils.parameterizeBy(AUTHORIZATIONERROR_RADIO, DataTableUtils.getDataTableValue(disputedetails, "Dispute category"))).click();
        getYesterdaysDate("Exception file listing date", "EFLDate");
        findSelectBox(EXCEPTIONFILELISTING_SELECT).selectByVisibleText(DataTableUtils.getDataTableValue(disputedetails, "Exception file listing region"));
        if (DataTableUtils.getDataTableValue(disputedetails, "Authorization obtained").equals("Yes")) {
            findElement(IADUtils.parameterizeBy(AUTHORIZATIONOBTAINEDYES_RADIO, DataTableUtils.getDataTableValue(disputedetails, "Authorization obtained"))).click();
            findElement(AUTHORIZATIONERRORINVALIDREASON_TEXTAREA).sendKeys("test");
        } else {
            findElement(IADUtils.parameterizeBy(AUTHORIZATIONONTAINEDNO_RADIO, DataTableUtils.getDataTableValue(disputedetails, "Authorization obtained"))).click();
            findSelectBox(AUTHORIZATIONOBTAINED_SELECT).selectByVisibleText(DataTableUtils.getDataTableValue(disputedetails, "Authorization applied"));
            if (DataTableUtils.getDataTableValue(disputedetails, "Authorization applied").equals("Other")) {
                findElement(MOREDETAILS_TEXTAREA).sendKeys(DataTableUtils.getDataTableValue(disputedetails, "More Details"));
            }
        }
        findElement(NOTES_TEXTAREA).sendKeys(DataTableUtils.getDataTableValue(disputedetails, "Notes"));
        findElement(SUBMIT_BUTTON).click();
    }

    @Override
    public void processFraudQuestionnaire(Map<String, String> disputedetails) {
        extractBackendDisputeId(findElement(BACKENDDISPUTEID_TEXT).getText());
        findElement(IADUtils.parameterizeBy(FRAUD_RADIO, DataTableUtils.getDataTableValue(disputedetails, "Dispute category"))).click();
        findSelectBox(FRAUDTYPE_SELECT).selectByVisibleText(DataTableUtils.getDataTableValue(disputedetails, "Fraud type"));
        findSelectBox(CARDSTATUS_DROPDOWN).selectByVisibleText(DataTableUtils.getDataTableValue(disputedetails, "Card status"));
        if (DataTableUtils.getDataTableValue(disputedetails, "Card status").equals("Other")) {
            findElement(MOREDETAILS2_TEXTAREA).sendKeys("test");
        }
        findElement(CARDHOLDERAUTHORIZENO_RADIO).click();
        findElement(CHIPONCARDNO_RADIO).click();
        if (DataTableUtils.getDataTableValue(disputedetails, "Is the card a PIN preferring chip card").equals("Yes")) {
            findElement(IADUtils.parameterizeBy(PINPREFERRINGCARDYES_RADIO, DataTableUtils.getDataTableValue(disputedetails, "Is the card a PIN preferring chip card"))).click();
            Assert.assertTrue(verifyElement(PINPADPRESENT_LABEL));
            if (DataTableUtils.getDataTableValue(disputedetails, "Was a PIN pad present and working").equals("Yes")) {
                findElement(IADUtils.parameterizeBy(PINPADPRESENTYES_RADIO, DataTableUtils.getDataTableValue(disputedetails, "Was a PIN pad present and working"))).click();
            } else {
                findElement(IADUtils.parameterizeBy(PINPADPRESENTNO_RADIO, DataTableUtils.getDataTableValue(disputedetails, "Was a PIN pad present and working"))).click();
            }
        } else {
            findElement(IADUtils.parameterizeBy(PINPREFERRINGCARDNO_RADIO, DataTableUtils.getDataTableValue(disputedetails, "Is the card a PIN preferring chip card"))).click();
        }
        findElement(NOTES_TEXTAREA).sendKeys(DataTableUtils.getDataTableValue(disputedetails, "Notes"));
        findElement(SUBMIT_BUTTON).click();
    }

    @Override
    public VCRDisputeQuestionnaire processInitiateRFC(Map<String, String> frauddetails) {
        boolean selecteddisputecategory = findElement(IADUtils.parameterizeBy(DISPUTECATEGORY, DataTableUtils.getDataTableValue(frauddetails, "Dispute category"))).isSelected();
        Assert.assertEquals(selecteddisputecategory, true);
        String selectedcardstatus = findSelectBox(CARDSTATUS_DROPDOWN).getFirstSelectedOption().getText();
        Assert.assertEquals(selectedcardstatus, DataTableUtils.getDataTableValue(frauddetails, "Card Status"));
        boolean chauthorizeorparticipate = findElement(IADUtils.parameterizeBy(CHAUTHORIZE_RADIO, DataTableUtils.getDataTableValue(frauddetails, "CH Authorize"))).isSelected();
        Assert.assertEquals(chauthorizeorparticipate, true);
        pegaDriver.handleWaits().waitForElementVisibility(OTHERACTIONS_BUTTON);
        findElement(OTHERACTIONS_BUTTON).click();
        findElement(INITIATERFC_LINK).click();
        pegaDriver.handleWaits().waitForElementVisibility(INITIATERFC_LABEL);
        findSelectBox(REQUESTREASONCODE_DROPDOWN).selectByVisibleText("Request for copy bearing signature");
        Assert.assertTrue(verifyElement(CONTROLNUMBER_TEXT));
        findElement(DOMESTICPROCESSING_CHECKBOX).click();
        findElement(SUBMIT_BUTTON).click();
        findElement(CANCEL_BUTTON).click();
        pegaDriver.handleWaits().waitForDocStateReady();
        Assert.assertTrue(verifyElement(RETRIEVALREQUEST_TAB));
        wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
        VCRDisputeQuestionnaire stage = new VCRDisputeQuestionnaireImpl(wizard, wizard.getId());
        stage._setEnvironment(testEnv, wizard.getId());
        return stage;
    }

    @Override
    public void processRFCResponse(Map<String, String> rfcdetails) {
        pegaDriver.handleWaits().waitForElementVisibility(AWAITINGRFCRESPONSEASSIGMENT_LINK);
        Assert.assertTrue(verifyElement(AWAITINGRFCRESPONSEASSIGMENT_LINK));
        findElement(AWAITINGRFCRESPONSEASSIGMENT_LINK).click();
        Assert.assertTrue(verifyElement(AWAITINGRFCRESPONSE_LABEL));
        findElement(SUBMIT_BUTTON).click();
        if (verifyElement(REVIEWRFCRESPONSE_LINK)) {
            findElement(REVIEWRFCRESPONSE_LINK).click();
        }
        Assert.assertTrue(verifyElement(REVIEWRFCRESPONSE_LABEL));
        //Assert.assertTrue(verifyElement(IADUtils.parameterizeBy(RFCRESPONSE_TEXT, DataTableUtils.getDataTableValue(rfcdetails, "Response"))));
        findElement(OK_BUTTON).click();
    }

    @Override
    public void processSubmitFraudReport() {
        pegaDriver.handleWaits().waitForElementVisibility(OTHERACTIONS_BUTTON);
        findElement(OTHERACTIONS_BUTTON).click();
        findElement(SUBMITFRAUDREPORT_LINK).click();
        pegaDriver.handleWaits().waitForElementVisibility(SUBMITFRAUDREPORT_LABEL);
        findSelectBox(FRAUDTYPE_SELECT).selectByVisibleText("Lost");
        findElement(DOMESTICPROCESSING_CHECKBOX).click();
        findElement(SUBMIT_BUTTON).click();
    }

    @Override
    public void processEditFraudReport(Map<String, String> frauddetails) {
        pegaDriver.handleWaits().waitForElementVisibility(OTHERACTIONS_BUTTON);
        findElement(OTHERACTIONS_BUTTON).click();
        findElement(EDITFRAUDREPORT_LINK).click();
        pegaDriver.handleWaits().waitForElementVisibility(EDITFRAUDREPORT_LABEL);
        if (DataTableUtils.getDataTableValue(frauddetails, "Action").equals("Modify")) {
            findElement(FRAUDREPORTMODIFY_RADIO).click();
            pegaDriver.handleWaits().waitForElementVisibility(FRAUDTYPE_SELECT);
            findSelectBox(FRAUDTYPE_SELECT).selectByVisibleText(DataTableUtils.getDataTableValue(frauddetails, "Fraud type"));
            //findElement(DOMESTICPROCESSING_CHECKBOX).click();
        } else {
            findElement(FRAUDREPORTDELETE_RADIO).click();
        }
        findElement(SUBMIT_BUTTON).click();
    }

    @Override
    public void processSubmitFraudReportCloseDispute() {
        pegaDriver.handleWaits().waitForElementVisibility(OTHERACTIONS_BUTTON);
        findElement(OTHERACTIONS_BUTTON).click();
        findElement(SUBMITFRAUDREPORT_LINK).click();
        pegaDriver.handleWaits().waitForElementVisibility(SUBMITFRAUDREPORT_LABEL);
        findSelectBox(FRAUDTYPE_SELECT).selectByVisibleText("Lost");
        findElement(DOMESTICPROCESSING_CHECKBOX).click();
        findElement(CLOSEFRAUDCASE_CHECKBOX).click();
        findElement(SUBMIT_BUTTON).click();
    }

    @Override
    public void processPEDuplicateOrPaidByOtherMeansQuestionnaire(Map<String, String> disputedetails) {
        extractBackendDisputeId(findElement(BACKENDDISPUTEID_TEXT).getText());
        findElement(IADUtils.parameterizeBy(PE_RADIO, DataTableUtils.getDataTableValue(disputedetails, "Dispute category"))).click();
        pegaDriver.handleWaits().waitForElementVisibility(PROCESSINGERRORS_LABEL);
        findSelectBox(INCORRECTABOUTTRANSACTION_DROPDOWN).selectByVisibleText(DataTableUtils.getDataTableValue(disputedetails, "Dispute reason"));
        pegaDriver.handleWaits().waitForElementVisibility(BOTHTRANSACTIONSSAMEACCTNUMBER_LABEL);
        if (DataTableUtils.getDataTableValue(disputedetails, "Both transactions same account number").equals("Yes")) {
            findElement(BOTHTRANACTIONSONSAMEACCOUNTNUMBERYES_RADIO).click();
            pegaDriver.handleWaits().waitForElementVisibility(TRANSACTIONAMOUNT_LABEL);
            findElement(TRANSACTIONID_TEXT).sendKeys(DataTableUtils.getDataTableValue(disputedetails, "Duplicate Tran Id"));
            getExactDate("First transaction date", "DuplicateTranDate", 7, 3, 2017);
            pegaDriver.handleWaits().waitForElementVisibility(DUPLICATEARN_TEXT);
            findElement(DUPLICATEARN_TEXT).sendKeys(DataTableUtils.getDataTableValue(disputedetails, "Duplicate ARN"));
            if (DataTableUtils.getDataTableValue(disputedetails, "Dispute reason").equals("Paid by other means")) {
                findElement(IADUtils.parameterizeBy(NANO_RADIO, DataTableUtils.getDataTableValue(disputedetails, "Payment proof"))).click();
            }

        }
        if (DataTableUtils.getDataTableValue(disputedetails, "Both transactions same account number").equals("No")) {
            findElement(BOTHTRANSACTIONSONSAMEACCOUNTNUMBERNO_RADIO).click();
            pegaDriver.handleWaits().waitForElementVisibility(DIFFERENTVISACARD_LABEL);
            findElement(DIFFERENTVISACARDYES_RADIO).click();
            findElement(FIRSTMERCHANTPASSEDONFUNDSNO_RADIO).click();
            pegaDriver.handleWaits().waitForElementVisibility(TRANSACTIONAMOUNT_LABEL);
            findElement(TRANSACTIONID_TEXT).sendKeys(DataTableUtils.getDataTableValue(disputedetails, "Duplicate Tran Id"));
            getExactDate("First transaction date", "DuplicateTranDate", 7, 3, 2017);
            pegaDriver.handleWaits().waitForElementVisibility(DUPLICATEARN_TEXT);
            findElement(DUPLICATEARN_TEXT).sendKeys(DataTableUtils.getDataTableValue(disputedetails, "Duplicate ARN"));
            if (DataTableUtils.getDataTableValue(disputedetails, "Dispute reason").equals("Paid by other means")) {
                findElement(IADUtils.parameterizeBy(NANO_RADIO, DataTableUtils.getDataTableValue(disputedetails, "Payment proof"))).click();
            }
        }

        findElement(NOTES_TEXTAREA).sendKeys(DataTableUtils.getDataTableValue(disputedetails, "Notes"));
        //pegaDriver.handleWaits().waitForElementVisibility(ROLTRANSACIONID_LABEL);
        findElement(SUBMIT_BUTTON).click();
    }

    @Override
    public void processPEIncorrectCurrencyQuestionnaire(Map<String, String> disputedetails) {
        extractBackendDisputeId(findElement(BACKENDDISPUTEID_TEXT).getText());
        findElement(IADUtils.parameterizeBy(PE_RADIO, DataTableUtils.getDataTableValue(disputedetails, "Dispute category"))).click();
        pegaDriver.handleWaits().waitForElementVisibility(PROCESSINGERRORS_LABEL);
        findSelectBox(INCORRECTABOUTTRANSACTION_DROPDOWN).selectByVisibleText("Incorrect currency");
        pegaDriver.handleWaits().waitForElementVisibility(CORRECTCURRENCY_LABEL);
        findAutoComplete(CORRECTCURRENCY_AUTOCOMPLETE).setValue(DataTableUtils.getDataTableValue(disputedetails, "Correct currency"));
        findElement(IADUtils.parameterizeBy(NANO_RADIO, DataTableUtils.getDataTableValue(disputedetails, "DCC option"))).click();
        findElement(NOTES_TEXTAREA).sendKeys(DataTableUtils.getDataTableValue(disputedetails, "Notes"));
        findElement(SUBMIT_BUTTON).click();

    }

    @Override
    public void processPEIncorrectAccountNumberQuestionnaire(Map<String, String> disputedetails) {
        extractBackendDisputeId(findElement(BACKENDDISPUTEID_TEXT).getText());
        findElement(IADUtils.parameterizeBy(PE_RADIO, DataTableUtils.getDataTableValue(disputedetails, "Dispute category"))).click();
        pegaDriver.handleWaits().waitForElementVisibility(PROCESSINGERRORS_LABEL);
        findSelectBox(INCORRECTABOUTTRANSACTION_DROPDOWN).selectByVisibleText("Incorrect account number");
        pegaDriver.handleWaits().waitForElementVisibility(CARDHOLDERACCOUNTNUMBER_LABEL);
        findElement(CARDHOLDERACCOUNTNUMBERNO_RADIO).click();
        pegaDriver.handleWaits().waitForElementVisibility(ACCOUNTNUMBERONMASTERFILE_LABEL);
        findElement(ACCOUNTNUMBERONMASTERFILEYES_RADIO).click();
        findElement(ACCOUNTNUMBERONRECEIPT_TEXT).sendKeys("4752999999999991");
        findElement(NOTES_TEXTAREA).sendKeys(DataTableUtils.getDataTableValue(disputedetails, "Notes"));
        findElement(SUBMIT_BUTTON).click();

    }

    @Override
    public void processPEIncorrectAmountQuestionnaire(Map<String, String> disputedetails) {
        extractBackendDisputeId(findElement(BACKENDDISPUTEID_TEXT).getText());
        findElement(IADUtils.parameterizeBy(PE_RADIO, DataTableUtils.getDataTableValue(disputedetails, "Dispute category"))).click();
        pegaDriver.handleWaits().waitForElementVisibility(PROCESSINGERRORS_LABEL);
        findSelectBox(INCORRECTABOUTTRANSACTION_DROPDOWN).selectByVisibleText("Incorrect amount");
        pegaDriver.handleWaits().waitForElementVisibility(NOSHOWTRANSACTION_TEXT);
        findElement(NOSHOWTRANSACTIONNO_RADIO).click();
        pegaDriver.handleWaits().waitForElementVisibility(AMOUNTONCARDHOLDERRECEIPT_LABEL);
        findElement(AMOUNYONCARDHOLDERRECEIPT_TEXT).sendKeys("100");
        findElement(NOTES_TEXTAREA).sendKeys(DataTableUtils.getDataTableValue(disputedetails, "Notes"));
        findElement(SUBMIT_BUTTON).click();
    }

    @Override
    public void processPEIncorrectTransCodeQuestionnaire(Map<String, String> disputedetails) {
        extractBackendDisputeId(findElement(BACKENDDISPUTEID_TEXT).getText());
        findElement(IADUtils.parameterizeBy(PE_RADIO, DataTableUtils.getDataTableValue(disputedetails, "Dispute category"))).click();
        pegaDriver.handleWaits().waitForElementVisibility(PROCESSINGERRORS_LABEL);
        findSelectBox(INCORRECTABOUTTRANSACTION_DROPDOWN).selectByVisibleText("Incorrect transaction code");
        findSelectBox(TRANSACTIONINCORRECT_DROPDOWN).selectByVisibleText(DataTableUtils.getDataTableValue(disputedetails, "Transaction Incorrect reason"));
        findElement(NOTES_TEXTAREA).sendKeys(DataTableUtils.getDataTableValue(disputedetails, "Notes"));
        findElement(SUBMIT_BUTTON).click();
    }

    @Override
    public void processPELatePresentmentQuesitonniare(Map<String, String> disputedetails) {
        extractBackendDisputeId(findElement(BACKENDDISPUTEID_TEXT).getText());
        findElement(IADUtils.parameterizeBy(PE_RADIO, DataTableUtils.getDataTableValue(disputedetails, "Dispute category"))).click();
        pegaDriver.handleWaits().waitForElementVisibility(PROCESSINGERRORS_LABEL);
        findSelectBox(INCORRECTABOUTTRANSACTION_DROPDOWN).selectByVisibleText("Late presentment");
        findSelectBox(ACCOUNTSTATUS_DROPDOWN).selectByVisibleText("Other fraud");
        findElement(NOTES_TEXTAREA).sendKeys(DataTableUtils.getDataTableValue(disputedetails, "Notes"));
        findElement(SUBMIT_BUTTON).click();
    }

    @Override
    public void processCDNRMerchandise(Map<String, String> disputedetails) {

    }


    @Override
    public CollaborationRequest getCollaborationRequestScreen() {
        findElement(ACTIONS_BUTTON).click();
        findElement(INITIATECOLLABORATOIN_LINK).click();
        wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
        CollaborationRequest stage = new CollaborationRequestImpl(wizard, wizard.getId());
        stage._setEnvironment(testEnv, wizard.getId());
        return stage;
    }
}
