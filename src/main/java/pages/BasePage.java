package pages;

import setup.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utill.GenericMethod;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;


public class BasePage extends GenericMethod {
    public static Properties properties;
    public FileInputStream fis;
    public WebDriver driver;

    public BasePage(WebDriver driver1) {
        this.driver = driver1;
        PageFactory.initElements(driver, this);
        properties = new Properties();
        try {
            fis = new FileInputStream(System.getProperty("user.dir")+"\\resources\\config.properties");
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

        }
}
