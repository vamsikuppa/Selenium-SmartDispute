/*
 * Copyright (c) 2017. Vamsi Kuppa
 */

package com.iad.fs.sdissuer.pages;

import com.pega.util.LocalizationUtil;
import org.openqa.selenium.By;

/**
 * Created by krisv7 on 3/5/2017.
 */
public interface InitiateCaseFiling extends SDWorkObjectPage {
    By INITIATECASEFILING_HEADER = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Initiate Case filing") + "')]");
    By ARBITRATONREASON_TEXTAREA = By.id("ArbitrationReason");
    By COMPLIANCEREASON_TEXTAREA = By.id("ComplianceReason");
    By ASSOCIATIONACKNOWLEDGEMENTHEADER_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Awaiting Association Acknowledgement") + "')]");
    By ISSUERLIABLE_RADIO = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Issuer") + "')]/preceding-sibling::input[@type='radio']");
    By ACQUIRERLIABLE_RADIO = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Acquirer") + "')]/preceding-sibling::input[@type='radio']");
    By ACQUIRERLIABLE_INFOTEXT = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("On submit, dispute will be resolved in cardholder's favor.") + "')]");
    By PENDINGCLOSUREASSIGNMENT_LINK = By.xpath("//a[contains(text(),'" + LocalizationUtil.getLocalizedWord("Pending-Closure") + "')]");
    By WITHDRAWCASEFILING_LINK = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Withdraw Case Filing") + "')]");
    By WITHDRAWCASEFILING_LABEL = By.xpath("//label[contains(text(),'" + LocalizationUtil.getLocalizedWord("Withdraw Case Filing") + "')]");
    By ARBITRATIONWITHDRAWREASON_TEXTAREA = By.id("ArborCompWithdrawalReason");
    By CASEFILEWITHDRAWHEADER_LABEL = By.xpath("//label[contains(text(),'" + LocalizationUtil.getLocalizedWord("Process case withdrawal") + "')]");
    By CASEFILINGAMOUNT_LABEL = By.xpath("//*[contains(text(),'" + LocalizationUtil.getLocalizedWord("Case filing amount") + "')]");

    void processInitiateArbitrationCaseFiling();

    void processAssociationAcknowledgement();

    void processIssuerLiableWOAssociationRuling();

    void processIssuerLiableCHLiableAssociationRuling();

    void processAcquirerLiableAssociationRuling();

    void processWithdrawArbitration();

    void processWOCaseFilingWithdraw();

    void processCHLiableCaseFilingWithdraw();

    void processInitiateCompliance();

    void processComplianceAppeal();

    void processWithdrawComplianceCHLiable();

    void processWithdrawComplianceWO();
}
