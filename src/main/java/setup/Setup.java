package setup;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

    public class Setup {
        public static WebDriver driver;
        public static WebDriverWait wait;

        public static WebDriver LaunchBrowser(String browserName)
        {
            System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32 (1)\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MICROSECONDS);
            wait = new WebDriverWait(driver,30);
            return driver;
        }

        public static boolean isDisplayedElement(String xpath){
            boolean flag =false;
            try {
                WebElement element = driver.findElement(By.xpath(xpath));
                if(element.isDisplayed())
                {
                    flag=true;
                }
            }catch (NoSuchElementException e){
                flag = false;
            }
            return flag;
        }

        public static void holdExecutionForSeconds(int seconds){
            try {
                Thread.sleep(seconds*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


