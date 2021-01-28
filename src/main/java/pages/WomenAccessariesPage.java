package pages;
import enums.WaitingStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.stream.Collectors;


public class WomenAccessariesPage extends BasePage {
    private final By subCategories = By.cssSelector("div.subcategory-image a");

    private final By firstTop = By.cssSelector(".product_list li:first-of-type div.right-block");

    private final By addToCategory = By.cssSelector("p#add_to_cart span");

    private final By categoryName = By.cssSelector("span.category-name");

    private final By getCategory(String Category) {
        return By.cssSelector("a[title='" + Category + "']");
    }

    private final WebElement getSubCategory(String subCategory) {
       return getWebElements(subCategories,WaitingStrategy.VISIBLE).stream().filter(x->x.getAttribute("title").equals(subCategory)).collect(Collectors.toList()).get(0);
    }
    public WomenAccessariesPage selectCategory(String category){
        click(getCategory(category),WaitingStrategy.VISIBLE);
        return this;
    }
    public WomenAccessariesPage selectSubCategory(String subCategory){
        getSubCategory(subCategory).click();
        return this;
    }

    public WomenAccessariesPage selectFirstTop(){
        moveToWebElementAndClick(firstTop, WaitingStrategy.VISIBLE);
        return this;
    }

}
