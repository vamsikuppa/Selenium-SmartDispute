/*
 * Copyright (c) 2017. Vamsi Kuppa
 */

package com.iad.fs.sdissuer.pages;

import com.pega.util.LocalizationUtil;
import org.openqa.selenium.By;

import java.util.Map;

/**
 * Created by krisv7 on 3/4/2017.
 */
public interface ProcessPreArbResponse extends SDWorkObjectPage {

    By INITIATEARBITRATION_RADIO = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Initiate Arbitration") + "')]/preceding-sibling::input[@type='radio']");

    By PREARBRESPONSE_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Select appropriate Pre-arbitration response") + "')]");
    By PREARBRESPONSE_TEXT = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Select appropriate Pre-arbitration response") + "')]//following::*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]");
    By PREARBRESPONSE_HEADER = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Process Pre-arbitration response from Acquirer") + "')]");

    void takeInitArbAction();

    void processPreArbResponseAcquirerLiable(Map<String, String> tabdetails);

    void processPreArbResponseCHLiableAcceptPartial(Map<String, String> tabdetails);

    void processPreArbResponseWOAcceptPartial(Map<String, String> tabdetails);

    InitiateCaseFiling getInitiateCaseFiling();

}
