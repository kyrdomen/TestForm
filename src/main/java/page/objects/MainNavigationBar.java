package page.objects;

import com.persado.oss.quality.stevia.selenium.core.SteviaContext;
import com.persado.oss.quality.stevia.selenium.core.WebComponent;

public class MainNavigationBar extends WebComponent {

    static String hello_user = "Hello, grtb";

    public enum AmazonHomePageLocators {

        AMAZON_DEAL_OF_THE_DAY_DETAILS("//*[@id=\"nav-upnav\"]/a"),
        WELCOME_USER("//*[@id=\"nav-link-accountList\"]/span[1]"),
        BASKET_BTN("//*[@id=\"nav-cart\"]");;


        private String myLocator;

        AmazonHomePageLocators(String locator) {
            myLocator = locator;
        }

        public String get() {
            return myLocator;
        }

    }

    public void clickElement(String element) {
        controller().click(element);
    }

    public void checkLoginSuccess() {
        String welcome = controller().getText(AmazonHomePageLocators.WELCOME_USER.get());
        SteviaContext.verify().equal(welcome, hello_user);
    }

}




