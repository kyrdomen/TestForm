package page.objects;

import com.persado.oss.quality.stevia.selenium.core.WebComponent;

public class AmazonFindsPage extends WebComponent {

    public enum AmazonFindsPageLocators {

        TITLE("//*[@id=\"a-page\"]/div[1]/div[1]/span[1]"),
        PRODUCT("//*[@id=\"airstream-results\"]/li[3]/div/span/div/div[1]"),
        POPUP("//*[@id=\"a-popover-content-4\"]"),
        BTN("//*[@id=\"a-popover-content-4\"]/span/div/div/div[2]/div/div/ul/li/span/div/a");


        private String myLocator;

        AmazonFindsPageLocators(String locator) {
            myLocator = locator;
        }

        public String get() {
            return myLocator;
        }

    }

    public void switchTab() {
        controller().switchToLatestWindow();
    }

    public void selectProducttoBuy(String element) {
        controller().click(element);
    }

}
