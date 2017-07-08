/*
 *
 * Created by Vamsi Kuppa on 3/2/2017.
 * Copyright (c) 2017. Vamsi Kuppa
 */

package com.iad.fs.sdissuer.pages;

import com.pega.ri.Wizard;
import org.openqa.selenium.WebElement;

public class ClaimImpl extends SDWorkObjectImpl implements Claim {

    private Wizard wizard;

    public ClaimImpl(WebElement elmt, String elmtId) {
        super(elmt, elmtId);
        // TODO Auto-generated constructor stub
    }

    /**
     * To search for transactions in the transaction summary
     *
     * @return SearchforTransactions Page Instance
     */
    @Override
    public SearchforTransactions getSearchforTransactions() {
        // TODO Auto-generated method stub
        wizard = pegaDriver.findWizard(pegaDriver.getActiveFrameId(false));
        SearchforTransactions stage = new SearchforTransactionsImpl(wizard, wizard.getId());
        stage._setEnvironment(testEnv, wizard.getId());
        return stage;

    }

	/*@Override
    public SelectLicenseCategoriesStage getSelectLicenseCategoriesStage() {
		// TODO Auto-generated method stub
		
		SelectLicenseCategoriesStage stage = new SelectLicenseCategoriesImpl(this, this.getId());
		stage._setEnvironment(testEnv, this.getId());
		return stage;
	}*/

//	@Override
/*	public SelectLicenseProducts getSelectLicenseProductsStage() {
        // TODO Auto-generated method stub
		SelectLicenseProducts stage = new SelectLicenseProductsImpl(this, this.getId());
		stage._setEnvironment(testEnv, this.getId());
		return stage;
	}*/

/*	@Override
	public SelectExpertiseDetails getSelectExpertiseDetailsStage() {
		// TODO Auto-generated method stub
		SelectExpertiseDetails stage = new SelectExpertiseDetailsImpl(this, this.getId());
		stage._setEnvironment(testEnv, this.getId());
		return stage;
	}*/

/*	@Override
	public SelectSupplementsStage getSelectSupplements() {
		// TODO Auto-generated method stub
		SelectSupplementsStage stage = new SelectSupplementsStageImpl(this, this.getId());
		stage._setEnvironment(testEnv, this.getId());
		return stage;
	}*/

/*	@Override
	public SelectUploadDocumentStage getSelectDocuments() {
		// TODO Auto-generated method stub
		SelectUploadDocumentStage stage = new SelectUploadDocumentStageImpl(this, this.getId());
		stage._setEnvironment(testEnv, this.getId());
		return stage;
	}*/

/*	@Override
	public SelectDisclosuresAndPaymentsStage getDisclosureAndPaymentStage() {
		// TODO Auto-generated method stub
		SelectDisclosuresAndPaymentsStage stage = new SelectDisclosuresAndPaymentsStageImpl(this, this.getId());
		stage._setEnvironment(testEnv, this.getId());
		return stage;
	}
*/


}
