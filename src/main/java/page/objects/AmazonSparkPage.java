package page.objects;

import com.persado.oss.quality.stevia.selenium.core.WebComponent;

public class AmazonSparkPage extends WebComponent {

    public enum AmazonSparkPageLocators {

        HEAD("//*[@id=\"glimpse-app\"]/div/div[1]/div"),
        PRODUCT("//*[@id=\"glimpse-app\"]/div/div[2]/div/div/div/div[1]/span[2]/a/img");


        private String myLocator;

        AmazonSparkPageLocators(String locator) {
            myLocator = locator;
        }

        public String get() {
            return myLocator;
        }

    }

    public void clickProduct() {
        controller().pressAndWaitForPageToLoad(AmazonSparkPageLocators.PRODUCT.get());
    }
}
