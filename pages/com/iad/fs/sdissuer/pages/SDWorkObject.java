package com.iad.fs.sdissuer.pages;

import org.openqa.selenium.By;

import com.pega.iad.page.IADWorkObject;
/**
 * This Interface is a place holder and extending IAD Workobject and its page implementation
 * @author  Vamsi Kuppa
 * @since  02 Feb 2017
 *
 * */
public interface SDWorkObject extends IADWorkObject{

	By WORK_OBJECT_ID = By.xpath("//span[@class='case_id']|//span[@class='work_identifier']");
	
	
}
