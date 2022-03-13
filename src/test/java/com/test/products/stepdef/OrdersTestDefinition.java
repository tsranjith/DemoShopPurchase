package com.test.products.stepdef;

import com.test.products.pages.CartPage;
import com.test.products.pages.HomePage;
import com.test.products.pages.SignInPage;
import com.test.products.pages.WishlistPage;
import com.test.products.testcontext.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdersTestDefinition {

    private static final String URL = "https://testscriptdemo.com/";
    TestContext testContext;
    HomePage homePage;
    WishlistPage wishlistPage;
    CartPage cartPage;

    int lowestPrice;
    String lowestProductName;

    public OrdersTestDefinition(TestContext testContext) {
        this.testContext = testContext;
        homePage = new HomePage(testContext);
        wishlistPage = new WishlistPage(testContext);
        cartPage = new CartPage(testContext);
    }

    public void openDriver() {
        testContext.getDriver().get(URL);
        testContext.getDriver().manage().window().maximize();
    }


    @After
    public void closeDriver() {
        testContext.getDriver().quit();
    }

    @Given("I add four different products to my wish list")
    public void iAddFourDifferentProductsToMyWishList() throws InterruptedException {
        openDriver();
        homePage.acceptCookies().click();
        String[] productNames = {"Bikini", "Hard top", "Women", "Single Shirt"};
        for (String product : productNames) {
            homePage.waitInSeconds(3);
            homePage.productSelection(product).click();
        }
    }

    @When("I view my wishlist table")
    public void iViewMyWishlistTable() {
        homePage.clickWishlistLink().click();
        wishlistPage.viewWishlistTable().isDisplayed();
    }

    @Then("I find total four selected items in my Wishlist")
    public void iFindTotalFourSelectedItemsInMyWishlist() {
        Assert.assertEquals(wishlistPage.selectedItems().size() - 1, 4);
    }

    @When("I search for lowest price product")
    public void iSearchForLowestPriceProduct() {
        List<Integer> productsPrice = new ArrayList<Integer>();
        for (WebElement itemPrice : wishlistPage.productPrice()) {
            productsPrice.add(Integer.parseInt(itemPrice.getText().replace("£", "").replace(".00", "")));
        }
        lowestPrice = productsPrice.indexOf(Collections.min(productsPrice));
    }

    @And("I am able to add the lowest price item to my cart")
    public void iAmAbleToAddTheLowestPriceItemToMyCart() {
        lowestProductName = wishlistPage.itemName(lowestPrice).getText();
        wishlistPage.addToCart(lowestPrice).click();
    }

    @Then("I am able to verify the item in my cart")
    public void iAmAbleToVerifyTheItemInMyCart() {
        wishlistPage.viewCart().click();
        Assert.assertEquals(lowestProductName,cartPage.getProductName().getText());
    }
}

