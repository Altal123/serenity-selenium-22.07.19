package step.definition;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import step.UserSteps;

public class CommonStepDefinition {
    @Steps
    private UserSteps userSteps;

    @Given("I open Landing Page")
    public void openLandingPage(){
        userSteps.openLandingPage();
    }

    @When("I click on '$buttonText' button")
    public void clickOnSignIn(String buttonText){
        userSteps.clickOnButton(buttonText);
    }

    @Then("Main page is loaded")
    public void verifyMainPageIsLoaded(){
        userSteps.checkMainPageTitle();
    }

    @Then("I should be on Login page")
    public void thenIShouldBeOnLoginPage() {
        Assert.assertTrue("Login page is not loaded.", userSteps.isLoginPageLoaded());
    }

    @When("I sign In with '$userEmail' , '$userPassword'")
    public void whenISignAsRegisteredUser(String email, String password){
        userSteps.enterLoginPassword(email, password);
    }

    @Then("I should be on Main page")
    public void iShouldBeOnMainPage(){
        Assert.assertTrue("Home page is not loaded.", userSteps.isMainPageLoaded());
    }

    @Then("I should remain on Login page and receive the error \"This is wrong password..\"")
    public void thenIShouldGetErrorMessage() {
//        Assert.assertTrue("Login page is not loaded", userSteps.isLoginPageLoaded());
        Assert.assertTrue("Error with wrong password is not displayed", userSteps.isWrongPasswordErrorDisplayed());
    }

}
