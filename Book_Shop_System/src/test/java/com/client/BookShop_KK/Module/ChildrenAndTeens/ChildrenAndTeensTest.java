package com.client.BookShop_KK.Module.ChildrenAndTeens;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.client.BookShopSystem.BaseUtility.BaseClass;

public class ChildrenAndTeensTest extends BaseClass {
	
	@Test(groups = "integration")
	public void DemochildAndTeensLinkAndProductListingPageTest() {
		 String value = exlutil.getDataFromExcelSheet("Kaif Khan", 4, 0);
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

	
	
	@Test(groups = "integration",dataProvider = "categoryNamesData")
	public void childAndTeensLinkAndProductListingPageTest(String name,String n) {
		hp.getSideBarText(name).click();
//		hp.getchildAndTeenLink().click();
//		Assert.assertEquals(text.toLowerCase(), n.toLowerCase());
		Assert.assertEquals(plp.getHeading().isDisplayed(), true);
		plp.getFirstBook().isDisplayed();
		WebElement book = plp.getFirstBook();
		int priceAfterDiscount =plp.getPriceAfterDiscount(book);
    	Assert.assertTrue(priceAfterDiscount>0);
		plp.getActualPrice().isDisplayed();
	}
	@DataProvider(name = "categoryNamesData")
	public Object[][] categoryNamesData() {
		// You have data from row 4 to 8 → total 5 rows (4, 5, 6, 7)
	    int startRow = 4;
	    int endRow = 7;
	    int totalRows = endRow - startRow + 1;
	    Object[][] data = new Object[totalRows][2];
	    // Loop through rows and fetch data
	    for (int i = 0; i < totalRows; i++) {
	        String value = exlutil.getDataFromExcelSheet("Kaif Khan", startRow + i, 0);
	        String value2 = exlutil.getDataFromExcelSheet("Kaif Khan", startRow + i, 1);
	        data[i][1]=value2;
	        data[i][0] = value;   
	    } 
	    return data;
	}
}
