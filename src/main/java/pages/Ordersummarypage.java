package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Ordersummarypage extends BasePage {
    public Ordersummarypage(WebDriver driver1) {
        super(driver1);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='item-name']")
    WebElement itemname;
    @FindBy(xpath = "//td[@class='table-amount text-body']")
    WebElement productamount;
    @FindBy(xpath = "//a[@class='button-main-content']")
    WebElement continuebutton;

    public boolean verifyproductnameattribute() {
        return wait(itemname).isDisplayed();

    }

    public boolean verifyproductamountattribute() {
        return wait(productamount).isDisplayed();
    }
    public void clickoncontinuebutton(){
        continuebutton.click();
    }
}
