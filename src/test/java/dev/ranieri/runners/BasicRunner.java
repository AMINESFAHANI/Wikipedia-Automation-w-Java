package dev.ranieri.runners;

import dev.ranieri.pages.WikiHomePage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "dev.ranieri.steps")
public class BasicRunner {

    public static WebDriver driver = null;
    public static WikiHomePage wikiHomePage = null;
    public static WebDriverWait wait=null;
    public static FluentWait fluentWait=null;

    @BeforeClass
    public static void setup() {
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();// ChomeDriver is an implementation of a web driver interface

        wait=new WebDriverWait(driver, 20);

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS) ;

        fluentWait = new FluentWait(driver).withTimeout(5000, TimeUnit.MILLISECONDS).pollingEvery(250, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);

        wikiHomePage = new WikiHomePage(driver);// pass the driver into any poms that you need
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void teardown(){
        driver.quit();

    }


}
