package com.iad.fs.sdissuer.portal;

import com.iad.fs.sdissuer.pages.ProcessIssuerLiability;
import com.iad.fs.sdissuer.pages.ProcessPotentialDuplicates;
import com.iad.fs.sdissuer.pages.SearchforTransactions;
import com.iad.fs.sdissuer.pages.VCRDisputeQuestionnaire;
import com.iad.fs.sdissuer.tiles.TopNav;
import com.pega.page.Portal;
import com.pega.util.DataUtil;
import org.openqa.selenium.By;

public interface CaseManagerPortal extends Portal {

    By SEE_ALL_FROM_WORKBASKET_LINK = By.xpath("//a[@data-test-id = '20150107144324063923908']");
    By LICENSE_REVIEW_WB = By.id("LicenseReviewWB");
    By LICENSE_INSPECTION_WB = By.id("InspectionWB");
    By MODAL_BUTTON_SUBMIT = By.id("ModalButtonSubmit");
    By USERREGISTRATIONREVIEWWB = By.id("UserRegistrationReview");
    By VCRDISPUTEQUESTIONNAIRE_LINK = By.linkText("Dispute questionnaire");
    By PROCESSPOTENTIALDUPLICATESASSIGNMENTLINK = By.linkText("Process potential duplicates");
    By TIMEFRAMEEXPIRYFLOW_LINK = By.linkText("Time frame expiry flow");
    String CASE_ID = DataUtil.readFileToString("case_id.txt");
    By CASE_ID_LINK = By.xpath("//a[text() = '" + CASE_ID + "']");
    By MY_WORK = By.xpath("//span[text()='My Work']");
    By CUSTOMERCLAIMWB = By.xpath("//*[@id='CustomerClaim']");
    By FRAUDWB = By.xpath("//*[@id='Fraud']");
    By CUSTOMERINITIATEDLABEL = By.xpath("//*[contains(text(),'Customer Initiated')]");
    By FRAUDLABEL = By.xpath("//*[contains(text(),'Fraud')]");
    By FILTERLINK = By.xpath("//*[@id='pui_filter']");
    By DISPUTESEARCHTEXT = By.id("pySearchText");
    By DISPUTESEARCHAPPLYBUTTON = By.xpath("//button[contains(text(),'Apply')]");
    By DISPUTEIDTABLE = By.xpath("//table[@id='bodyTbl_right'][@pl_prop='D_WorkBasket.pxResults']");
    By DISPUTEIDTABLEROWS_LIST = By.xpath("//table[@id='bodyTbl_right'][@pl_prop='D_WorkBasket.pxResults']//tr");
    By BACKEND_PROCESSDUPLICATESHEADER = By.xpath("//label[contains(text(),'Process potential duplicates')]");
    By BACKEND_VCRDISPUTEQUESTIONNAIREHEADER = By.xpath("//label[contains(text(),'Dispute questionnaire')]");
    By REVIEWSUGGESTEDREASONCODE_LABEL = By.xpath("//label[contains(text(),'Review suggested reason code')]");
    By REVIEWSUGGESTEDDISPUTECATEGORY_HEADER = By.xpath("//label[contains(text(),'Review suggested dispute category')]");
    By REVIEWSUGGESTEDDISPUTECATEGORY_LABEL = By.xpath("//*[@data-node-id='SuggestedReasonCode']");
    By SUBMIT_BUTTON = By.xpath("//button[@type='button']//*[contains(text(),'Submit')]");

    TopNav getTopNav();

    SearchforTransactions getSelectforTransactionspage();

    boolean processCustomerIntiatedWB();

    boolean processFraudWB();

    ProcessPotentialDuplicates getProcessPotentialDuplicates();

    ProcessIssuerLiability getTimeFrameExpiryFlow();

    VCRDisputeQuestionnaire getVCRDisputeQuestionnaire();

}
