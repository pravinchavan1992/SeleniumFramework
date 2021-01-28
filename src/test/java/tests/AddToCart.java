package tests;

import enums.CategoryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.WomenAccessariesPage;
import utils.SoftAssertion;

public class AddToCart  extends BaseTest {
    @Test(groups = {CategoryType.REGRESSION, CategoryType.SMOKE} )
    public void AddToCartWithoutLogin(){
        SoftAssertion softAssertion = new SoftAssertion();
        LoginPage loginPage = new LoginPage();
        WomenAccessariesPage womenAccessariesPage = new WomenAccessariesPage();
        MyAccountPage myAccountPage = loginPage.
                clickOnSignInButton().
                loginToApplication("pravinchavan1992@gmail.com", "Test@123");
        Assert.assertEquals(myAccountPage.getLoggedInUserName(), "Pravin Chavan");
        Boolean categorytitle = womenAccessariesPage.selectCategory("Women").isTitle("Women - My Store");
        Assert.assertEquals(categorytitle.booleanValue(), true);
        Boolean subtitle = womenAccessariesPage.selectSubCategory("Tops").isTitle("Tops - My Store");
        Assert.assertEquals(subtitle.booleanValue(), true);
        womenAccessariesPage.selectFirstTop();
        myAccountPage.signOut();
        softAssertion.assertAll();
    }
}
