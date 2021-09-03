package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage{

    public SignupPage(WebDriver driver1) {
        super(driver1);
    }
    @FindBy(xpath = "//h5[normalize-space()='Signup']")
    static
    WebElement signuptext;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstname;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastname;
    @FindBy(xpath = "//input[@placeholder='Phone']")
    WebElement phone;
    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement email;
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;
    @FindBy(xpath = "//span[@role='combobox']")
    WebElement accounttype;
    @FindBy(xpath = "//span[normalize-space()='Signup']")
    WebElement signupbutton;
    @FindBy(xpath = "//form[@method='POST']")
    WebElement Customertype;
    @FindBy(xpath = "//h5[normalize-space()='Login']")
    WebElement signupcomplete;

    public static boolean signuptext(){
        return wait(signuptext).isDisplayed();
    }
    public void enterfirstname(String fn){
        firstname.clear();
        firstname.sendKeys(fn);
    }
    public void enterlastname(String ln){
        lastname.clear();
        lastname.sendKeys(ln);
    }
    public void enterephone(String ph){
        phone.clear();
        phone.sendKeys(ph);
    }
    public void enteremail(String em){
        email.clear();
        email.sendKeys(em);
    }
    public void enterepassword(String pswd){
        password.clear();
        password.sendKeys("pswd");
    }
    public void enterAccounttype(String account){
        accounttype.click();
        accounttype.sendKeys("Customer");
        Customertype.click();

    }
    public void clickonsignupbutton(){
        signupbutton.click();
    }
    public boolean verifyuserissignedup(){
        return wait(signupcomplete).isDisplayed();
    }

    }

