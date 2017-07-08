/*
 * Copyright (c) 2017. Vamsi Kuppa
 */

package com.iad.fs.sdissuer.pages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Created by krisv7 on 3/6/2017.
 */
public class RecallPreArbitrationImpl extends SDWorkObjectPageImpl implements RecallPreArbitration {

    public RecallPreArbitrationImpl(WebElement elmt, String elmtId) {
        super(elmt, elmtId);
    }

    @Override
    public void processRecallPreArbitration() {
        Assert.assertEquals(verifyElement(RECALLPREARBITRATION_LABEL), true);
        findElement(RECALLREASON_TEXTAREA).sendKeys("Recall Pre Arbitration is initiated");
        findElement(SUBMIT_BUTTON).click();
    }
}
