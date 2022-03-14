package com.test.products.pages;

import com.test.products.base.BaseStep;
import com.test.products.testcontext.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BaseStep {


    public HomePage(TestContext testContext) {
        super(testContext);
    }

    public WebElement acceptCookies() {
        return waitForElementPresent(By.xpath("//*[@id=\"cc-window\"]/div[5]/a[1]"));
    }

    public WebElement productSelection(String productName) {
        return waitForElementPresent(By.xpath("//h2[contains(text(),'" + productName + "')]/ancestor::li//span[contains(text(), 'Add to wishlist')]"));
    }

    public WebElement clickWishlistLink() {
        return waitForElementPresent(By.xpath("//*[@id=\"blog\"]/div[3]/div[1]/div/div/div[3]/div[3]/a/i"));
    }

}
