package com.client.BookShop_KK.Module.BusinessAndManagement;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.client.BookShopSystem.BaseUtility.BaseClass;

public class BusinessAndManagement extends BaseClass {
	@Test(groups = "integration")
	public void businessAndManagementLinkAndProductListingPageTest() {
		 String value = exlutil.getDataFromExcelSheet("Kaif Khan", 6, 0);
		hp.getSideBarText(value).click();
//		hp.getchildAndTeenLink().click();
//		Assert.assertEquals(text.toLowerCase(), n.toLowerCase());
		Assert.assertEquals(plp.getHeading().isDisplayed(), true);
		plp.getFirstBook().isDisplayed();
		WebElement book = plp.getFirstBook();
		int priceAfterDiscount =plp.getPriceAfterDiscount(book);
    	Assert.assertTrue(priceAfterDiscount>0);
		plp.getActualPrice().isDisplayed();
	}

}
