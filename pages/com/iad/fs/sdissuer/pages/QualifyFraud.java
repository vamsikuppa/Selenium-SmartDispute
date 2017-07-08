package com.iad.fs.sdissuer.pages;

import com.pega.util.LocalizationUtil;
import org.openqa.selenium.By;

public interface QualifyFraud extends SDWorkObjectPage {

    By FRAUD_LABEL = By.xpath("//label[contains(text(), '" + LocalizationUtil.getLocalizedWord("Qualify fraud") + "')]");
    By CARDSTATUS_DROPDOWN = By.id("FraudTypeApp");
    By POSESSIONCARD_RADIO = By.id("CardPossessionFraudNo");
    By CARDPIN_RADIO = By.id("CardOrPinFraudNo");
    By MERCHANTRECOGNIZE_RADIO = By.id("CanRecognizeMerchantNo");
    By CHAUTHORIZE_RADIO = By.id("CardholderDidNotAuthorizeOrParticipateNo");
    By CONTINUEFRAUD = By.id("IsFraudDisputeYes");

    void processQualifyFraudDispute();

    void processCSRTimeFrameExpiryWO();

    void processCSRTimeFrameExpiryCHLiable();

    void processCSRTimeFrameExpiryContinueDispute();

    void extractClaimId();

    void extractDisputeId();

}
