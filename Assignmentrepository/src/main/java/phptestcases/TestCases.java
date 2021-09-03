package phptestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import pages.*;
import setup.Setup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class TestCases extends Setup {
    public WebDriver driver;
    BasePage basePage;
     HomePage homePage;
    SignupPage signupPage;
    LoginPage loginPage;
    Ordersummarypage ordersummarypage;
    Checkoutpage checkoutpage;
    Selectpaymentpage selectpaymentpage;


    @BeforeTest
    public void tearUp() {
        driver = Setup.LaunchBrowser("LaunchBrowser");
        basePage = new BasePage(driver);
        homePage = new HomePage(driver);
        signupPage = new SignupPage(driver);
        loginPage = new LoginPage(driver);
        checkoutpage = new Checkoutpage(driver);
        selectpaymentpage = new Selectpaymentpage(driver);
        ordersummarypage = new Ordersummarypage(driver);
    }

    @BeforeMethod
    public void launchWebsite() {
        driver.get(BasePage.properties.getProperty("url"));
        Assert.assertTrue(Setup.isDisplayedElement("//div[@class='title']"));
    }


    @Test(priority = 1)
    public void verifyBuyNowredirectstoCheckout() {
        homePage.clickonBuynow();
        Setup.holdExecutionForSeconds(3);
        Assert.assertTrue(isDisplayedElement("//td[normalize-space()='Name']"));

    }
    @Test(priority = 2)
    public void veriyMidtransPillowhasbeenadded() throws IOException {
        homePage.clickonBuynow();
        Setup.holdExecutionForSeconds(2);
        checkoutpage.clickoonCheckuout();
        Setup.holdExecutionForSeconds(2);
        Assert.assertTrue(isDisplayedElement("//span[@class='text-amount-amount']"));
    }
    @Test(priority = 3)
    public void verifyCheckoutattributes(){
        homePage.clickonBuynow();
        Setup.holdExecutionForSeconds(2);
        Assert.assertTrue(isDisplayedElement("//td[normalize-space()='Name']"));
        Assert.assertTrue(isDisplayedElement("//td[normalize-space()='Email']"));
        Assert.assertTrue(isDisplayedElement("//td[normalize-space()='Phone no']"));
        Assert.assertTrue(isDisplayedElement("//td[normalize-space()='City']"));
        Assert.assertTrue(isDisplayedElement("//td[normalize-space()='Address']"));
        Assert.assertTrue(isDisplayedElement("//td[normalize-space()='Postal Code']"));
    }
    @Test(priority = 4)
    public void verifyCheckoutfieldsareeditible(){
        homePage.clickonBuynow();
        Setup.holdExecutionForSeconds(2);
        checkoutpage.verifyelement();
        Setup.holdExecutionForSeconds(2);
    }
    @Test(priority = 5)
    public void verifycheckoutredirecttoOrdersummarypage(){
        homePage.clickonBuynow();
        Setup.holdExecutionForSeconds(2);
        checkoutpage.clickoonCheckuout();
        Setup.holdExecutionForSeconds(2);
        Assert.assertTrue(isDisplayedElement("//p[@class='text-page-title-content']"));
    }
    @Test(priority = 6)
    public void verifyattibutesontheOrdersummarypage(){
        homePage.clickonBuynow();
        Setup.holdExecutionForSeconds(2);
        checkoutpage.clickoonCheckuout();
        Setup.holdExecutionForSeconds(2);
        ordersummarypage.verifyproductamountattribute();
        ordersummarypage.verifyproductnameattribute();
    }
    @Test(priority = 7)
    public void verifyorderSummarypageRedirectsToSelectPaymentPage() {
        homePage.clickonBuynow();
        Setup.holdExecutionForSeconds(2);
        checkoutpage.clickoonCheckuout();
        Setup.holdExecutionForSeconds(2);
        ordersummarypage.clickoncontinuebutton();
        Setup.holdExecutionForSeconds(2);
        selectpaymentpage.verifySelectpaymentattribute();
        Assert.assertTrue(isDisplayedElement("//p[@class='text-page-title-content']"));
    }
    @Test(priority = 8)
    public  void verifypaymenttype() {
        List<WebElement> options = driver.findElements(By.xpath("//div[@class='list-content']"));
        System.out.println(options.size());
        List actualpaymentvalue = new ArrayList();
        for (WebElement wb1 : options) {
            actualpaymentvalue.add(wb1.getText());
            System.out.println(wb1.getText());
        }
        List expectedpaymentvalue = new ArrayList();
        for (WebElement wb2 : options) {
            expectedpaymentvalue.add(wb2.getText());
            System.out.println(wb2.getText());
        }
        for (int i = 0; i < actualpaymentvalue.size(); i++) {

            System.out.println("Actual: " + actualpaymentvalue.get(i) + " \n " + " & Expected: " + expectedpaymentvalue.get(i));
            Assert.assertTrue(actualpaymentvalue.get(i).equals(expectedpaymentvalue.get(i)));
            System.out.println("payment value is same as expected");
        }
    }
     @Test(priority = 9)
     public void verifyafterclickigonCreditpageitredirects() {
         homePage.clickonBuynow();
         checkoutpage.clickoonCheckuout();
         ordersummarypage.clickoncontinuebutton();
         selectpaymentpage.clickoncreditcard();
         Setup.holdExecutionForSeconds(2);
         Assert.assertTrue(isDisplayedElement("//span[normalize-space()='Select Promo']"));
    }
    @Test(priority = 11)
    public void verifychangeinAmountafterPromocodeisapplied(){
        homePage.clickonBuynow();
        Setup.holdExecutionForSeconds(2);
        checkoutpage.clickoonCheckuout();
        Setup.holdExecutionForSeconds(2);
        ordersummarypage.clickoncontinuebutton();
        Setup.holdExecutionForSeconds(2);
        selectpaymentpage.clickoncreditcard();
        Setup.holdExecutionForSeconds(2);
        selectpaymentpage.entercardnumber(BasePage.properties.getProperty("cardnumber"));
        Setup.holdExecutionForSeconds(2);
        selectpaymentpage.enterexpirydate(BasePage.properties.getProperty("expirydate"));
        Setup.holdExecutionForSeconds(2);
        selectpaymentpage.entercvvnumber(BasePage.properties.getProperty("cvv"));
        Setup.holdExecutionForSeconds(2);
        selectpaymentpage.clickonpaynow();
        Setup.holdExecutionForSeconds(2);
       Assert.assertTrue(isDisplayedElement("//h1[normalize-space()='Issuing Bank']"));
    }
    @Test(priority = 12)
    public void clickonPaynow(){
        homePage.clickonBuynow();
        Setup.holdExecutionForSeconds(2);
        checkoutpage.clickoonCheckuout();
        Setup.holdExecutionForSeconds(2);
        ordersummarypage.clickoncontinuebutton();
        Setup.holdExecutionForSeconds(2);
        selectpaymentpage.clickoncreditcard();
        Setup.holdExecutionForSeconds(2);
        selectpaymentpage.entercardnumber(BasePage.properties.getProperty("cardnumber"));
        Setup.holdExecutionForSeconds(2);
        selectpaymentpage.enterexpirydate(BasePage.properties.getProperty("expirydate"));
        Setup.holdExecutionForSeconds(2);
        selectpaymentpage.entercvvnumber(BasePage.properties.getProperty("cvv"));
        Setup.holdExecutionForSeconds(2);
        selectpaymentpage.clickonpaynow();
        Setup.holdExecutionForSeconds(2);
       Assert.assertTrue(selectpaymentpage.verifymerchantname());
        //Assert.assertTrue(isDisplayedElement("//label[normalize-space()='Amount:']"));
        //Assert.assertTrue(isDisplayedElement("//label[normalize-space()='Transaction Time:']"));
        //Assert.assertTrue(isDisplayedElement("//label[normalize-space()='Card Number:']"));
    }

    @Test(priority = 13)
    public void verifybyclickingonOkbuttonafterentringOTP() {
        homePage.clickonBuynow();
        Setup.holdExecutionForSeconds(2);
        checkoutpage.clickoonCheckuout();
        Setup.holdExecutionForSeconds(2);
        ordersummarypage.clickoncontinuebutton();
        Setup.holdExecutionForSeconds(2);
        selectpaymentpage.clickoncreditcard();
        Setup.holdExecutionForSeconds(2);
        selectpaymentpage.entercardnumber(BasePage.properties.getProperty("cardnumber"));
        Setup.holdExecutionForSeconds(2);
        selectpaymentpage.enterexpirydate(BasePage.properties.getProperty("expirydate"));
        Setup.holdExecutionForSeconds(2);
        selectpaymentpage.entercvvnumber(BasePage.properties.getProperty("cvv"));
        Setup.holdExecutionForSeconds(2);
        selectpaymentpage.clickonpaynow();
        Setup.holdExecutionForSeconds(2);
        selectpaymentpage.enterotp(BasePage.properties.getProperty("otp"));
        Setup.holdExecutionForSeconds(2);
        selectpaymentpage.clickonOkbutton();
        Setup.holdExecutionForSeconds(5);
        Assert.assertTrue(selectpaymentpage.verifysuccessfulpayemt());
    }
    @Test(priority = 10)
    public void verifyamountchangesaftrclickoncheckbox(){
        homePage.clickonBuynow();
        Setup.holdExecutionForSeconds(2);
        checkoutpage.clickoonCheckuout();
        Setup.holdExecutionForSeconds(2);
        ordersummarypage.clickoncontinuebutton();
        Setup.holdExecutionForSeconds(2);
        selectpaymentpage.clickoncreditcard();
        Setup.holdExecutionForSeconds(2);
        selectpaymentpage.verfiyamount();
    }

    @AfterClass
    public void tear()
    { driver.quit(); }
    }

