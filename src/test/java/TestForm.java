import com.persado.oss.quality.stevia.spring.SteviaTestBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.objects.FormPage;

public class TestForm extends SteviaTestBase {

    static String name = "Name";
    static String lname = "Lname";

    @Autowired
    FormPage formPage;

    @Test
    public void cleanForm(){

        // complete the fields of the form
        formPage.completeForm();
        // verify that fields are completed
        String fieldNameValue = formPage.returnFieldValue(FormPage.FormPageLocators.FNAME.get());
        String fieldLNameValue = formPage.returnFieldValue(FormPage.FormPageLocators.LNAME.get());
        Assert.assertEquals(fieldNameValue , name);
        Assert.assertEquals(fieldLNameValue , lname);
        //click Reset button
        formPage.cleanForm();
        //verify that form is clean
        fieldNameValue = formPage.returnFieldValue(FormPage.FormPageLocators.FNAME.get());
        fieldLNameValue = formPage.returnFieldValue(FormPage.FormPageLocators.LNAME.get());
        Assert.assertEquals(fieldNameValue , "");
        Assert.assertEquals(fieldLNameValue , "");

    }
}
