package step.definition;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import step.UserSteps;

public class CommonStepDefinition {
    @Steps
    private UserSteps userSteps;

    @Given("I open Landing Page")
    public void openLandingPage(){
        userSteps.openLandingPage();
    }

    @Given("I go to Login page")
    public void openLoginPage(){
        userSteps.checkWelcomeTitle()
                .openLoginPage()
                .checkTitleLoginPage();
    }

    @When("I submit authentication data")
    public void submitAuthenticationData(){
        userSteps.enterLoginPassword();
    }

    @Then("Main page is loaded")
    public void verifyMainPageIsLoaded(){
        userSteps.checkMainPageTitle();
    }

}
