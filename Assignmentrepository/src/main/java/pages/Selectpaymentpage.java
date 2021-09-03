package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.Setup;

import java.util.Set;

public class Selectpaymentpage extends BasePage {
    public Selectpaymentpage(WebDriver driver1) {
        super(driver1);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//p[@class='text-page-title-content']")
    WebElement selectpayment;


    @FindBy(xpath = "//div[normalize-space()='Pay with Visa, MasterCard, JCB, or Amex']")
    WebElement creditcardpaymenttype;

    @FindBy(xpath = "//a[@class='list with-promo']//div[@class='list-content']//div[1]")
    WebElement creditcardtypeclick;

    @FindBy(xpath = "//span[normalize-space()='Select Promo']")
    WebElement selectpromo;

    @FindBy(xpath = "//a[@class='button-main-content']")
    WebElement paynow;

    @FindBy(xpath = "//input[@placeholder='4811 1111 1111 1114']")
    WebElement creditcardNumber;

    @FindBy(xpath = "//input[@placeholder='MM / YY']")
    WebElement expirydate1;

    @FindBy(xpath = "//input[@placeholder='123']")
    WebElement cvvno;

    @FindBy(xpath = "//h1[normalize-space()='Issuing Bank']")
    WebElement issuingbank;

    @FindBy(xpath = "//input[@id='PaRes']")
    WebElement otp;

    @FindBy(xpath = "//p[@id='merchant_name']")
    WebElement merchantname;

    @FindBy(xpath = "//button[normalize-space()='OK']")
    WebElement okbutton;

    @FindBy(xpath = "//span[normalize-space()='Get a nice sleep.'")
    WebElement successfulpayment;

    @FindBy(xpath = "//div[@class='input-row']//div[2]//div[1]//label[1]//input[1]")
    WebElement checkbox;

    @FindBy(xpath = "//span[@class='text-amount-amount']")
    WebElement actualamount1;

    @FindBy(xpath = "//span[@class='text-amount-amount']")
    WebElement newamount;


    public void verfiyamount(){
        String amount1 = actualamount1.getText();
        Setup.holdExecutionForSeconds(2);
        System.out.println("amount without applying coupon code is " +amount1);
        checkbox.click();
        Setup.holdExecutionForSeconds(2);
        String amount2 = newamount.getText();
        Setup.holdExecutionForSeconds(2);
        System.out.println("amount after applying coupon code is " +amount2); }


    public boolean verifymerchantname(){
        boolean Flag = wait(merchantname).isDisplayed();
        return Flag;
    }

    public void entercardnumber(String cardnumber){
        creditcardNumber.clear();
        creditcardNumber.sendKeys(cardnumber);
    }
    public void enterexpirydate(String expirydate){
        expirydate1.clear();
        expirydate1.sendKeys(expirydate);
    }
    public void entercvvnumber(String cvv){
        cvvno.clear();
        cvvno.sendKeys(cvv);
    }
    public void enterotp(String otp1) {
        otp.clear();
        otp.sendKeys(otp1);
    }

    public boolean verifySelectpaymentattribute(){
        return wait(selectpayment).isDisplayed();
    }
    public boolean verifycreditcardpaymenttype(){
        return wait(creditcardpaymenttype).isDisplayed();
    }
    public void clickoncreditcard(){
        creditcardtypeclick.click();
    }
    public void clickonpaynow() {
        paynow.click();
        frameSwitchTo(0);
    }

        public boolean verifysuccessfulpayemt(){
           boolean Flag = wait(successfulpayment).isDisplayed();
            return Flag;
        }
    public void clickonOkbutton() {
        okbutton.click();
        driver.switchTo().defaultContent();
    }

    }




