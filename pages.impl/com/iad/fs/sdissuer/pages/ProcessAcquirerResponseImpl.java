package com.iad.fs.sdissuer.pages;

import com.pega.iad.utils.DataTableUtils;
import com.pega.iad.utils.IADUtils;
import com.pega.ri.Wizard;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Map;

public class ProcessAcquirerResponseImpl extends SDWorkObjectPageImpl implements ProcessAcquirerResponse {

    private Wizard wizard;

    public ProcessAcquirerResponseImpl(WebElement elmt, String elmtId) {
        super(elmt, elmtId);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void takeInitPreArbAction() {
        // TODO Auto-generated method stub
        findElement(INITIATE_PREARBITRATION_RADIO).click();
        findElement(SUBMIT_BUTTON).click();

    }

    @Override
    public InitPreArb getInitPreArb() {
        wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
        InitPreArb stage = new InitPreArbImpl(wizard, wizard.getId());
        stage._setEnvironment(testEnv, wizard.getId());
        return stage;
    }

    @Override
    public void processAcceptFullAcquirerResponse(Map<String, String> respdetails) {
        Assert.assertTrue(verifyElement(IADUtils.parameterizeBy(ACQUIRERRESPONSE_IND, DataTableUtils.getDataTableValue(respdetails, "Acquirer response"))));
        findElement(SUBMIT_BUTTON).click();
    }

    @Override
    public void processAcceptPartialCHLiableAcquirerResponse(Map<String, String> respdetails) {
        Assert.assertTrue(verifyElement(IADUtils.parameterizeBy(ACQUIRERRESPONSE_IND, DataTableUtils.getDataTableValue(respdetails, "Acquirer response"))));
        takeChLiableAction();
    }

    @Override
    public void processAcceptPartialWOAcquirerResponse(Map<String, String> respdetails) {
        Assert.assertTrue(verifyElement(IADUtils.parameterizeBy(ACQUIRERRESPONSE_IND, DataTableUtils.getDataTableValue(respdetails, "Acquirer response"))));
        takeWriteOffAction();
    }
}



