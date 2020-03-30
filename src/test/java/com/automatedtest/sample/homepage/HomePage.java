package com.automatedtest.sample.homepage;

import com.automatedtest.sample.basepage.BasePage;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage extends BasePage {

    private static final String HOME_PAGE_URL = "https://www.ubs.com/global/en.html";

    @FindBy(xpath = "//div[@class='header__logoTitle']")
    private WebElement logo;

    @FindBy(xpath = "//button[@aria-label='Search']")
    private WebElement searchIcon;

    @FindBy(css = "input[name=querystring]")
    private WebElement searchInput;

    final By PRIVACY_MODAL_WINDOW_WRAPPER = By.xpath("//h1[contains(text(),'Privacy Settings')]");
    final By PRIVACY_ACCEPT_BUTTON = By.xpath("//span[contains(text(),'Agree to all')]");
    final int SEARCH_WAIT_TIME = 5;

    HomePage() {
        PageFactory.initElements(driver, this);
    }

    void goToHomePage() {
        driver.get(HOME_PAGE_URL);
        wait.forLoading(5);
    }


    public void acceptPolicy() {
        Actions act = new Actions(driver);

        act.sendKeys(Keys.TAB).build().perform();

        act.sendKeys(Keys.TAB).build().perform();
        act.sendKeys(Keys.TAB).build().perform();
        act.sendKeys(Keys.TAB).build().perform();
        act.sendKeys(Keys.TAB).build().perform();
        act.sendKeys(Keys.TAB).build().perform();
        act.sendKeys(Keys.ENTER).build().perform();
    }

    private WebElement getAcceptButton() {
        return findElementWithWait(PRIVACY_MODAL_WINDOW_WRAPPER)
                .findElement(PRIVACY_ACCEPT_BUTTON);
    }

    private WebElement findElementWithWait(By locator) {
        return new WebDriverWait(driver, SEARCH_WAIT_TIME).
                until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    void checkLogoDisplay() {
        wait.forElementToBeDisplayed(5, this.logo, "Logo");
    }

    void checkTitle(String title) {
        String displayedTitle = driver.getTitle();
        Assert.assertTrue("Displayed title is " + displayedTitle + " instead of " + title,
                title.equals(displayedTitle));
    }

    void checkSearchBarDisplay() {
        searchIcon.click();
        wait.forElementToBeDisplayed(10, this.searchInput, "Search Bar");
    }

    void searchFor(String searchValue) {
        searchIcon.click();
        this.searchInput.sendKeys(searchValue);
        this.searchInput.sendKeys(Keys.ENTER);
    }

    void checkSearchResult(String searchValue) {
        String searchResultValue = driver.findElement(By.xpath("//div[@class='searchresults__itemWrapper']")).getText();
        Assert.assertTrue("Displayed Search Result is " + searchResultValue + " instead of " + searchValue,
                searchValue.equals(searchResultValue)); }
}

