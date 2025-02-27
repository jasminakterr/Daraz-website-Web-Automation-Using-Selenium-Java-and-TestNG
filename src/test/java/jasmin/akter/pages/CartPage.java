package jasmin.akter.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import jasmin.akter.basedrivers.PageDriver;
import jasmin.akter.utilities.CommonMethod;
import jasmin.akter.utilities.Screenshots;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class CartPage extends CommonMethod {
    ExtentTest test;
    public CartPage(ExtentTest test) {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }

    //Locators

    @FindBys({@FindBy(xpath = "(//img[@alt='U19 Wired Stereo Earphones - Colorful Matte Finish with Microphone'])[1]")
    })
    WebElement productName;

    @FindBy(xpath = "(//button[contains(@class,'pdp-button pdp-button_type_text pdp-button_theme_orange pdp-button_size_xl')])[1]")
    WebElement addToCart;

    @FindBy(xpath = "(//a[@href='https://cart.daraz.com.bd/cart'])[1]")
    WebElement cartIcon;

    // Report + Screenshot
    public void passCase(String message) {
        test.pass("<p style='color:#85BC63; font-size:14px'><b>" + message + "</b></p>");
    }

    public void passCaseWithSC(String message, String screenshotname) throws IOException {
        test.pass("<p style='color:#22dd3e; font-size:14px'><b>" + message + "</b></p>");
        String screenshotPath = Screenshots.capture(PageDriver.getCurrentDriver(), "" + screenshotname + "");
        String dest = System.getProperty("user.dir") + "\\screenshots\\" + screenshotname + ".png";
        test.info(dest);
        test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
    }

    public void failCase(String message, String screenshotname) throws IOException {
        test.fail("<p style='color:Red; font-size:14px'><b>" + message + "</b></p>");
        Throwable t = new InterruptedException("Exception");
        test.fail(t);

        String screenshotPath = Screenshots.capture(PageDriver.getCurrentDriver(), "" + screenshotname + "");
        String dest = System.getProperty("user.dir") + "\\screenshots\\" + screenshotname + ".png";
        test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());


        PageDriver.getCurrentDriver().quit();
    }


    public void cart() throws IOException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            test.info("Please click your product name options.");
            productName.click();
            passCaseWithSC("Click on the product name", "product_name_click_success");

            try {
                test.info("Please click add to Cart button.");
                addToCart.click();
                passCaseWithSC("Click on the add to cart button", "addToCart_success");


                try {
                    test.info("Please click Add to Cart Icon");
                    new Actions(driver).moveToElement(cartIcon).click().build().perform();
                    passCaseWithSC("Show  the Cart Icon", "cartIcon_click_success");

                }catch (Exception e) {
                        failCase("Cart Icon was not Locate ", "cartIcon_click_fail");
                    }


                } catch (Exception e) {
                    failCase("Add to Cart was not Locate ", "addToCart_fail");
                }

            } catch (Exception e) {
                failCase("Details was not Locate ", "product_name_click_fail");

            }
        }
    }

