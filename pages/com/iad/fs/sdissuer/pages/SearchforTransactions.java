package com.iad.fs.sdissuer.pages;

import com.pega.util.LocalizationUtil;
import org.openqa.selenium.By;

import java.util.Map;

/**
 * This Interface is about Search for transactions page and its web elements and in this page user selects single
 * or multiple transactions to create dispute and on processing this page it navigates
 * to either process potential duplicates page or Qualify Dispute page in case of CSR flow. In case of CSR->Backend flow
 * This page gets the instance for VCR Dispute questionnaire page if user selects the
 *
 * @author Vamsi Kuppa
 * @since 02 Feb 2017
 */
public interface SearchforTransactions extends SDWorkObjectPage {

    By SEARCHFORTRANSACTIONS = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Search for transactions") + "')]");
    By ACCOUNTNUMBER = By.id("AccountNumber");
    By ACQUIEREREFERENCENUMBER = By.xpath("//*[@id='AcquirerReferenceNumber']");
    By SEARCH_BUTTON = By.xpath("//*[text()='Search']");
    By SEARCHRESULTS_TEXT = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Search results") + "')]");
    By TRANSACTIONSUMMARY_TEXT = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Transaction Summary") + "')]");
    By TRANSACTION_CHECKBOX = By.xpath("//input[@type='checkbox'][contains(@id,'Indicator1')]");
    By FRAUD_CHECKBOX = By.id("FraudSelectAllIndicator");
    By CREATE_BUTTON = By.xpath("//*[contains(text(),'Create')]");


    void setDataforTransactions(Map<String, String> transactionDetails);

    void selectSingleTransaction();

    void selectFraudClaim();

    void selectMultipleTransactions(int numberoftransactions);

    ProcessPotentialDuplicates getProcessPotentialDuplicates();

    QualifyDispute getQualifyDispute();

    VCRDisputeQuestionnaire getVCRDisputeQuestionnaire();

    QualifyFraud getQualifyFraud();

    //boolean isDuplicatesPresent();


}
