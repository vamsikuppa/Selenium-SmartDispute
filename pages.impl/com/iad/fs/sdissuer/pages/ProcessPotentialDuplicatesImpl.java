package com.iad.fs.sdissuer.pages;

import org.openqa.selenium.WebElement;

public class ProcessPotentialDuplicatesImpl extends SDWorkObjectPageImpl implements ProcessPotentialDuplicates {

    public ProcessPotentialDuplicatesImpl(WebElement elmt, String elmtId) {
        super(elmt, elmtId);
        // TODO Auto-generated constructor stub
    }


    @Override
    public QualifyDispute processDuplicatesAssignment() {
        // TODO Auto-generated method stub
        pegaDriver.handleWaits().waitForElementVisibility(PROCESSPOTENTIALDUPLICATESHEADER);
        pegaDriver.handleWaits().waitForElementClickable(DUPLICATESCOMMENTSTEXTAREA);
        findElement(DUPLICATESCOMMENTSTEXTAREA).click();
        findElement(DUPLICATESCOMMENTSTEXTAREA).sendKeys("No Duplicates");
        findElement(SUBMIT_BUTTON).click();
        wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
        QualifyDispute stage = new QualifyDisputeImpl(wizard, wizard.getId());
        stage._setEnvironment(testEnv, wizard.getId());
        return stage;
    }

    @Override
    public QualifyDispute getQualifyDispute() {
        wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
        QualifyDispute stage = new QualifyDisputeImpl(wizard, wizard.getId());
        stage._setEnvironment(testEnv, wizard.getId());
        return stage;
    }


    @Override
    public void processCSRDuplicatesAssignment() {
        // TODO Auto-generated method stub
        //pegaDriver.handleWaits().waitForElementVisibility(CSR_PRIORDISPUTELABEL);
        findElement(CSR_PRIORDISPUTERADIO).click();
        pegaDriver.handleWaits().waitForElementVisibility(CSR_NEXTBUTTON);
        findElement(CSR_NEXTBUTTON).click();
        /*wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
        QualifyDispute stage = new QualifyDisputeImpl(wizard, wizard.getId());
		stage._setEnvironment(testEnv, wizard.getId());
		return stage;*/

    }


    @Override
    public void processBackendDuplicatesAssignment() {
        // TODO Auto-generated method stub
        pegaDriver.handleWaits().waitForElementVisibility(PROCESSPOTENTIALDUPLICATESHEADER);
        if (verifyElement(DUPLICATESCOMMENTSTEXTAREA)) {
            pegaDriver.handleWaits().waitForElementClickable(DUPLICATESCOMMENTSTEXTAREA);
            findElement(DUPLICATESCOMMENTSTEXTAREA).click();
            findElement(DUPLICATESCOMMENTSTEXTAREA).sendKeys("No Duplicates");
        }
        findElement(SUBMIT_BUTTON).click();
        /*wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
        VCRDisputeQuestionnaire stage = new VCRDisputeQuestionnaireImpl(wizard, wizard.getId());
		stage._setEnvironment(testEnv, wizard.getId());
		return stage;
		*/
    }

    @Override
    public ProcessIssuerLiability getTimeFrameExpiry() {
        if (verifyElement(TIMEFRAMEEXPIRY_LINK)) {
            findElement(TIMEFRAMEEXPIRY_LINK).click();
        }
        wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
        ProcessIssuerLiability stage = new ProcessIssuerLiabilityImpl(wizard, wizard.getId());
        stage._setEnvironment(testEnv, wizard.getId());
        return stage;
    }

    @Override
    public VCRDisputeQuestionnaire getVCRDisputeQuestionnaire() {
        wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
        VCRDisputeQuestionnaire stage = new VCRDisputeQuestionnaireImpl(wizard, wizard.getId());
        stage._setEnvironment(testEnv, wizard.getId());
        return stage;
    }


    @Override
    public QualifyFraud getQualifyFraud() {
        // TODO Auto-generated method stub
        wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
        QualifyFraud stage = new QualifyFraudImpl(wizard, wizard.getId());
        stage._setEnvironment(testEnv, wizard.getId());
        return stage;
    }

}
