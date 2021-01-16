package pageobjects.mystore;

import utils.BasePageObject;
import utils.BaseUtils;
import org.openqa.selenium.By;

public class HomePage extends BasePageObject {

    public HomePage(BaseUtils base){super(base); }

    public By correctPage = By.cssSelector("div.header_user_info > a");
    public By dressesLink = By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a");
    public By summerDressesLink = By.cssSelector("#block_top_menu > ul > li:nth-child(2) > ul > li:nth-child(3) > a");
    public By products = By.xpath("//*[@class=\"product_img_link\"]");
    public By productTile = By.cssSelector("div.product-container >div  > div.product-image-container");
    public By addToCartButton = By.id("add_to_cart");
    public By addToCartFrame = By.className("fancybox-iframe");
    public By closePopUp = By.className("cross");
    public By cartLabel = By.cssSelector("div.shopping_cart > a");
    public By cartCount = By.cssSelector("a > span.ajax_cart_quantity");
    public By checkoutButton = By.cssSelector("#button_order_cart");
    public By proceedToCheckoutButton= By.cssSelector("p.cart_navigation >a:nth-child(1)");
    public By currentState = By.cssSelector(".step_current.second");

    public void clickOnAButton(By locator) { thisBase.driver.findElement(locator).click(); }

}
