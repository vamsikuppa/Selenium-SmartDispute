/*
 * Copyright (c) 2017. Vamsi Kuppa
 */

package com.iad.fs.sdissuer.pages;

import com.pega.util.LocalizationUtil;
import org.openqa.selenium.By;

/**
 * Created by krisv7 on 3/3/2017.
 */
public interface InitPreArb extends SDWorkObjectPage {
    By INITIATEPREARB_LABEL = By.xpath("//label[contains(text(),'" + LocalizationUtil.getLocalizedWord("Initiate Pre-arbitration") + "')]");
    By INITPREARBREASON_TEXTAREA = By.id("PreArbReason");
    By PREARBNOTES_TEXTAREA = By.id("PreArbNotes");
    By INITIATEPREARBREASON_DROPDOWN = By.id("InitiatePreArbReason");
    By CONTINUEDISPUTE_TEXTAREA = By.id("ExplainContinuingDispute");
    By RECALLPREARBITRATION_LINK = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Recall Pre-arbitration") + "')]");
    By ISSUERCERTIFESCEQUESTION_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Has the cardholder been contacted to review the compelling evidence, and does the cardholder want to continue the dispute?") + "')]");
    By ISSUERCERTIFIESCEYES_RADIO = By.id("IssuerCertifiesCardholderCompEvidenceY");
    By CARDHOLDERCONTINUESDISPUTE_TEXTAREA = By.id("CardholderContinuesDispute");
    By CREDITPROCESSEDDATE_TEXT = By.id("CreditProcessedDate");


    void processInitPreArb();

    ProcessPreArbResponse getProcessPreArbResponse();

    RecallPreArbitration getRecallPreArbitration();

    void processAwaitingPreArbResponse();

}
