package step.definition;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import step.UserSteps;

public class CommonStepDefinition {
    @Steps
    private UserSteps userSteps;

    @Given("I open Landing Page")
    public void openLandingPage(){
        userSteps.openLandingPage();
    }

}
