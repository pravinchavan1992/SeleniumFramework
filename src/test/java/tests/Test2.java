package tests;

import annotations.FrameworkAnnotation;
import enums.Author;
import enums.CategoryType;
import model.BookingBuilder;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.ExtraDetails;
import pages.RoomType;
import reportManager.extentReport.ExtentLogger;

public class Test2 extends BaseTest{
    @Test(groups = {CategoryType.SANITY, CategoryType.REGRESSION}, description = "Test2 001")
    @FrameworkAnnotation(authur = {Author.PC}, category = {CategoryType.SMOKE, CategoryType.REGRESSION})
    public void Test2001(){
        BookingBuilder bookingBuilder = new BookingBuilder().getBookingData();

        AccountPage accountPage = new AccountPage();
        accountPage.enterEmail(bookingBuilder.getEmail());
        accountPage.enterPassword(bookingBuilder.getPassword());
        accountPage.selectCountry(bookingBuilder.getCountry());
        accountPage.selectBudget(bookingBuilder.getBudget());
        accountPage.clickOnNextButton();

        RoomType roomType = new RoomType();
        roomType.selectRoomType(bookingBuilder.getRoomType().toString());
        roomType.clickOnNextButton();

        ExtraDetails extraDetails = new ExtraDetails();
        extraDetails.enterDescription(bookingBuilder.getRoomDescription());
        extraDetails.clickOnFinishButton();
        if(extraDetails.isSuccessMessageDisplayed()){
            ExtentLogger.pass("Room Booking is Completed");
        }
        else {
            ExtentLogger.fail("Room Booking failed",true);
        }
    }
}
