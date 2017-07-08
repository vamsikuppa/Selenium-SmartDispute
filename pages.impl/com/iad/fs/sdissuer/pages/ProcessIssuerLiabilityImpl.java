package com.iad.fs.sdissuer.pages;

import com.pega.iad.utils.DataTableUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Map;

public class ProcessIssuerLiabilityImpl extends SDWorkObjectPageImpl implements ProcessIssuerLiability {

    public ProcessIssuerLiabilityImpl(WebElement elmt, String elmtId) {
        super(elmt, elmtId);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void validateTimeFrameExpiryNoException() {
        Assert.assertTrue(verifyElement(PROCESSISSUERLIABILTY_LABEL));
        Assert.assertFalse(verifyElement(EXCEPTIONS_RADIO));
    }

    @Override
    public CollaborationRequest takeInitiateCollaborationAction() {
        Assert.assertTrue(verifyElement(PROCESSISSUERLIABILTY_LABEL));
        findElement(OTHERACTIONS_BUTTON).click();
        findElement(INITIATECOLLABORATOIN_LINK).click();
        wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
        CollaborationRequest stage = new CollaborationRequestImpl(wizard, wizard.getId());
        stage._setEnvironment(testEnv, wizard.getId());
        return stage;
    }

    @Override
    public void processMultiPronged(String option1, String option2, Map<String, String> amountdetails) {
        Assert.assertTrue(verifyElement(PROCESSISSUERLIABILTY_LABEL));
        takeMultiProngedAction(option1, option2);
        pegaDriver.handleWaits().waitForElementClickable(WRITEOFFAMOUNT_TEXT);
        findElement(WRITEOFFAMOUNT_TEXT).click();
        findElement(WRITEOFFAMOUNT_TEXT).sendKeys(DataTableUtils.getDataTableValue(amountdetails, "Writeoff amount"));
        pegaDriver.handleWaits().waitForElementClickable(CARDHOLDERLIABLEAMOUNT_TEXT);
        findElement(CARDHOLDERLIABLEAMOUNT_TEXT).click();
        findElement(CARDHOLDERLIABLEAMOUNT_TEXT).sendKeys(DataTableUtils.getDataTableValue(amountdetails, "Cardholder liable amount"));
        findElement(SUBMIT_BUTTON).click();
        //Assert.assertTrue(verifyElement(FINALCREDITLETTER));
        assertCompareIgnoreCaseStrings(findElement(ATTACHMENTS_SECTION).getText(), "Final credit letter");
    }

    @Override
    public void processExceptionsAction() {
        Assert.assertTrue(verifyElement(PROCESSISSUERLIABILTY_LABEL));
        findElement(EXCEPTIONS_RADIO).click();
        findElement(SUBMIT_BUTTON).click();
    }
}