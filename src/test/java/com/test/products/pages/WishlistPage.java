package com.test.products.pages;

import com.test.products.testcontext.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WishlistPage extends BaseStep {

    public WishlistPage(TestContext testContext) {
        super(testContext);
    }

    public WebElement viewWishlistTable(){
        return waitForElementPresent(By.xpath("//*[@id=\"yith-wcwl-form\"]/table"));
    }

    public List<WebElement> selectedItems(){
        return findElements(By.xpath("//*[@id=\"yith-wcwl-form\"]/table//tr"));
    }

    public List<WebElement> productPrice(){
        return findElements(By.xpath("//*[@id=\"yith-wcwl-form\"]/table//tr/td[4]/ins/span/bdi | //*[@id=\"yith-wcwl-form\"]/table//tr/td[4]/span/bdi"));
    }

    public WebElement addToCart(int lowestPrice){

            return waitForElementPresent(By.xpath("//*[@id=\"yith-wcwl-form\"]/table//tr/td[4]/ins/span/bdi/ancestor::tr//*[contains(text(),'\"+lowestPrice+\"')]/ancestor::tr//td[6] | " +
                    "//*[@id=\"yith-wcwl-form\"]/table//tr/td[4]/span/bdi/ancestor::tr//*[contains(text(),'\"+lowestPrice+\"')]/ancestor::tr//td[6]"));
    }

    public WebElement itemName(int lowestPrice){
        return waitForElementPresent(By.xpath("//*[@id=\\\"yith-wcwl-form\\\"]/table//tr/td[4]/ins/span/bdi/ancestor::tr//*[contains(text(),'\\\"+lowestPrice+\\\"')]/ancestor::tr//td[3] | \" +\n" +
                "                    \"//*[@id=\\\"yith-wcwl-form\\\"]/table//tr/td[4]/span/bdi/ancestor::tr//*[contains(text(),'\\\"+lowestPrice+\\\"')]/ancestor::tr//td[3]"));
    }

    public WebElement viewCart(){
        return waitForElementPresent(By.xpath("//*[@id=\"blog\"]//i[@class='la la-search']"));
    }
}
