package stepdefinations.mystore;

import enums.Conditions;
import enums.Environment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageobjects.mystore.HomePage;
import utils.BaseUtils;
import utils.builders.WFBuilder;
import utils.helpers.SiteUrl;

import java.util.List;


public class HomePageStepDefs {

    private final BaseUtils base;
    private final HomePage homePage;

    public HomePageStepDefs(BaseUtils baseUtil) {
        base = baseUtil;
        homePage = new HomePage(base);
    }

    @Given("^user on the home page$")
    public void user_on_the_home_page() throws Throwable {
        base.loadPage(SiteUrl.url(Environment.TEST));
        base.waitFor(homePage.correctPage, 5);

    }

    @And("user select summer dresses from the sub menu")
    public void user_select_summer_dresses_from_the_sub_menu() {

        Actions actions = new Actions(base.driver);
        WebElement dresseslink = base.driver.findElement(homePage.dressesLink);
        WebElement summerlink = base.driver.findElement(homePage.summerDressesLink);
        actions.moveToElement(dresseslink).build().perform();
        base.waitFor(homePage.summerDressesLink, WFBuilder.options().conditions(Conditions.CLICKABLE).build());
        summerlink.click();

    }

    @And("user should be able to see summer dresses")
    public void user_should_be_able_to_see_summer_dresses() {
        List<WebElement> totalProducts = base.getListOfElements(homePage.products);
        Assert.assertTrue("Products are not visible", totalProducts.size() > 0);

    }

    @When("user click on add to the cart for summer dresses")
    public void user_click_on_add_to_the_cart_for_summer_dresses() throws InterruptedException {

        WebElement product = base.driver.findElement(homePage.productTile);

        Actions actions = new Actions(base.driver);
        actions.moveToElement(product).build().perform();
        product.click();
        WebElement frame = base.driver.findElement(homePage.addToCartFrame);
        base.switchToFrame(frame);
        WebElement addToCartButton = base.driver.findElement(homePage.addToCartButton);
        addToCartButton.click();
        base.waitFor(homePage.closePopUp, WFBuilder.options().conditions(Conditions.CLICKABLE).build());
        base.driver.findElement(homePage.closePopUp).click();

    }

    @Then("verify summer dresses should be added into the basket respectively")
    public void verify_summer_dresses_should_be_added_into_the_basket_respectively() {

        WebElement cartIcon = base.driver.findElement(homePage.cartLabel);
        Actions actions = new Actions(base.driver);
        actions.moveToElement(cartIcon).build().perform();
        String basketCount = base.driver.findElement(homePage.cartCount).getText();
        Assert.assertTrue("There are no products in basket", Integer.parseInt(basketCount) > 0);

    }

    @And("user should be able to navigate to sign in page")
    public void user_should_be_able_to_navigate_to_sign_in_page() {

        WebElement cartIcon = base.driver.findElement(homePage.cartLabel);
        Actions actions = new Actions(base.driver);
        actions.moveToElement(cartIcon).build().perform();
        base.waitFor(homePage.checkoutButton, WFBuilder.options().conditions(Conditions.CLICKABLE).build());
        homePage.clickOnAButton(homePage.checkoutButton);
        base.waitFor(homePage.proceedToCheckoutButton, WFBuilder.options().conditions(Conditions.CLICKABLE).build());
        homePage.clickOnAButton(homePage.proceedToCheckoutButton);
        Assert.assertTrue("sign in option is not present", base.driver.findElement(homePage.currentState).isDisplayed());

    }

}
