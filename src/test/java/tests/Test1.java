package tests;

import annotations.FrameworkAnnotation;
import enums.Author;
import enums.CategoryType;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.ExtraDetails;
import pages.RoomType;
import reportManager.extentReport.ExtentLogger;

public class Test1 extends BaseTest {

    @Test(groups = {CategoryType.SANITY, CategoryType.REGRESSION}, description = "Test Case001")
    @FrameworkAnnotation(authur = {Author.PC}, category = {CategoryType.SANITY, CategoryType.REGRESSION})
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
        if(extraDetails.isSuccessMessageDisplayed()){
            ExtentLogger.pass("Room Booking is Completed");
        }
        else {
            ExtentLogger.fail("Room Booking failed",true);
        }
    }

    @Test(groups = {CategoryType.SANITY, CategoryType.SMOKE}, description = "Test Case002")
    @FrameworkAnnotation(authur = {Author.PC}, category = {CategoryType.SANITY, CategoryType.SMOKE})
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
        if(extraDetails.isSuccessMessageDisplayed()){
            ExtentLogger.pass("Room Booking is Completed");
        }
        else {
            ExtentLogger.fail("Room Booking failed",true);
        }
    }
}
