package utils;
import org.testng.asserts.SoftAssert;

public class SoftAssertion extends SoftAssert {
    public SoftAssertion(){

    }


    @Override
    public void assertEquals(String actual, String expected, String message) {
        super.assertEquals(actual, expected, message);
    }

}
