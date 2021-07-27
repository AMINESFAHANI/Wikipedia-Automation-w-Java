package dev.ranieri.steps;

import dev.ranieri.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class LanguageSteps {

    @Given("The Guest is on the Wikipedia Home Page")
    public void the_Guest_is_on_the_Wikipedia_Home_Page()  {
        BasicRunner.driver.get("https://www.wikipedia.org/");
        BasicRunner.wait.until(ExpectedConditions.titleIs("Wikipedia"));
        BasicRunner.fluentWait.until(ExpectedConditions.titleIs("Wikipedia"));
   }

    @When("The Guest clicks on English")
    public void the_Guest_clicks_on_English() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(BasicRunner.wikiHomePage.english));
        BasicRunner.wikiHomePage.english.click();
    }

    @Then("The Guest should be on the English Home Page")
    public void the_Guest_should_be_on_the_English_Home_Page() {
        String title = BasicRunner.driver.getTitle();
        BasicRunner.wait.until(ExpectedConditions.titleContains("Wikipedia"));
        Assert.assertEquals(title, "Wikipedia, the free encyclopedia");
    }

    @When("The Guest clicks on Spanish")
    public void the_Guest_clicks_on_Spanish(){
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(BasicRunner.wikiHomePage.spanish));
        BasicRunner.wikiHomePage.spanish.click();

    }

    @Then("The Guest should be on the Spanish Home Page")
    public void the_Guest_should_be_on_the_Spanish_Home_Page() {
        BasicRunner.wait.until(ExpectedConditions.titleContains("Wikipedia"));
        String title = BasicRunner.driver.getTitle();
        Assert.assertEquals(title, "Wikipedia, la enciclopedia libre");
    }

    @When("The Guest clicks on Italian")
    public void the_Guest_clicks_on_Italian() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(BasicRunner.wikiHomePage.italian));
        BasicRunner.wikiHomePage.italian.click();
    }

    @Then("The Guest should be on the Italian Home Page")
    public void the_Guest_should_be_on_the_Italian_Home_Page() {
        BasicRunner.wait.until(ExpectedConditions.titleContains("Wikipedia"));
        String title = BasicRunner.driver.getTitle();
        Assert.assertEquals(title, "Wikipedia, l'enciclopedia libera");
    }

    @When("The Guest clicks the drop down search Language button and select a {string} from drop down list")
    public void languageDropdown(String language) {
        BasicRunner.wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//*[@id=\"searchLanguage\"]"))));
        WebElement dropdown = BasicRunner.wikiHomePage.searchLanguage;
        Select dropDownLanguage = new Select(dropdown);
        dropDownLanguage.selectByVisibleText(language);

    }

    @When("The Guest clicks the searchInputButton button")
    public void the_Guest_clicks_on_searchInputButton() {
        BasicRunner.wait.until(ExpectedConditions.elementToBeClickable(BasicRunner.wikiHomePage.searchInputButton));
        BasicRunner.wikiHomePage.searchInputButton.click();
    }

    @Then("The Guest should be on the specific language Search Page with {string}")
    public void the_Guest_should_be_on_the_specific_language_Home_Page(String title){
        BasicRunner.wait.until(ExpectedConditions.presenceOfElementLocated((By.tagName("title"))));
        String currenttTitle = BasicRunner.driver.getTitle();
        Assert.assertEquals(title,currenttTitle);
    }

    @When("The Guest is on the Wikipedia Home Page and search in all languages")
    public void allLanguageDropdown() {

        LanguageSteps languageSteps=new LanguageSteps();
        languageSteps.the_Guest_is_on_the_Wikipedia_Home_Page();
        BasicRunner.wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//*[@id=\"searchLanguage\"]"))));
        WebElement dropdown = BasicRunner.wikiHomePage.searchLanguage;
        Select dropDownLanguage = new Select(dropdown);
        List<WebElement> options = dropDownLanguage.getOptions();
        ArrayList<String> optionLangs = new ArrayList<>();
        for (WebElement option:options){
            optionLangs.add(option.getAttribute("lang"));
        }

        for(String lang:optionLangs){
           languageSteps.the_Guest_is_on_the_Wikipedia_Home_Page();

            BasicRunner.wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//*[@id=\"searchLanguage\"]"))));
            WebElement eachDropdown = BasicRunner.wikiHomePage.searchLanguage;
            Select eachDropDownLanguage = new Select(dropdown);
            if(lang.equals("nb")){
                lang="no";
            }
            if(lang.equals("en")){
                lang="simple";
            }
            if(lang.equals("yue")){
                lang="zh-yue";
            }

            eachDropDownLanguage.selectByValue(lang);

            if(lang.equals("no")){
                lang="nb";
            }
            if(lang.equals("simple")){
            lang="en";
            }
            if(lang.equals("zh-yue")){
                lang="yue";
            }

            languageSteps.the_Guest_clicks_on_searchInputButton();

            BasicRunner.wait.until(ExpectedConditions.presenceOfElementLocated((By.tagName("html"))));
            WebElement html = BasicRunner.driver.findElement(By.tagName("html"));
            Assert.assertEquals(lang,html.getAttribute("lang"));
        }
    }
}