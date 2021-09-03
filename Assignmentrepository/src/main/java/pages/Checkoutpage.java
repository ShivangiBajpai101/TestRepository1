package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.Setup;

public class Checkoutpage extends BasePage{
    public Checkoutpage(WebDriver driver1) {
        super(driver1);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//td[normalize-space()='Name']")
    WebElement name;

    @FindBy(xpath = "//input[@value='Budi']")
    WebElement nameinput;

    @FindBy(xpath = "//input[@value='20000']")
    WebElement amountinput;

    @FindBy(xpath = "//td[normalize-space()='Email']")
    WebElement email;

    @FindBy(xpath = "//td[normalize-space()='Phone no']")
    WebElement phoneno;

    @FindBy(xpath = "//td[normalize-space()='City']")
    WebElement city;

    @FindBy(xpath = "//td[normalize-space()='Address']")
    WebElement address;

    @FindBy(xpath = "//td[normalize-space()='Postal Code']")
    WebElement postalcode;

    @FindBy(xpath = "//div[@class='cart-checkout']")
    WebElement checkoutbutton;

    @FindBy(xpath = "//span[@class='text-amount-amount']")
    WebElement amountoncheckout;



    public boolean verifycheckoutattribute(){

        return wait(name).isDisplayed();
    }
    public void verifyelement(){
        amountinput.click();
        nameinput.clear();
        nameinput.sendKeys("Shivi");

    }
    public void clickoonCheckuout1() {
        checkoutbutton.click();
        Setup.holdExecutionForSeconds(2);
        //driver.switchTo().frame("snap-midtrans");
        frameSwitchTo(0);
    }

    @FindBy(xpath = "//p[@class='text-page-title-content']")
    WebElement ordersummary;
    public boolean clickoonCheckuout() {
        checkoutbutton.click();
        Setup.holdExecutionForSeconds(2);
        driver.switchTo().frame("snap-midtrans");
        return wait(ordersummary).isDisplayed();
    }


}
