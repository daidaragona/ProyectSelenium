package main.java.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NewComputerPage  extends basePage{


    public NewComputerPage(WebDriver driver) {
        super(driver);
    }
private WebDriver driver;

    By addButtonLocator = By.id ("add");
    By titlePage = By.xpath ("//*[@id=\"main\"]/h1");
    By computerNameLocator = By.id ("name");
    By introducedDateLocator = By.id ("introduced");
    By discontinuedDateLocator = By.id ("discontinued");
    By dropdownListCompanyLocator= By.name("company");
    By createButtonLocator= By.xpath("//*[@id=\"main\"]/form/div/input");
    By messAlert = By.xpath("//*[@id=\"main\"]/div[1]");
    String url="http://computer-database.herokuapp.com/computers";

    By elementTableLocator= By.xpath( "//*[@id=\"main\"]/table/tbody/tr/td[1]/a");
    By saveButtonLocator= By.xpath("//*[@id=\"main\"]/form[1]/div/input");

    By deleteButtonLocator = By.xpath("//*[@id=\"main\"]/form[2]/input");



    public void returnToHomePage()
{
openURL(url);
}



public  void addComputer(){
    click(addButtonLocator);
   waitTime(20);


    if (isDisplayed(titlePage) ){
        writeText("TOSHIBA", computerNameLocator);
        writeText("1998-12-12", introducedDateLocator);
        writeText("1999-10-11", discontinuedDateLocator);
        selectDropDownListCompany();
        click(createButtonLocator);

    }
    getText(messAlert);

}


    public String messageText()
    {

        return getText(messAlert);
    }

   public String getText()
{

    return driver.findElement(messAlert).getText();
}
public void editComputer()

    {         if (isDisplayed(titlePage)) {
                    click(elementTableLocator);
                    clearText(discontinuedDateLocator);

            writeText("2019-10-11", discontinuedDateLocator);
            click(saveButtonLocator);
            waitTime(10);

        }


    }


    public String selectDropDownListCompany()
    {

        Select selectList= new Select(findElement(dropdownListCompanyLocator));
        selectList.selectByVisibleText("Apple Inc.");
        return getText(selectList.getFirstSelectedOption());
    }

    public void deleteComputer()

    {      if (isDisplayed(titlePage)){
                click(elementTableLocator);
            click(deleteButtonLocator);
            waitTime(16);
            }



    }



}