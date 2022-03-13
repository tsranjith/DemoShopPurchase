package com.test.products.pages;

import com.test.products.testcontext.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SignInPage extends BaseStep {

    public SignInPage(TestContext testContext) {
        super(testContext);
    }

    public WebElement signInLink() {
        return waitForElementPresent(By.xpath("//*[@class='login']"));
    }

    public WebElement username() {
        return waitForElementPresent(By.id("email"));
    }

    public WebElement password() {
        return waitForElementPresent(By.id("passwd"));
    }

    public WebElement signIn() {
        return waitForElementPresent(By.id("SubmitLogin"));
    }

    public WebElement personalInfo() {
        return waitForElementPresent(By.xpath("//*[@title='View my customer account']"));
    }

    public WebElement personalInfoTab() {
        return waitForElementPresent(By.xpath("//*[text()='My personal information']"));
    }

    public WebElement firstName() {
        return waitForElementPresent(By.id("firstname"));
    }

    public WebElement currentPassword() {
        return waitForElementPresent(By.name("old_passwd"));
    }

    public WebElement newPassword() {
        return waitForElementPresent(By.name("passwd"));
    }

    public WebElement confirmPassword() {
        return waitForElementPresent(By.name("confirmation"));
    }

    public WebElement save() {
        return waitForElementPresent(By.name("submitIdentity"));
    }
}
