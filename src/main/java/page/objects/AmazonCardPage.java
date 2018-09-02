package page.objects;

import com.persado.oss.quality.stevia.selenium.core.WebComponent;

public class AmazonCardPage extends WebComponent {

    public enum AmazonCardPageLocators {

        PROCEED_CHECKOUT_BTN("//*[@id=\"sc-buy-box-ptc-button\"]/span/input"),
        SUBTOTAL("//*[@id=\"gutterCartViewForm\"]/div[3]/div/div/div[1]/p/span/span[2]"),
        DELETE_PRODUCT("Delete");

        private String myLocator;

        AmazonCardPageLocators(String locator) {
            myLocator = locator;
        }

        public String get() {
            return myLocator;
        }

    }

    public String returnPriceinCard() {
        String cardPrice = controller().getText(AmazonCardPageLocators.SUBTOTAL.get());
        return cardPrice;
    }

    public void deleteProduct() {
        controller().click(AmazonCardPageLocators.DELETE_PRODUCT.get());
    }
}
