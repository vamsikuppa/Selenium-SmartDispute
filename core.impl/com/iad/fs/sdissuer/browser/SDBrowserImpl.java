package com.iad.fs.sdissuer.browser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pega.TestEnvironment;

public class SDBrowserImpl extends com.pega.iad.BrowserImpl implements com.iad.fs.sdissuer.browser.SDBrowser {

	public static final String COPYRIGHT = "Copyright (c) 2014  Pegasystems Inc.";
	public static final String VERSION = "$Id: BrowserImpl.java 117333 2014-12-18 09:12:21Z SachinVellanki $";

	public SDBrowserImpl(TestEnvironment testEnv) {
		super(testEnv);
	}

	/**
	 * To logout from browser and wait for browser login page
	 */
	@Override
	public void logout() {
		//testEnv.getBrowser().switchToWindow("Pega Case Manager Portal");
		pegaDriver.switchTo().defaultContent();
		pegaDriver.findElement(LOG_OUT_BUTTON).click();
		pegaDriver.findElement(LOG_OFF_XPATH).click(false);
	}
}
