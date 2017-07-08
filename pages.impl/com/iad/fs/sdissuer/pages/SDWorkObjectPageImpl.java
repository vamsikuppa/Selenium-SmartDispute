package com.iad.fs.sdissuer.pages;

import com.pega.iad.page.IADWorkObjectPageImpl;
import com.pega.iad.utils.DataTableUtils;
import com.pega.iad.utils.IADUtils;
import com.pega.ri.Wizard;
import com.pega.util.DataUtil;
import com.pega.util.LocalizationUtil;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This implementation is about SD Work Object Page that gets implemented by all the other pages and this page
 * contains all the generic actions or methods or common web elements through out the application
 *
 * @author Vamsi Kuppa
 * @since 02 Feb 2017
 */
public class SDWorkObjectPageImpl extends IADWorkObjectPageImpl implements SDWorkObjectPage {

    public Wizard wizard;
    //private static Logger log = Logger.getLogger(Log.class.getName());

    public SDWorkObjectPageImpl(WebElement elmt, String elmtId) {
        super(elmt, elmtId);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void processAwaitingAcquirerResponseAssignment() {
        Assert.assertTrue(verifyElement(AWAITINGACQUIRERRESPONSEASSIGNMENT_LINK));
        findElement(AWAITINGACQUIRERRESPONSEASSIGNMENT_LINK).click();
        findElement(SUBMIT_BUTTON).click();
    }

    /**
     * This method is used to validate Overview tab details
     *
     * @param overviewtabdetails this paramerter will give overview tab details and validates those overview tab details
     */
    @Override
    public void validateOverviewTab(Map<String, String> overviewtabdetails) {
        // TODO Auto-generated method stub
        findElement(OVERVIEWTABLINK).click();
        boolean disptutecategorydispayed = findElement(IADUtils.parameterizeBy(DISPUTECATEGORYLABEL, DataTableUtils.getDataTableValue(overviewtabdetails, "Dispute category"))).isDisplayed();
        Assert.assertEquals(disptutecategorydispayed, true);
        boolean fraudindicatordisplayed = findElement(IADUtils.parameterizeBy(FRAUDINDICATORLABEL, DataTableUtils.getDataTableValue(overviewtabdetails, "Fraud indicator"))).isDisplayed();
        Assert.assertEquals(fraudindicatordisplayed, true);
        boolean statusdisplayed = findElement(IADUtils.parameterizeBy(CASESTATUS, DataTableUtils.getDataTableValue(overviewtabdetails, "Status"))).isDisplayed();
        Assert.assertEquals(statusdisplayed, true);
    }

    /**
     * This method is used to validate Interview tab details for Paid by other means dispute reason
     *
     * @param interviewdetails
     */
    @Override
    public void validateInterviewTabPaidByOtherMeans(Map<String, String> interviewdetails) {
        // TODO Auto-generated method stub
        pegaDriver.handleWaits().waitForElementClickable(INTERVIEWTABLINK);
        findElement(INTERVIEWTABLINK).click();
        boolean disptutecategorydispayed = findElement(IADUtils.parameterizeBy(SUGGESTEDDISPUTECATEGORYLABEL, LocalizationUtil.getLocalizedWord(DataTableUtils.getDataTableValue(interviewdetails, "Dispute category")))).isDisplayed();
        Assert.assertEquals(disptutecategorydispayed, true);
        boolean disputereasondisplayed = findElement(IADUtils.parameterizeBy(SELECTEDDISPUTEREASONLABEL, DataTableUtils.getDataTableValue(interviewdetails, "Dispute Reason"))).isDisplayed();
        Assert.assertEquals(disputereasondisplayed, true);
        boolean atrmerchantlabeldisplayed = findElement(IADUtils.parameterizeBy(ATRMERCHANTLABEL, DataTableUtils.getDataTableValue(interviewdetails, "Did you attempt to resolve with the merchant"))).isDisplayed();
        Assert.assertEquals(atrmerchantlabeldisplayed, true);
        boolean atrcontactmethoddisplayed = findElement(IADUtils.parameterizeBy(ATRCONTACTMETHODLABEL, DataTableUtils.getDataTableValue(interviewdetails, "Contact Method"))).isDisplayed();
        Assert.assertEquals(atrcontactmethoddisplayed, true);
        boolean atrcontactnamedisplayed = findElement(IADUtils.parameterizeBy(ATRCONTACTNAMELABEL, DataTableUtils.getDataTableValue(interviewdetails, "Contact Name"))).isDisplayed();
        Assert.assertEquals(atrcontactnamedisplayed, true);
        boolean atrmerchantresponsedisplayed = findElement(IADUtils.parameterizeBy(ATRMERCHANTRESPONSELABEL, DataTableUtils.getDataTableValue(interviewdetails, "Merchant Response"))).isDisplayed();
        Assert.assertEquals(atrmerchantresponsedisplayed, true);
        boolean paymentmethodlabeldisplayed = findElement(IADUtils.parameterizeBy(PAYMENTMETHODLABEL, DataTableUtils.getDataTableValue(interviewdetails, "Payment method"))).isDisplayed();
        Assert.assertEquals(paymentmethodlabeldisplayed, true);
        boolean paymentproofdisplayed = findElement(IADUtils.parameterizeBy(PAYMENTPROOFINDLABEL, DataTableUtils.getDataTableValue(interviewdetails, "Do you have proof of payment"))).isDisplayed();
        Assert.assertEquals(paymentproofdisplayed, true);
       /* if (verifyElement(BOTHTRANSACTIONSSAMEACCTNUMBER_LABEL)) {
            boolean bothtransactionssameacctind = findElement(IADUtils.parameterizeBy(BOTHTRANSACTIONSSAMEACCTIND, DataTableUtils.getDataTableValue(interviewdetails, "Are both transactions on same account number"))).isDisplayed();
            Assert.assertEquals(bothtransactionssameacctind, true);
        }*/
    }

    /**
     * This method is used to validate Interview tab details for I was charged more than once dispute reason
     *
     * @param interviewdetails
     */

    @Override
    public void validateInterviewTabChargedMoreThanOnce(Map<String, String> interviewdetails) {
        pegaDriver.handleWaits().waitForElementClickable(INTERVIEWTABLINK);
        findElement(INTERVIEWTABLINK).click();
        boolean disptutecategorydispayed = findElement(IADUtils.parameterizeBy(SUGGESTEDDISPUTECATEGORYLABEL, LocalizationUtil.getLocalizedWord(DataTableUtils.getDataTableValue(interviewdetails, "Dispute category")))).isDisplayed();
        Assert.assertEquals(disptutecategorydispayed, true);
        boolean disputereasondisplayed = findElement(IADUtils.parameterizeBy(SELECTEDDISPUTEREASONLABEL, DataTableUtils.getDataTableValue(interviewdetails, "Dispute Reason"))).isDisplayed();
        Assert.assertEquals(disputereasondisplayed, true);
        boolean atrmerchantlabeldisplayed = findElement(IADUtils.parameterizeBy(ATRMERCHANTLABEL, DataTableUtils.getDataTableValue(interviewdetails, "Did you attempt to resolve with the merchant"))).isDisplayed();
        Assert.assertEquals(atrmerchantlabeldisplayed, true);
        boolean atrcontactmethoddisplayed = findElement(IADUtils.parameterizeBy(ATRCONTACTMETHODLABEL, DataTableUtils.getDataTableValue(interviewdetails, "Contact Method"))).isDisplayed();
        Assert.assertEquals(atrcontactmethoddisplayed, true);
        boolean atrcontactnamedisplayed = findElement(IADUtils.parameterizeBy(ATRCONTACTNAMELABEL, DataTableUtils.getDataTableValue(interviewdetails, "Contact Name"))).isDisplayed();
        Assert.assertEquals(atrcontactnamedisplayed, true);
        boolean atrmerchantresponsedisplayed = findElement(IADUtils.parameterizeBy(ATRMERCHANTRESPONSELABEL, DataTableUtils.getDataTableValue(interviewdetails, "Merchant Response"))).isDisplayed();
        Assert.assertEquals(atrmerchantresponsedisplayed, true);
        boolean bothtransactionssameacctnbrdisplayed = findElement(IADUtils.parameterizeBy(BOTHTRANSACTIONSSAMEACCTIND, DataTableUtils.getDataTableValue(interviewdetails, "Are both transactions on the same account number"))).isDisplayed();
        Assert.assertEquals(bothtransactionssameacctnbrdisplayed, true);
        boolean paymentproofdisplayed = findElement(IADUtils.parameterizeBy(ACQREFFIRSTTRANSIND_LABEL, DataTableUtils.getDataTableValue(interviewdetails, "Acquirer reference number of the first transaction"))).isDisplayed();
        Assert.assertEquals(paymentproofdisplayed, true);
        boolean bothtransactionssameacctind = findElement(IADUtils.parameterizeBy(TRANSID_LABEL, DataTableUtils.getDataTableValue(interviewdetails, "Transaction ID"))).isDisplayed();
        Assert.assertEquals(bothtransactionssameacctind, true);
    }

    /**
     * @param accountingdetails
     */
    @Override
    public void validateAccountingTab(Map<String, String> accountingdetails) {
        // TODO Auto-generated method stub

    }

    /**
     * @param vcrtabdetails
     */

    @Override
    public void validateVCRTab(Map<String, String> vcrtabdetails) {
        // TODO Auto-generated method stub
        findElement(VCRTABLINK).click();
    }

    /**
     *
     */
    @Override
    public void validateGoodFaithResponseVCRTab() {
        findElement(VCRTABLINK).click();
        Assert.assertTrue(verifyElement(DISPUTEDETAILS_HEADING));
        Assert.assertTrue(verifyElement(GOODFAITHATTEMPT_HEADER));
        Assert.assertTrue(verifyElement(GOODFAITHRESPONSE_HEADER));

    }

    @Override
    public void validateVCRTabDisputeResponse(Map<String, String> vcrtabdetails) {
        findElement(VCRTABLINK).click();
        Assert.assertTrue(verifyElement(DISPUTEDETAILS_HEADING));
        Assert.assertTrue(verifyElement(DISPUTERESPONSE_HEADING));
    }

    /**
     * This method validates the VCR Tab details after pre arbitration has been recalled by issuer
     *
     * @param vcrtabdetails
     */
    @Override
    public void validateVCRTabPreArbRecall(Map<String, String> vcrtabdetails) {
        findElement(VCRTABLINK).click();
        Assert.assertTrue(verifyElement(DISPUTEDETAILS_HEADING));
        Assert.assertTrue(verifyElement(DISPUTERESPONSE_HEADING));
        Assert.assertFalse(verifyElement(PREARBDETAILS_HEADING));
    }

    @Override
    public void validateVCRTabDisputeRecall(Map<String, String> vcrtabdetails) {
        findElement(VCRTABLINK).click();
        Assert.assertTrue(verifyElement(DISPUTEDETAILS_HEADING));
    }

    @Override
    public void validateVCRTabPreCompliance(Map<String, String> vcrtabdetails) {
        findElement(VCRTABLINK).click();
        Assert.assertTrue(verifyElement(DISPUTEDETAILS_HEADING));
        Assert.assertTrue(verifyElement(PRECOMPDETAILS_HEADING));
        Assert.assertTrue(verifyElement(PRECOMPRESPDETAILS_HEADING));

    }

    @Override
    public void validateVCRTabRecallPreCompliance() {
        findElement(VCRTABLINK).click();
        Assert.assertTrue(verifyElement(DISPUTEDETAILS_HEADING));
        Assert.assertFalse(verifyElement(PRECOMPDETAILS_HEADING));
    }

    @Override
    public void validateVCRTabWithDrawArbitration() {
        findElement(VCRTABLINK).click();
        Assert.assertTrue(verifyElement(DISPUTEDETAILS_HEADING));
        Assert.assertTrue(verifyElement(DISPUTERESPONSE_HEADING));
        Assert.assertTrue(verifyElement(PREARBDETAILS_HEADING));
        Assert.assertTrue(verifyElement(PREARBRESPONSEDETAILS_HEADING));
        Assert.assertFalse(verifyElement(ARBITRATIONDETAILS_HEADING));
    }

    @Override
    public void validateVCRTabCompliance(Map<String, String> vcrtabdetails) {
        findElement(VCRTABLINK).click();
        Assert.assertTrue(verifyElement(DISPUTEDETAILS_HEADING));
        Assert.assertTrue(verifyElement(PRECOMPDETAILS_HEADING));
        Assert.assertTrue(verifyElement(PRECOMPRESPDETAILS_HEADING));
        Assert.assertTrue(verifyElement(COMPLIANCEDETAILS_HEADER));
        Assert.assertTrue(verifyElement(COMPLIANCERULING_HEADER));
    }

    @Override
    public void validateRetrievalRequestTab(Map<String, String> rfcdetails) {
        findElement(RETRIEVALREQUEST_TAB).click();
        Assert.assertTrue(verifyElement(IADUtils.parameterizeBy(RFCRESPONSE_TEXT, DataTableUtils.getDataTableValue(rfcdetails, "Response"))));

    }

    @Override
    public void validateVCRTabWithdrawCompliance() {
        findElement(VCRTABLINK).click();
        Assert.assertTrue(verifyElement(DISPUTEDETAILS_HEADING));
        Assert.assertTrue(verifyElement(PRECOMPDETAILS_HEADING));
        Assert.assertTrue(verifyElement(PRECOMPRESPDETAILS_HEADING));
        Assert.assertFalse(verifyElement(COMPLIANCEDETAILS_HEADER));
    }

    @Override
    public void validateVCRTabFraudReport(Map<String, String> reportdetails) {
        findElement(VCRTABLINK).click();
        if (DataTableUtils.getDataTableValue(reportdetails, "Action").equals("Modify") || DataTableUtils.getDataTableValue(reportdetails, "Action").equals("Close")) {
            Assert.assertTrue(verifyElement(FRAUDREPORTID_TEXT));
        }
    }

    /**
     * This method will compare two strings by ignoring the case and asserts the compare result
     *
     * @param str1
     * @param str2
     */
    @Override
    public void assertCompareIgnoreCaseStrings(String str1, String str2) {
        Assert.assertTrue(StringUtils.containsIgnoreCase(str1, str2));
    }


    /**
     * This method is about taking the Write off action at any page
     *
     * @author Vamsi Kuppa
     */

    @Override
    public void takeWriteOffAction() {
        // TODO Auto-generated method stub
        findElement(WRITEOFF_RADIO).click();
        findElement(SUBMIT_BUTTON).click();
        assertCompareIgnoreCaseStrings(findElement(ATTACHMENTS_SECTION).getText(), "Final credit letter");
    }

    /**
     * This method is about taking the cardholder liable action at any page
     *
     * @Author Vamsi Kuppa
     */
    @Override
    public void takeChLiableAction() {
        // TODO Auto-generated method stub
        findElement(CARDHOLDERLIABLE_RADIO).click();
        findElement(SUBMIT_BUTTON).click();
        assertCompareIgnoreCaseStrings(findElement(ATTACHMENTS_SECTION).getText(), "Cardholder liable letter");
    }

    /**
     * This method will take first two parameters as actions and performs those two actions when Multi Pronged action is selected
     *
     * @param option1
     * @param option2
     */
    @Override
    public void takeMultiProngedAction(String option1, String option2) {
        findElement(MULTIPRONGED_RADIO).click();
        Assert.assertTrue(verifyElement(MULTIPRONGEDOPTIONS_LABEL));
        if (option1.equalsIgnoreCase("Cardholder liable") || option2.equalsIgnoreCase("Cardholder liable")) {
            findElement(CARDHOLDERLIABLE_CHECKBOX).click();
        }
        if (option1.equalsIgnoreCase("Write off") || option2.equalsIgnoreCase("Write off")) {
            findElement(WRITEOFF_CHECKBOX).click();
        }
        if (option1.equalsIgnoreCase("Pre Arbitration") || option2.equalsIgnoreCase("Pre Arbitration")) {

        }

    }

    /**
     * This method will take first three parameters as actions and performs those three actions when Multi Pronged action is selected
     *
     * @param option1
     * @param option2
     * @param option3
     */

    @Override
    public void takeMultiProngedAction(String option1, String option2, String option3) {

    }


    /**
     * This method will extract the dispute id in the CSR page and store it in case_id.txt
     *
     * @param text
     * @Author Vamsi Kuppa
     */
    void extractDisputeId(String text) {
        Pattern pattern = Pattern.compile("D-[0-9]+");
        Matcher match = pattern.matcher(text);
        if (match.find()) {
            String disputeid = match.group(0);
            DataUtil.writeStringToFile(disputeid, "case_id.txt");
            Reporter.log("Dispute id is " + DataUtil.readFileToString("case_id.txt"));
        } else {
            Reporter.log("Match not found");
        }

    }

    /**
     * This method will extract the Claim id in the CSR page and store it in case_id.txt
     *
     * @param text
     * @Author Vamsi Kuppa
     */
    void extractClaimId(String text) {
        Pattern pattern = Pattern.compile("C-[0-9]+");
        Matcher match = pattern.matcher(text);
        if (match.find()) {
            String disputeid = match.group(0);
            DataUtil.writeStringToFile(disputeid, "case_id.txt");
            Reporter.log("Dispute id is " + DataUtil.readFileToString("case_id.txt"));
        } else {
            Reporter.log("Match not found");
        }

    }

    /** This method will extract dispute id and store it in case_id.txt
     * @param text
     */
    void extractBackendDisputeId(String text) {
        Pattern pattern = Pattern.compile("D-[0-9]+");
        Matcher match = pattern.matcher(text);
        if (match.find()) {
            String disputeid = match.group(0);
            DataUtil.writeStringToFile(disputeid + "," + DataUtil.readFileToString("BackendDisputeIdList.txt"), "BackendDisputeIdList.txt");
            Reporter.log("Dispute id is " + DataUtil.readFileToString("BackendDisputeIdList.txt"));
        } else {
            Reporter.log("match not found");
        }
    }

    /**
     * This method takes the Date field label and the id of the date field and enters the yesterdays date
     *
     * @param datefieldlabel
     * @param id
     */
    @Override
    public void getYesterdaysDate(String datefieldlabel, String id) {
        findElement(By.xpath("//*[text()='" + datefieldlabel + "']/following::input[@id='" + id + "']/following-sibling::img[@class='inactvIcon']")).click();
        selectPastDateFromDatePicker(1);
    }

    /**
     * This method takes the date field and the id of the date field and enters the previous date with mentioned noofdays as argument
     *
     * @param datefieldlabel
     * @param id
     */
    @Override
    public void getPreviousDate(String datefieldlabel, String id, int noofdays) {
        findElement(By.xpath("//*[text()='" + datefieldlabel + "']/following::input[@id='" + id + "']/following-sibling::img[@class='inactvIcon']")).click();
        selectPastDateFromDatePicker(noofdays);
    }

    /**
     *
     * @param datefieldlabel
     * @param id
     * @param noofdays
     */
    @Override
    public void getFutureDate(String datefieldlabel, String id, int noofdays) {
        findElement(By.xpath("//*[text()='" + datefieldlabel + "']/following::input[@id='" + id + "']/following-sibling::img[@class='inactvIcon']")).click();
        selectFutureDateFromDatePicker(noofdays);
    }

    /**
     *
     * @param datefieldlabel
     * @param id
     * @param date
     * @param month
     * @param year
     */
    @Override
    public void getExactDate(String datefieldlabel, String id, int date, int month, int year) {
        findElement(By.xpath("//*[text()='" + datefieldlabel + "']/following::input[@id='" + id + "']/following-sibling::img[@class='inactvIcon']")).click();
        selectDateFromDatePicker(date, month, year);
    }


    /**
     *
     */
    @Override
    public void accountingSuspenseDetails() {

    }

    /**
     *
     */
    @Override
    public void accountingSuspenseWriteOff() {

    }

    /**
     *
     */
    @Override
    public void accountingSuspenseCHLiable() {

    }

    /**
     *
     */
    @Override
    public void suspenseZeroCheck() {

    }

    /**
     *
     */
    @Override
    public void validatePreArbLabels() {
        boolean prearbrespvisible = findElement(PROCESSPREARBRESP_LABEL).isVisible();
        Assert.assertEquals(prearbrespvisible, true);
        boolean prearbdetails = findElement(PREARBDETAILS_LABEL).isVisible();
        Assert.assertEquals(prearbdetails, true);
    }

    /**
     *
     */
    @Override
    public void validatePreArbSectionsVcrTab() {
        findElement(VCRTABLINK).click();
        Assert.assertTrue(findElement(PREARBDETAILSSECTION_LABEL).isVisible());
        Assert.assertTrue(findElement(PREARBRESPONSESECTION_LABEL).isVisible());
    }

    /**
     *
     */
    @Override
    public void processPreArbRespAcceptFully() {
        findElement(ACCEPTFULLY_RADIO).click();
        findElement(PREARBRESPONSE_TEXTAREA).sendKeys("Accepting pre arb request");
        findElement(SUBMIT_BUTTON).click();
        if (findElement(PROCESSASSOCIATEDTXN_LABEL).isVisible()) {
            findElement(ASSOCIATEDTXN_TEXTAREA).sendKeys("Ignore associated Txns");
            findElement(SUBMIT_BUTTON).click();
        }
        boolean processprearbliability = findElement(PROCESSPREARBLIABILITY_LABEL).isVisible();
        Assert.assertEquals(processprearbliability, true);
        findElement(ACCOUNTING_TAB).click();
        accountingSuspenseDetails();
        validatePreArbSectionsVcrTab();

    }

    /**
     *
     */
    @Override
    public void processPreArbResponseAcceptPartially() {
        findElement(ACCEPTPARTIALLY_RADIO).click();
        pegaDriver.handleWaits().waitForElementVisibility(PREARBACCEPTANCEAMOUNT_TEXTINPUT);
        findElement(PREARBACCEPTANCEAMOUNT_TEXTINPUT).clear();
        pegaDriver.handleWaits().waitForDocStateReady();
        findElement(PREARBACCEPTANCEAMOUNT_TEXTINPUT).sendKeys("50.00");
        findElement(NEWINFO_RADIO).click();
        findElement(PREARBNOTACCEPTINGFULLLREASON).sendKeys("Not accepting full liability");
        findElement(CHCONTACTCE_RADIO).click();
        findElement(CHWANSTOCONTINUE_TEXTAREA).sendKeys("yes CH Wants to continue dispute");
        pegaDriver.handleWaits().sleep(10);
        findElement(PREARBRESPONSE_TEXTAREA).sendKeys("Accepted partially");
        pegaDriver.handleWaits().sleep(10);
        findElement(SUBMIT_BUTTON).click();
        if (findElement(PROCESSASSOCIATEDTXN_LABEL).isVisible()) {
            findElement(ASSOCIATEDTXN_TEXTAREA).sendKeys("Ignore associated Txns");
            findElement(SUBMIT_BUTTON).click();
        }
        findElement(ACCOUNTING_TAB).click();
        accountingSuspenseDetails();
        validatePreArbSectionsVcrTab();
        pegaDriver.handleWaits().waitForElementVisibility(PROCESSPREARBRESPONSE_LINK);
        pegaDriver.handleWaits().waitForElementVisibility(PREARBPENDCLOSURE_LINK);
        findElement(PROCESSPREARBRESPONSE_LINK).click();
        boolean processprearbliability = findElement(PROCESSPREARBLIABILITY_LABEL).isVisible();
        Assert.assertEquals(processprearbliability, true);
        findElement(ACCOUNTING_TAB).click();
        accountingSuspenseDetails();
        validatePreArbSectionsVcrTab();
    }

    /**
     *
     */
    @Override
    public void processPreArbResponseAcceptfullyWO() {
        takeWriteOffAction();
        findElement(OVERVIEWTABLINK).click();
        boolean writeoffstatus = findElement(WRITEOFF_STATUS).isVisible();
        Assert.assertEquals(writeoffstatus, true);
        accountingSuspenseWriteOff();
    }

    /**
     *
     */
    @Override
    public void processPreArbResponseAcceptfullyCH() {
        takeChLiableAction();
        findElement(OVERVIEWTABLINK).click();
        boolean chliablestatus = findElement(CHLIABLE_STATUS).isVisible();
        Assert.assertEquals(chliablestatus, true);
        accountingSuspenseCHLiable();
    }

    /**
     *
     */
    @Override
    public void processPreArbRespAcceptPartiallyWO() {
        findElement(WRITEOFF_RADIO).click();
        findElement(SUBMIT_BUTTON).click();
        accountingSuspenseWriteOff();
        pegaDriver.handleWaits().waitForElementVisibility(PREARBPENDCLOSURE_LINK);

    }

    /**
     *
     */
    @Override
    public void processPreArbRespAcceptPartiallyCH() {
        findElement(CARDHOLDERLIABLE_RADIO).click();
        findElement(SUBMIT_BUTTON).click();
        accountingSuspenseCHLiable();
        pegaDriver.handleWaits().waitForElementVisibility(PREARBPENDCLOSURE_LINK);
    }

    /**
     *
     */
    @Override
    public void processPreArbResponseDeclined() {
        findElement(DECLINED_RADIO).click();
        pegaDriver.handleWaits().waitForElementVisibility(NEWINFO_RADIO);
        findElement(NEWINFO_RADIO).click();
        findElement(PREARBNOTACCEPTINGFULLLREASON).sendKeys("Not accepting full liability");
        if (verifyElement(CHCONTACTCE_RADIO)) {
            findElement(CHCONTACTCE_RADIO).click();
            findElement(CHWANSTOCONTINUE_TEXTAREA).sendKeys("yes CH Wants to continue dispute");
        }
        pegaDriver.handleWaits().sleep(10);
        findElement(PREARBRESPONSE_TEXTAREA).sendKeys("Declining the Pre-arbitration");
        pegaDriver.handleWaits().sleep(10);
        findElement(SUBMIT_BUTTON).click();
        if (findElement(PROCESSASSOCIATEDTXN_LABEL).isVisible()) {
            findElement(ASSOCIATEDTXN_TEXTAREA).sendKeys("Ignore associated Txns");
            findElement(SUBMIT_BUTTON).click();
        }
        pegaDriver.handleWaits().waitForElementVisibility(PREARBPENDCLOSURE_LINK);
        validatePreArbSectionsVcrTab();
        findElement(ACCOUNTING_TAB).click();
        pegaDriver.handleWaits().waitForElementNotPresence(SUSPENSE_LABEL);
        findElement(OVERVIEWTABLINK).click();
        findElement(PENDCLOSURE_STATUS);
    }
}
