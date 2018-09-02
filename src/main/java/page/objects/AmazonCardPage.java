package page.objects;

import com.persado.oss.quality.stevia.selenium.core.SteviaContext;
import com.persado.oss.quality.stevia.selenium.core.WebComponent;

public class AmazonCardPage extends WebComponent {

    public enum AmazonCardPageLocators {

        PROCEED_CHECKOUT_BTN("//*[@id=\"sc-buy-box-ptc-button\"]/span/input"),
        SUBTOTAL("//*[@id=\"gutterCartViewForm\"]/div[3]/div/div/div[1]/p/span/span[2]"),
        DELETE_PRODUCT("//*[@id=\"activeCartViewForm\"]/div[1]/div[1]/div[2]/div/div/div/div[4]/div/div[1]/div/div/div[2]/div/span[1]/span/input");
      
        private String myLocator;

        AmazonCardPageLocators(String locator) {
            myLocator = locator;
        }

        public String get() {
            return myLocator;
        }

    }

    public void checkPriceInCard(String price) {
        SteviaContext.verify().equal(price, (controller().getText(AmazonCardPageLocators.SUBTOTAL.get())));
    }

    public void deleteProduct() {
        controller().click(AmazonCardPageLocators.DELETE_PRODUCT.get());
    }
}
