package dev.ranieri.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiHomePage {

    private WebDriver driver;

    public WikiHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this); // this line will read the FindBy Anotations
        // and automatically get the elements for you
    }

    @FindBy(xpath = "//*[@id=\"js-link-box-en\"]")
    public WebElement english;

    @FindBy(css = "div[lang='es']")
    public  WebElement spanish;

    @FindBy(className = "lang8")
    public WebElement italian;

    @FindBy(id = "searchLanguage")
    public WebElement searchLanguage;

    @FindBy(xpath = "//*[@id=\"search-form\"]/fieldset/button")
    public WebElement searchInputButton;

    @FindBy(id = "js-lang-list-button")
    public WebElement readInYourLanguage;

}
