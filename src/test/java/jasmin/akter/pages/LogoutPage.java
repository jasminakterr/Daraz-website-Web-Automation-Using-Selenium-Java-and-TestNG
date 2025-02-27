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

public class LogoutPage extends CommonMethod {
        ExtentTest test;

        public LogoutPage(ExtentTest test) {
            PageFactory.initElements(PageDriver.getCurrentDriver(), this);
            this.test = test;
        }

        // Locators
        @FindBys({
                @FindBy(xpath = "(//span[@id='myAccountTrigger'])[1]")
        })
        WebElement logout_page;

        @FindBys({
                @FindBy(xpath = "(//a[normalize-space()='Logout'])[1]")
        })
        WebElement logout_button;

        // Screenshot + Report
        public void passCase(String message) {
            test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>" + message + "</b></p>");
        }

        @SuppressWarnings("unused")
        public void passCaseWithSC(String message, String scName) throws IOException {
            test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>" + message + "</b></p>");
            String screenShotPath = Screenshots.capture(PageDriver.getCurrentDriver(), scName);
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + scName + ".png";
            test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
        }

        // Fail
        @SuppressWarnings("unused")
        public void failCase(String message, String scName) throws IOException {
            test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>" + message + "</b></p>");
            Throwable t = new InterruptedException("Exception");
            test.fail(t);
            String screenShotPath = Screenshots.capture(PageDriver.getCurrentDriver(), scName);
            String dest = System.getProperty("user.dir") + "\\screenshots\\" + scName + ".png";
            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
        }

        public void logout() throws IOException {
            try {
                test.info("Please click on My Account page");
                WebDriverWait wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(5));
                new Actions(driver).moveToElement(logout_page).click().build().perform();
                passCaseWithSC("Please click on the My Account button", "logout_page_success");

                test.info("Please click on Logout Button");
                new Actions(driver).moveToElement(logout_button).click().build().perform();
                passCaseWithSC("You successfully logged out", "logout_button_success");
            } catch (Exception e) {
                failCase("An error occurred during logout: " + e.getMessage(), "logout_fail");
            }
        }
    }