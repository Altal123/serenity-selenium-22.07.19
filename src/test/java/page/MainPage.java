package page;

import net.thucydides.core.pages.PageObject;

public class MainPage extends PageObject {

    public String getTitle(){
        return  getDriver().getTitle();
    }

}
