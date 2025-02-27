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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class SearchProductPage extends CommonMethod {
    ExtentTest test;
    public SearchProductPage(ExtentTest test) {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }

    //Locators

    @FindBys({@FindBy(xpath = "(//input[@id='q'])[1]")
    })
    WebElement searchBox;

    @FindBy(xpath = "(//div[@class='search-box__search--2fC5'])[1]")
    WebElement searchButton;

   // @FindBy(xpath = "(//span[@class='breadcrumb_item_anchor breadcrumb_item_anchor_last'])[1]")
    //WebElement searchResult;


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
            test.info("Please enter your product name");
            if (searchBox.isDisplayed()) {
                searchBox.sendKeys("Headphone");
                passCase("You have successfully entered your product search");
                Thread.sleep(5000);

                try {
                    test.info("Please click search button.");
                    new Actions(driver).moveToElement(searchButton).click().build().perform();
                    passCaseWithSC("Click on the search button", "search_button_success");

                } catch (Exception e) {
                    failCase("Search Box was not Locate ", "search_box_fail");
                }
            }

            }catch(Exception e){
                failCase("Search Button was not Locate ", "search_button_fail");

            }
        }
    }

