package tests;

import main.java.pages.ComputerPage;
import main.java.pages.NewComputerPage;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class ComputerPageTest {


    private WebDriver driver;
    ComputerPage computerPage;
    NewComputerPage newComputerPage;


    @BeforeClass
    public void setUp() {

        computerPage= new ComputerPage(driver);
        driver= computerPage.chromeDriverConection();
        computerPage.openURL("http://computer-database.herokuapp.com/computers");


        //driver.manage().timeouts().implicitlyWait(15,SECONDS);
        driver.manage().window().maximize();
    }


    @Test (priority = 3)
//1) buscar computadora y
    public void findComputer() throws InterruptedException {
        computerPage.openURL("http://computer-database.herokuapp.com/computers");

        computerPage= new ComputerPage(driver);
        computerPage.search();
        assertEquals(computerPage.messageText(), "One computer found");




    }


    //2) agregar computadora
    @Test (priority = 1)
    public void addComputer() throws InterruptedException {

        newComputerPage = new NewComputerPage(driver);

        newComputerPage.addComputer();


        assertTrue(newComputerPage.messageText().contains("has been created"));



    }
    //3) editar computadora
    @Test (priority = 2)
    public void editComputer() throws InterruptedException {

        newComputerPage = new NewComputerPage(driver);
        computerPage= new ComputerPage(driver);
        computerPage.search();
        newComputerPage.editComputer();
        assertTrue(newComputerPage.messageText().contains("has been updated"));

    }
    //4) eliminar computadora

    @Test (priority = 4)
    public void deleteComputer() throws InterruptedException {
        newComputerPage = new NewComputerPage(driver);
        computerPage.search();
        newComputerPage.deleteComputer();
        assertEquals(newComputerPage.messageText(),"Done! Computer has been deleted");
    }

    @AfterClass
    public void tearDown() {
           driver.quit();
    }
}
