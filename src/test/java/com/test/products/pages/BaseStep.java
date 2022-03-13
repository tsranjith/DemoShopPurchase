package com.test.products.pages;

import com.test.products.testcontext.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseStep {

    RemoteWebDriver driver;

    public BaseStep(TestContext testContext) {
        this.driver = testContext.getDriver();
    }

    public WebElement waitForElementPresent(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public List<WebElement> findElements(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void waitInSeconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds);
    }

}
