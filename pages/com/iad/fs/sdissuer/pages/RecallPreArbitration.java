/*
 * Copyright (c) 2017. Vamsi Kuppa
 */

package com.iad.fs.sdissuer.pages;

import com.pega.util.LocalizationUtil;
import org.openqa.selenium.By;

/**
 * Created by krisv7 on 3/6/2017.
 */
public interface RecallPreArbitration extends SDWorkObjectPage {

    By RECALLPREARBITRATION_LABEL = By.xpath("//label[contains(text(),'" + LocalizationUtil.getLocalizedWord("Recall Pre-arbitration") + "')]");
    By RECALLREASON_TEXTAREA = By.id("RecallReason");

    void processRecallPreArbitration();

}
