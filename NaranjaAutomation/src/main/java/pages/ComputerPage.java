package main.java.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ComputerPage extends basePage{


    public ComputerPage(WebDriver driver) {
        super(driver);
    }


    By searchLocator = By.id("searchbox");
    By searchButtonLocator = By.id ("searchsubmit");
    By messaggeLocator = By.xpath("//*[@id=\"main\"]/h1");



    public void search( )  {
clearText(searchLocator);
        writeText("TOSHIBA", searchLocator);
        click(searchButtonLocator);
        waitTime(10);



    }



    public String messageText()
    {

        return getText(messaggeLocator);
    }




}
