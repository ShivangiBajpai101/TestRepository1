package utill;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.Setup;

import java.beans.Visibility;

public class GenericMethod extends Setup {
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
    public static WebElement wait(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void frameSwitchTo(int index)
    {
        holdExecutionForSeconds(5);
        try {
            driver.switchTo().frame(index);
        }catch (NoSuchWindowException e)
        {
            driver.switchTo().window(driver.getWindowHandle());
            driver.switchTo().frame(index);
        }
    }

}


