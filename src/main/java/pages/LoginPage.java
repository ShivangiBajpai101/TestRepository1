package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver1) {
        super(driver1);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement email;
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;
    @FindBy(xpath = "//button[@class='btn btn-default btn-lg btn-block effect ladda-button waves-effect']")
    WebElement loginbutton;

    public void enterusername(String username){
        email.clear();
        email.sendKeys(username);
    }

    public void enterpasswd(String passwd){
        password.clear();
        password.sendKeys(passwd);
    }
   public void clickonloginbutton2(){
        loginbutton.click();
   }


}
