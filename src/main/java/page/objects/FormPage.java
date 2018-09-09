package page.objects;

import com.persado.oss.quality.stevia.selenium.core.WebComponent;

public class FormPage extends WebComponent {

    static String name = "Name";
    static String lname = "Lname";

    public enum FormPageLocators {

        FNAME("//*[@id=\"main-form\"]/input[1]"),
        LNAME("//*[@id=\"lastname\"]"),
        AGE("//*[@id=\"main-form\"]/input[3]"),
        MALE_BTN("//*[@id=\"main-form\"]/input[4]"),
        FEMALE_BTN("//*[@id=\"main-form\"]/input[5]"),
        SUBMIT_BTN("//*[@id=\"submit\"]"),
        RESET_BTN("//*[@id=\"main-form\"]/input[7]");

        private String myLocator;

        FormPageLocators(String locator) {
            myLocator = locator;
        }

        public String get() {
            return myLocator;
        }

    }

    public void completeForm(){
        controller().input(FormPageLocators.FNAME.get() , name);
        controller().input(FormPageLocators.LNAME.get() , lname);
        controller().click(FormPageLocators.FEMALE_BTN.get());
    }

    public void cleanForm(){
        controller().click(FormPageLocators.RESET_BTN.get());
    }

    public String returnFieldValue(String element){
        String field = controller().getInputValue(element);

        return field;
    }
}
