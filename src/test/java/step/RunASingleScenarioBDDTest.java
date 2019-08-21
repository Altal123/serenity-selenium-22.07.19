package step;



import net.serenitybdd.jbehave.SerenityStories;
import net.serenitybdd.jbehave.annotations.Metafilter;


//@Metafilter("+tag product:login")// That's where we tell JBehave to only run scenarios with the @tag product: login tag
public class RunASingleScenarioBDDTest extends SerenityStories  {//"extends SerenityStories" enables launching of JBehave framework from IDE or as a part of Build process


    public RunASingleScenarioBDDTest() {

        runSerenity().inASingleSession();

    }

}
