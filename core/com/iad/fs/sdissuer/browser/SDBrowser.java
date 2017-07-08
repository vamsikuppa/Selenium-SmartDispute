package com.iad.fs.sdissuer.browser;

import org.openqa.selenium.By;

import com.pega.util.LocalizationUtil;

public interface SDBrowser extends com.pega.iad.Browser {

	By LOG_OUT_BUTTON = By.xpath("//*[@data-test-id='px-opr-image-ctrl']");
	//By LOG_OUT_BUTTON_DESIGNER_STUDIO = By.xpath("//i[@data-test-id='px-opr-image-ctrl' and //@title='CLF System Administrator']");
	By LOG_OFF_XPATH = By.xpath("//*[text()='"+LocalizationUtil.getLocalizedWord("Log off")+"']");
}
