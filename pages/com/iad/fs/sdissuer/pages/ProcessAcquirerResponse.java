package com.iad.fs.sdissuer.pages;

import com.pega.util.LocalizationUtil;
import org.openqa.selenium.By;

import java.util.Map;

/**
 * This Interface is about Process acquirer response page and its web elements and from this page user can take initiate-
 * Pre Arbitration action
 *
 * @author Vamsi Kuppa
 * @since 02 Feb 2017
 */

public interface ProcessAcquirerResponse extends SDWorkObjectPage {
    By INITIATE_PREARBITRATION_RADIO = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Initiate Pre-arbitration") + "')]/preceding-sibling::input[@type='radio']");
    By ACQUIRERRESPONSE_LABEL = By.xpath("//*[contains(textr(),'" + LocalizationUtil.getLocalizedWord("Acquirer response") + "')]");
    By ACQUIRERRESPONSE_IND = By.xpath("//*[contains(textr(),'" + LocalizationUtil.getLocalizedWord("Acquirer response") + "')]//following::*[contains(text(),'" + LocalizationUtil.getLocalizedWord("%s") + "')]");

    void takeInitPreArbAction();

    InitPreArb getInitPreArb();

    void processAcceptFullAcquirerResponse(Map<String, String> respdetails);

    void processAcceptPartialCHLiableAcquirerResponse(Map<String, String> respdetails);

    void processAcceptPartialWOAcquirerResponse(Map<String, String> respdetails);

}
