package pages;

import enums.WaitingStrategy;
import org.openqa.selenium.By;
import utils.DynamicLocators;

public final class RoomType extends NavigationPage {
    private static By roomTypeLocator(String roomType) {
        return By.xpath(DynamicLocators.getLocator("//h6[normalize-space()='%s']", roomType));
    }

    public void selectRoomType(String roomType){
       clickOnElement(roomTypeLocator(roomType), WaitingStrategy.VISIBLE, roomType+" Button");
    }

}
