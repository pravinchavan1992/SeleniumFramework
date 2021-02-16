package tests;

import enums.CategoryType;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.ExtraDetails;
import pages.RoomType;

public class Test1 extends BaseTest {

    @Test(groups = {CategoryType.SANITY, CategoryType.REGRESSION})
    public void Test001(){
        AccountPage accountPage = new AccountPage();
        accountPage.enterEmail("Test@fmail.com");
        accountPage.enterPassword("test@123");
        String country = accountPage.getContries().get(1);
        accountPage.selectCountry(country);
        String budget = accountPage.getBudget().get(1);
        accountPage.selectBudget(budget);
        accountPage.clickOnNextButton();

        RoomType roomType = new RoomType();
        roomType.selectRoomType("Family");
        roomType.clickOnNextButton();

        ExtraDetails extraDetails = new ExtraDetails();
        extraDetails.enterDescription("Test Description");
        extraDetails.clickOnFinishButton();
    }

    @Test(groups = {CategoryType.SANITY, CategoryType.SMOKE})
    public void Test002(){
        AccountPage accountPage = new AccountPage();
        accountPage.enterEmail("Test1@fmail.com");
        accountPage.enterPassword("test@1234");
        String country = accountPage.getContries().get(2);
        accountPage.selectCountry(country);
        String budget = accountPage.getBudget().get(2);
        accountPage.selectBudget(budget);
        accountPage.clickOnNextButton();

        RoomType roomType = new RoomType();
        roomType.selectRoomType("Business");
        roomType.clickOnNextButton();

        ExtraDetails extraDetails = new ExtraDetails();
        extraDetails.enterDescription("Test Description for Business");
        extraDetails.clickOnFinishButton();
    }
}
