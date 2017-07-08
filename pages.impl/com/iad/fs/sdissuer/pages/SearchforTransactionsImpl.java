package com.iad.fs.sdissuer.pages;


import com.pega.iad.utils.DataTableUtils;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class SearchforTransactionsImpl extends SDWorkObjectPageImpl implements SearchforTransactions {


    public SearchforTransactionsImpl(WebElement elmt, String elmtId) {
        super(elmt, elmtId);
        // TODO Auto-generated constructor stub
    }


    @Override
    public void setDataforTransactions(Map<String, String> transactionDetails) {
        // TODO Auto-generated method stub
        findElement(ACCOUNTNUMBER).sendKeys(DataTableUtils.getDataTableValue(transactionDetails, "ACCOUNT NUMBER"));
        pegaDriver.handleWaits().waitForElementClickable(ACQUIEREREFERENCENUMBER);
        findElement(ACQUIEREREFERENCENUMBER).click();
        findElement(ACQUIEREREFERENCENUMBER).sendKeys(DataTableUtils.getDataTableValue(transactionDetails, "Reference Number"));
        findElement(SEARCH_BUTTON).click();

    }

    @Override
    public void selectSingleTransaction() {
        // TODO Auto-generated method stub

        Assert.assertTrue(findElement(TRANSACTIONSUMMARY_TEXT).isVisible());
        findElement(TRANSACTION_CHECKBOX).click();
        pegaDriver.handleWaits().waitForElementClickable(CREATE_BUTTON);
        findElement(CREATE_BUTTON).click();
        pegaDriver.handleWaits().waitForDocStateReady();

    }

    @Override
    public void selectMultipleTransactions(int numberoftransactions) {
        // TODO Auto-generated method stub

    }

    @Override
    public ProcessPotentialDuplicates getProcessPotentialDuplicates() {
        // TODO Auto-generated method stub
        wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
        ProcessPotentialDuplicates stage = new ProcessPotentialDuplicatesImpl(wizard, wizard.getId());
        stage._setEnvironment(testEnv, wizard.getId());
        return stage;

    }


    @Override
    public QualifyDispute getQualifyDispute() {
        wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
        QualifyDispute stage = new QualifyDisputeImpl(wizard, wizard.getId());
        stage._setEnvironment(testEnv, wizard.getId());
        return stage;
    }


    @Override
    public VCRDisputeQuestionnaire getVCRDisputeQuestionnaire() {
        // TODO Auto-generated method stub
        wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
        VCRDisputeQuestionnaire stage = new VCRDisputeQuestionnaireImpl(wizard, wizard.getId());
        stage._setEnvironment(testEnv, wizard.getId());
        return stage;
    }


    @Override
    public void selectFraudClaim() {
        Assert.assertTrue(findElement(TRANSACTIONSUMMARY_TEXT).isVisible());
        findElement(FRAUD_CHECKBOX).click();
        findElement(TRANSACTION_CHECKBOX).click();
        pegaDriver.handleWaits().waitForElementClickable(CREATE_BUTTON);
        findElement(CREATE_BUTTON).click();
        pegaDriver.handleWaits().waitForDocStateReady();

    }


    @Override
    public QualifyFraud getQualifyFraud() {
        // TODO Auto-generated method stub
        wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
        QualifyFraud stage = new QualifyFraudImpl(wizard, wizard.getId());
        stage._setEnvironment(testEnv, wizard.getId());
        return stage;
    }


}
