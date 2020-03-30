package com.automatedtest.sample.homepage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;

public class HomePageSteps {


    private HomePage homePage;

    public HomePageSteps() {
        this.homePage = new HomePage();
    }

    @Given("^user navigates to UBS site$")
    public void aUserNavigatesToUBSPage() {
        this.homePage.goToHomePage();
    }

    @Given("^user confirms Privacy Settings")
    public void confirmsPrivacySettings() {
        this.homePage.acceptPolicy();
    }

    @Then("^UBS logo is displayed$")
    public void googleLogoIsDisplayed() {
        this.homePage.checkLogoDisplay();
    }

    @And("^search bar is displayed$")
    public void searchBarIsDisplayed() {
        this.homePage.checkSearchBarDisplay();
    }

    @Then("^page title is \"([^\"]*)\"$")
    public void pageTitleIs(String title) {
        this.homePage.checkTitle(title);
    }

    @When("^user searches for \"([^\"]*)\"$")
    public void aUserSearchesFor(String searchValue) {
        this.homePage.searchFor(searchValue);
    }

    @Then ("^\"([^\"]*)\" is displayed in the result$")
    public void verifySearchResult(String searchValue) { this.homePage.checkSearchResult(searchValue);}
}
