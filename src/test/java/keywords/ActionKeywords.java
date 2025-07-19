package keywords;

import TestExecution.ExecutionClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

import static utils.ExcelReader.dataColumnValue;

public class ActionKeywords {

    static WebDriver driver;


    public static void openBrowser() {
        if (dataColumnValue.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (dataColumnValue.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (dataColumnValue.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }


        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

    }

    public static void goToUrl() {
        driver.get(dataColumnValue);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public static void enterUsername() {
        WebElement username = driver.findElement(ExecutionClass.locator);
        username.sendKeys(dataColumnValue);


    }

    public static void enterPassword() {
        WebElement password = driver.findElement(ExecutionClass.locator);
        password.sendKeys(dataColumnValue);


    }

    public static void clickLogin() {
        WebElement loginButton = driver.findElement(ExecutionClass.locator);
        loginButton.click();

    }

    public static void verifyLoginAndQuit() {
        WebElement dashboardTitle = driver.findElement(ExecutionClass.locator);
        if (dashboardTitle.isDisplayed())
            System.out.println("Login Successful");
        Assert.assertTrue(dashboardTitle.isDisplayed(), "Element is not visible!");
        driver.close();
        System.out.println("The test is passed..all steps has been executed!!");

    }


}
