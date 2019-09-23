package main.java.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class basePage{
    private WebDriver driver;


    public basePage(WebDriver driver)
    {
        this.driver= driver;


    }

    public WebDriver chromeDriverConection() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

        public WebElement findElement(By locator)
        {
            return driver.findElement(locator);
        }

    public List<WebElement> findElements(By locator)
    {
        return driver.findElements(locator);
    }

    public String getText(WebElement element)
    {
        return element.getText();
    }

    public String getText (By locator)
    {
        return driver.findElement(locator).getText();
    }

    public void writeText(Keys text, By locator)
    {
        driver.findElement(locator).sendKeys(text);
    }

    public void writeText(String text, By locator)
    {
        driver.findElement(locator).sendKeys(text);
    }
    public void clearText (By locator){
     driver.findElement(locator).clear();
        }


    public void click(By locator)
    {
        driver.findElement(locator).click();
    }


    public Boolean isDisplayed(By locator)
    {
        try
        {
            return driver.findElement(locator).isDisplayed();
        }
        catch (org.openqa.selenium.NoSuchElementException e )
        {
            return false;
        }
    }

public void waitTime(int seconds )
{
    driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);


}

    public void openURL(String url)
    {
        driver.get(url);
    }


















}


