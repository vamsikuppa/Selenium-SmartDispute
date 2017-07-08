/*
 * Copyright (c) 2017. Vamsi Kuppa
 */

package com.iad.fs.sdissuer.pages;

import com.pega.iad.utils.DataTableUtils;
import com.pega.iad.utils.IADUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Map;

/**
 * Created by krisv7 on 3/4/2017.
 */
public class ProcessPreArbResponseImpl extends SDWorkObjectPageImpl implements ProcessPreArbResponse {

    public ProcessPreArbResponseImpl(WebElement elmt, String elmtId) {
        super(elmt, elmtId);
    }

    @Override
    public void takeInitArbAction() {
        findElement(INITIATEARBITRATION_RADIO).click();
        findElement(SUBMIT_BUTTON).click();
        if (verifyElement(INITIATECASEFILING_LINK)) {
            findElement(INITIATECASEFILING_LINK).click();
        }
    }

    @Override
    public void processPreArbResponseAcquirerLiable(Map<String, String> tabdetails) {
        boolean acquirerresponsedisplayed = findElement(IADUtils.parameterizeBy(PREARBRESPONSE_TEXT, DataTableUtils.getDataTableValue(tabdetails, "Acquirer response"))).isDisplayed();
        Assert.assertTrue(acquirerresponsedisplayed);
        findElement(SUBMIT_BUTTON).click();
    }

    @Override
    public void processPreArbResponseCHLiableAcceptPartial(Map<String, String> tabdetails) {
        //   pegaDriver.handleWaits().waitForElementVisibility(PREARBRESPONSE_HEADER);
        boolean acquirerresponsedisplayed = findElement(IADUtils.parameterizeBy(PREARBRESPONSE_TEXT, DataTableUtils.getDataTableValue(tabdetails, "Acquirer response"))).isDisplayed();
        Assert.assertTrue(acquirerresponsedisplayed);
        takeChLiableAction();
    }

    @Override
    public void processPreArbResponseWOAcceptPartial(Map<String, String> tabdetails) {
        pegaDriver.handleWaits().waitForElementVisibility(PREARBRESPONSE_HEADER);
        boolean acquirerresponsedisplayed = findElement(IADUtils.parameterizeBy(PREARBRESPONSE_TEXT, DataTableUtils.getDataTableValue(tabdetails, "Acquirer response"))).isDisplayed();
        Assert.assertTrue(acquirerresponsedisplayed);
        takeWriteOffAction();
    }


    @Override
    public InitiateCaseFiling getInitiateCaseFiling() {
        wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
        InitiateCaseFiling stage = new InitiateCaseFilingImpl(wizard, wizard.getId());
        stage._setEnvironment(testEnv, wizard.getId());
        return stage;
    }
}
