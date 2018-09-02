package page.objects;

import com.persado.oss.quality.stevia.selenium.core.SteviaContext;
import com.persado.oss.quality.stevia.selenium.core.WebComponent;

public class Utilities extends WebComponent {


    public static void checkElementPresent(String element) {
        SteviaContext.verify().elementPresent(element);
    }


}
