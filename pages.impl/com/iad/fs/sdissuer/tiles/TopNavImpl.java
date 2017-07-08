package com.iad.fs.sdissuer.tiles;

import com.iad.fs.sdissuer.pages.Claim;
import com.iad.fs.sdissuer.pages.ClaimImpl;
import com.iad.fs.sdissuer.pages.ManualCase;
import com.iad.fs.sdissuer.pages.ManualCaseImpl;
import com.pega.TestEnvironment;
import com.pega.framework.PegaWebDriver;
import com.pega.ri.Wizard;
import org.openqa.selenium.By;

public class TopNavImpl extends com.pega.tiles.TopNavImpl implements TopNav {

    private PegaWebDriver pegaDriver;
    private TestEnvironment testEnv;

    public TopNavImpl(TestEnvironment testEnv) {
        super(testEnv);
        pegaDriver = testEnv.getPegaDriver();
        this.testEnv = testEnv;
        // TODO Auto-generated constructor stub
    }


    /**
     * To create a case from the Case Manager
     *
     * @param by Case Name should be passed
     */

    private void createCase(By by) {

        pegaDriver.findElement(CREATE_LINK).click();
        pegaDriver.findElement(by).click();
    }

    @Override
    public Claim createClaim() {
        // TODO Auto-generated method stub
        createCase(CLAIM_LINK);
        Wizard wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false)); //store the active frame id in wizard variable
        Claim caseType = new ClaimImpl(wizard, wizard.getId());
        caseType._setEnvironment(testEnv, wizard.getId());
        return caseType;
    }

    @Override
    public ManualCase createManualCase() {
        createCase(MANUALCASE_LINK);
        Wizard wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false)); //store the active frame id in wizard variable
        ManualCase caseType = new ManualCaseImpl(wizard, wizard.getId());
        caseType._setEnvironment(testEnv, wizard.getId());
        return caseType;

    }
}
