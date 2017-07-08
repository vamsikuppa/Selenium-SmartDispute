package com.iad.fs.sdissuer.tiles;

import com.iad.fs.sdissuer.pages.Claim;
import com.iad.fs.sdissuer.pages.ManualCase;
import org.openqa.selenium.By;

//import com.pv.inbound.page.SafetySignalMgmtCase;

public interface TopNav extends com.pega.tiles.TopNav {

    By CREATE_LINK = By.linkText("Create");
    By CLAIM_LINK = By.xpath("//a[@role='menuitem']//following::span[contains(text(),'Claim')]");
    By MANUALCASE_LINK = By.xpath("//a[@role='menuitem']//following::span[contains(text(),'Manual Case')]");

    Claim createClaim();

    ManualCase createManualCase();

}


