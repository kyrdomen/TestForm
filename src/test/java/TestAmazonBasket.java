import com.persado.oss.quality.stevia.spring.SteviaTestBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;
import page.objects.*;

@Component
public class TestAmazonBasket extends SteviaTestBase {

    @Autowired
    MainNavigationBar amazonPage;

    @Autowired
    AmazonLoginPage loginPage;

    @Autowired
    AmazonSparkPage sparkPage;

    @Autowired
    AmazonFindsPage findsPage;

    @Autowired
    AmazonProductDetailsPage detailsPage;

    @Autowired
    AmazonCardPage cardPage;


    @Test
    public void AmazonSelectDealsOfTheDay() throws InterruptedException {

        //Go to Amazon Home Page and click on Amazon Deals
        amazonPage.clickElement(MainNavigationBar.AmazonHomePageLocators.AMAZON_DEAL_OF_THE_DAY_DETAILS.get());

        //Verify that user is redirected to next page
        Utilities.checkElementPresent(AmazonLoginPage.AmazonLoginPageLocators.TITLE.get());

        //Login to Amazon
        loginPage.login();

        //Verify Login is successful and user is redirected to next page
        Thread.sleep(1000);
        amazonPage.checkLoginSuccess();
        Utilities.checkElementPresent(AmazonSparkPage.AmazonSparkPageLocators.HEAD.get());

        //Click on one of suggested articles
        sparkPage.clickProduct();

        //Stay on new tab opened
        findsPage.switchTab();

        //Verify user is redirected to products page
        Utilities.checkElementPresent(AmazonFindsPage.AmazonFindsPageLocators.TITLE.get());

        //Click on the third product
        findsPage.selectProducttoBuy(AmazonFindsPage.AmazonFindsPageLocators.PRODUCT.get());

        //Verify popup is opened
        Utilities.checkElementPresent(AmazonFindsPage.AmazonFindsPageLocators.POPUP.get());
        Utilities.checkElementPresent(AmazonFindsPage.AmazonFindsPageLocators.BTN.get());

        //Click on popup button
        findsPage.selectProducttoBuy(AmazonFindsPage.AmazonFindsPageLocators.BTN.get());

        //Verify user is redirected to product details
        Utilities.checkElementPresent(AmazonProductDetailsPage.AmazonProductDetailsLocators.ADD_TO_CARD_BTN.get());

        //Get price of product
        String price = detailsPage.getPriceofProduct();

        //Add product to card
        detailsPage.addProduct();

        //Go to Basket
        amazonPage.clickElement(MainNavigationBar.AmazonHomePageLocators.BASKET_BTN.get());

        //Verify user is redirected to basket
        Utilities.checkElementPresent(AmazonCardPage.AmazonCardPageLocators.PROCEED_CHECKOUT_BTN.get());

        //Verify Product price on basket list
        cardPage.checkPriceInCard(price);

        //Delete product in basket
        cardPage.deleteProduct();
    }

}





