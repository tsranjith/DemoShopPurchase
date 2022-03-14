package com.test.products.pages;

import com.test.products.base.BaseStep;
import com.test.products.testcontext.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartPage extends BaseStep {

    public CartPage(TestContext testContext) {
        super(testContext);
    }

    public WebElement getProductName(){
        return waitForElementPresent(By.xpath("//table//tr/td[3]/a"));
    }
}
