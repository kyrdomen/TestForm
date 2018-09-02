package page.objects;

import com.persado.oss.quality.stevia.selenium.core.WebComponent;

public class AmazonLoginPage extends WebComponent {

    static String User_Name = "gr.istqb@gmail.com";
    static String Password = "PERSADO";

    public enum AmazonLoginPageLocators {
        TITLE("//*[@id=\"authportal-main-section\"]/div[2]/div/div/form/div/div/div/h1"),
        EMAIL("ap_email"),
        PASSWORD("ap_password"),
        BTN("signInSubmit");


        private String myLocator;

        AmazonLoginPageLocators(String locator) {
            myLocator = locator;
        }

        public String get() {
            return myLocator;
        }

    }


    public void LoginToAmazon() {
        controller().input(AmazonLoginPageLocators.EMAIL.get(), User_Name);
        controller().input(AmazonLoginPageLocators.PASSWORD.get(), Password);
        controller().pressAndWaitForPageToLoad(AmazonLoginPageLocators.BTN.get());
    }

}
