package com.iad.fs.sdissuer.pages;

import com.pega.util.LocalizationUtil;
import org.openqa.selenium.By;

import java.util.Map;

public interface ProcessIssuerLiability extends SDWorkObjectPage {

    By PROCESSISSUERLIABILTY_LABEL = By.xpath("//label[contains(text(),'" + LocalizationUtil.getLocalizedWord("Process issuer liability") + "')]");
    By EXCEPTIONS_RADIO = By.id("VCRIssuerLiableResolutionEXCEP");
    //By WRITEOFF_RADIO=By.id("VCRIssuerLiableResolutionWO");
    //By CARDHOLDERLIABLE_RADIO=By.id("VCRIssuerLiableResolutionCH");
    By WRITEOFFAMOUNT_TEXT = By.id("IssliabMPWOAmt");
    By CARDHOLDERLIABLEAMOUNT_TEXT = By.id("IssliabMPCHAmt");


    void validateTimeFrameExpiryNoException();

    CollaborationRequest takeInitiateCollaborationAction();

    void processMultiPronged(String option1, String option2, Map<String, String> amountdetails);

    void processExceptionsAction();


}
