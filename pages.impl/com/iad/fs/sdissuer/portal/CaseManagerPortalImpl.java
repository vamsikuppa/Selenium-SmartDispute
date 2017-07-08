package com.iad.fs.sdissuer.portal;


import com.iad.fs.sdissuer.pages.*;
import com.iad.fs.sdissuer.tiles.TopNav;
import com.pega.TestEnvironment;
import com.pega.framework.PegaWebDriver;
import com.pega.iad.utils.WebTableUtils;
import com.pega.page.PortalImpl;
import com.pega.ri.Wizard;
import com.pega.util.DataUtil;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CaseManagerPortalImpl extends PortalImpl implements CaseManagerPortal {

    private TopNav topNav;
    private PegaWebDriver pegaDriver;
    private Wizard wizard;


    public CaseManagerPortalImpl(TestEnvironment testEnv) {
        super(testEnv);
        pegaDriver = testEnv.getPegaDriver();
        this.testEnv = testEnv;
        // TODO Auto-generated constructor stub
    }

    @Override
    public TopNav getTopNav() {
        if (topNav == null) {
            topNav = new com.iad.fs.sdissuer.tiles.TopNavImpl(testEnv);
        }
        return topNav;
    }

    @Override
    public SearchforTransactions getSelectforTransactionspage() {
        // TODO Auto-generated method stub
        wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
        return new SearchforTransactionsImpl(wizard, wizard.getId());
    }

    @Override
    public boolean processCustomerIntiatedWB() {
        // TODO Auto-generated method stub
        wizard = findWizard(pegaDriver.getActiveFrameId(false));
        wizard.findElement(CUSTOMERCLAIMWB).click();
        //pegaDriver.handleWaits().waitForElementVisibility(CUSTOMERINITIATEDLABEL);
        //pegaDriver.getActiveFrameId(true);
        wizard.findElement(FILTERLINK).click();
        wizard.findElement(DISPUTESEARCHTEXT).click();
        wizard.findElement(DISPUTESEARCHTEXT).sendKeys(DataUtil.readFileToString("case_id.txt"));
        wizard.findElement(DISPUTESEARCHAPPLYBUTTON).click();
        try {
            WebTableUtils.clickFromTableByText(wizard.findElement(DISPUTEIDTABLE), DataUtil.readFileToString("case_id.txt"), 2);
        } catch (ArrayIndexOutOfBoundsException e) {
            Reporter.log("Unable to filter the Dispute/Claim id from the customer initiated work basket");
        } catch (Exception e) {
            Reporter.log("Generic exception occurred. More debugging is required");
        }
        wizard = findWizard(pegaDriver.getActiveFrameId(false));
        if (wizard.verifyElement(BACKEND_PROCESSDUPLICATESHEADER)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean processFraudWB() {
        // TODO Auto-generated method stub
        wizard = findWizard(pegaDriver.getActiveFrameId(false));
        wizard.findElement(FRAUDWB).click();
        //pegaDriver.handleWaits().waitForElementVisibility(CUSTOMERINITIATEDLABEL);
        //pegaDriver.getActiveFrameId(true);
        wizard.findElement(FILTERLINK).click();
        wizard.findElement(DISPUTESEARCHTEXT).click();
        wizard.findElement(DISPUTESEARCHTEXT).sendKeys(DataUtil.readFileToString("case_id.txt"));
        wizard.findElement(DISPUTESEARCHAPPLYBUTTON).click();

        WebTableUtils.clickFromTableByText(wizard.findElement(DISPUTEIDTABLE), DataUtil.readFileToString("case_id.txt"), 2);
        //clickFromTableByText(2);
        /*List<WebElement> tablerows = findElements(DISPUTEIDTABLEROWS_LIST);
        List<WebElement> selectedrows = new ArrayList<WebElement>();
        Iterator<WebElement> itr1 = tablerows.iterator();
        //Finding the table row
        while (itr1.hasNext()) {
            WebElement tablerow = itr1.next();
            if (tablerow.getText().contains(DataUtil.readFileToString("case_id.txt"))) {
                selectedrows.add(tablerow);
            }
        }
        //Finding the table column
        List<WebElement> tablecolumns = selectedrows.get(0).findElements(By.xpath("following::td"));
        List<WebElement> selectedcolumns = new ArrayList<WebElement>();
        Iterator<WebElement> itr2 = tablecolumns.iterator();
        while (itr2.hasNext()) {
            WebElement tablecolumn = itr2.next();
            if (tablecolumn.getText().contains(DataUtil.readFileToString("case_id.txt"))) {
                selectedcolumns.add(tablecolumn);
                break;
            }
        }*/

        wizard = findWizard(pegaDriver.getActiveFrameId(false));
        //checking for review suggested dispute category header
        Assert.assertTrue(wizard.verifyElement(REVIEWSUGGESTEDDISPUTECATEGORY_HEADER));
        //checking for review suggested dispute category value
        Assert.assertTrue(StringUtils.containsIgnoreCase(wizard.findElement(REVIEWSUGGESTEDDISPUTECATEGORY_LABEL).getText(), "Fraud"));
        wizard.findElement(SUBMIT_BUTTON).click();
        wizard = findWizard(pegaDriver.getActiveFrameId(false));
        if (wizard.verifyElement(PROCESSPOTENTIALDUPLICATESASSIGNMENTLINK)) {
            return true;
        } else {
            return false;
        }
    }

    /*public void clickFromTableByText(int columnNumber) {
        List<WebElement> tablerows = findElements(DISPUTEIDTABLEROWS_LIST);
        List<WebElement> selectedrows = new ArrayList<WebElement>();
        Iterator<WebElement> itr1 = tablerows.iterator();
        //Finding the table row
        while (itr1.hasNext()) {
            WebElement tablerow = itr1.next();
            if (tablerow.getText().contains(DataUtil.readFileToString("case_id.txt"))) {
                selectedrows.add(tablerow);
            }
        }

        WebElement clickableElement = ((WebElement) selectedrows.get(0)).findElement(By.xpath("/following::td[" + columnNumber + "]//a"));
        clickableElement.click();
    }*/

    @Override
    public ProcessPotentialDuplicates getProcessPotentialDuplicates() {
        wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
        ProcessPotentialDuplicates stage = new ProcessPotentialDuplicatesImpl(wizard, wizard.getId());
        stage._setEnvironment(testEnv, wizard.getId());
        return stage;
    }

    @Override
    public ProcessIssuerLiability getTimeFrameExpiryFlow() {
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
}
