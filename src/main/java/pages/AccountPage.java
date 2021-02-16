package pages;

import enums.WaitingStrategy;
import org.openqa.selenium.By;

import java.util.List;

public final class AccountPage extends NavigationPage {

    private static By email = By.cssSelector("#email");

    private static By password = By.cssSelector("#password");

    private static By country = By.cssSelector("select[name=country]");

    private static By budget = By.cssSelector("select[name=budget]");

    private static By checkBox = By.cssSelector(".check");

    public List<String> getContries() {
        return getAllDropdownElement(country, WaitingStrategy.VISIBLE, "Countries Dropdown");
    }

    public List<String> getBudget() {
        return getAllDropdownElement(budget, WaitingStrategy.VISIBLE, "Budget Dropdown");
    }

    public void selectCountry(String countryName) {
        selectDropdownValue(country, WaitingStrategy.VISIBLE, countryName);
    }

    public void selectBudget(String Budget) {
        selectDropdownValue(budget, WaitingStrategy.VISIBLE, Budget);
    }

    public void enterEmail(String mail) {
        enterText(email, WaitingStrategy.VISIBLE, mail, "Email Text Field");
    }

    public void enterPassword(String pass) {
        enterText(password, WaitingStrategy.VISIBLE, pass, "Password Text Field");
    }
}
