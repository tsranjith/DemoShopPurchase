package com.test.products.base;

import com.test.products.testcontext.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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
    }

    public List<WebElement> findElements(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void waitInMilliSeconds(int milliSeconds) throws InterruptedException {
        Thread.sleep(milliSeconds);
    }

    public Object executeScript(String string, WebElement element) {
        RemoteWebDriver jse = driver;

        try {
            return jse.executeScript(string, new Object[]{element});
        } catch (StaleElementReferenceException var5) {
            return jse.executeScript(string, new Object[]{element});
        }
    }

}
