package Steps;

import com.google.common.io.Files;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Test
public class Function {
    ReadData excel = new ReadData("/home/rupali/IdeaProjects/Front-end-assignment/Excel-data/Excelsheet.xlsx");
    public WebDriver driver;

    @Given("I am in the login page of the demo site")

    public void i_am_in_the_login_page_of_the_demo_site() throws Exception {

        System.setProperty("webdriver.chrome.driver","/home/rupali/IdeaProjects/Front-end-assignment/drivers/chromedriver");

        driver= new ChromeDriver();

        // Maximize browser
        driver.manage().window().maximize();

        //implict Timeout
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://www.saucedemo.com/");


    }
    @When("Take data from excel sheet")
    public void take_data_from_excel_sheet() {
        driver.findElement(By.id("user-name")).sendKeys(excel.getData(0,0,0));
        driver.findElement(By.id("password")).sendKeys(excel.getData(0,0,1));
        try {
            driver.findElement(By.id("login-button")).click();

        }
        catch(ElementNotVisibleException e)
        {
            System.out.println(e.getMessage());
        }
    }
    @Then("Browser close automatically")
    public void browser_close_automatically() {
        try{

            driver.quit();
        }
        catch(StaleElementReferenceException e){
            System.out.println(e.getMessage());
        }

    }


    // For firefox browser

    @Given("I am in the login page of the demo site for automate firefox browser")
    public void i_am_in_the_login_page_of_the_demo_site_for_automate_firefox_browser() {
        System.setProperty("webdriver.gecko.driver","/home/rupali/IdeaProjects/Front-end-assignment/drivers/geckodriver");

        driver= new FirefoxDriver();

        // Maximize browser
        driver.manage().window().maximize();

        //implict Timeout
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://www.saucedemo.com/");
    }
    @When("Take data from excel sheet for firefox  browser")
    public void take_data_from_excel_sheet_for_firefox_browser() {
        try{
            driver.findElement(By.id("user-name")).sendKeys(excel.getData(0,0,0));
        }
        catch(NoSuchElementException e)
        {
            System.out.println(e.getMessage());
        }

        driver.findElement(By.id("password")).sendKeys(excel.getData(0,0,1));
        driver.findElement(By.id("login-button")).click();
    }
    @Then("Browser close automatically for firefox  browser")
    public void browser_close_automatically_for_firefox_browser() {
        driver.quit();

    }

  // For headless chrome browser

    @Given("I am in the login page of the demo site for automate Headless browser")
    public void i_am_in_the_login_page_of_the_demo_site_for_automate_headless_browser() {
        try{
            System.setProperty("webdriver.chrome.driver","/home/rupali/IdeaProjects/Front-end-assignment/drivers/chromedriver");
        }
        catch(WebDriverException e)
        {
            System.out.println(e.getMessage());
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver= new ChromeDriver(options);

        // Maximize browser
        driver.manage().window().maximize();

        //implict Timeout
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://www.saucedemo.com/");
    }
    @When("Take data from excel sheet for Headless browser")
    public void take_data_from_excel_sheet_for_headless_browser() {
        driver.findElement(By.cssSelector("input#user-name")).sendKeys(excel.getData(0,0,0));

        driver.findElement(By.id("password")).sendKeys(excel.getData(0,0,1));
        driver.findElement(By.xpath("/html//input[@id='login-button']")).click();

    }
    @Then("Browser close automatically for Headless browser")
    public void browser_close_automatically_for_headless_browser() {
      driver.quit();


    }

    // Take screenshot
@AfterMethod

public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

    //Convert web driver object to TakeScreenshot

    TakesScreenshot scrShot =((TakesScreenshot)webdriver);

    //Call getScreenshotAs method to create image file

    File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

    //Move image file to new destination

    File DestFile=new File("/home/rupali/IdeaProjects/Front-end-assignment/screenshot");

    //Copy file at destination

    FileUtils.copyFile(SrcFile, DestFile);

}


}





