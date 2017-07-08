package com.iad.fs.sdissuer;

import com.google.inject.Inject;
import com.iad.fs.sdissuer.browser.SDBrowserImpl;
import com.iad.fs.sdissuer.portal.CaseManagerPortal;
import com.pega.TestEnvironment;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.runtime.java.guice.ScenarioScoped;

/**
 *
 */
@ScenarioScoped
public class MyBrowser extends SDBrowserImpl {

    @Inject
    public MyBrowser(TestEnvironment testEnv) {
        super(testEnv);
    }

	
	/*
     * @Given(
	 * "^a user is logged into designer studio with \"([^\"]*)\" and \"([^\"]*)\"$"
	 * ) public void loginToDesignerStudio(String userName, String password){
	 * open(); login(userName,password); }
	 */

    @Given("^a user is logged into application as \"([^\"]*)\" and \"([^\"]*)\"$")
    public void a_user_is_logged_into_application_with_as_and(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        open();
        login(arg1, arg2);
    }


    @When("^user logout from user portal$")
    public void logout_from_user_portal() {
        logout();
    }

	/*
	 * @Override public DesignerStudio getDesignerStudio(){ return new
	 * com.pv.portal.DesignerStudioImpl(testEnv); }
	 */
	/*
	 * public PVInboundPortal getPVInboundPortal(){ return new
	 * com.pv.portal.PVInboundPortalImpl(testEnv); }
	 */

    public CaseManagerPortal getcasemanagerportal() {
        return new com.iad.fs.sdissuer.portal.CaseManagerPortalImpl(testEnv);
    }

}
