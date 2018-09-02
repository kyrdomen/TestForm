package page.objects;

import com.persado.oss.quality.stevia.selenium.core.WebComponent;

public class AmazonProductDetailsPage extends WebComponent {

    public enum AmazonProductDetailsLocators {
        HEAD("//*[@id=\"dp\"]"),
        ADD_TO_CARD_BTN("add-to-cart-button"),
        BUY_NOW_BTN("buy-now-button"),
        PRICE("price_inside_buybox"),
        QUANTITY("selectQuantity > span > div > div");


        private String myLocator;

        AmazonProductDetailsLocators(String locator) {
            myLocator = locator;
        }

        public String get() {
            return myLocator;
        }
    }

    public String getPriceofProduct() {
        String cost = controller().getText(AmazonProductDetailsLocators.PRICE.get());
        return cost;
    }

    public void addProduct() {
        controller().click(AmazonProductDetailsLocators.ADD_TO_CARD_BTN.get());
    }

}
