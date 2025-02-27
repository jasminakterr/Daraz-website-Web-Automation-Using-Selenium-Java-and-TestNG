package jasmin.akter.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import jasmin.akter.basedrivers.PageDriver;
import jasmin.akter.utilities.CommonMethod;
import jasmin.akter.utilities.Screenshots;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends CommonMethod {
    ExtentTest test;

    public LoginPage(ExtentTest test) {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }

    //Locators
    @FindBys({
            @FindBy(xpath = "//a[contains(text(),'Login')]")
    })
    WebElement login_page;

    @FindBys({
            @FindBy(xpath = "//input[@type ='text']")
    })
    WebElement username;

    @FindBys({
            @FindBy(xpath = "//input[@type ='password']")
    })
    WebElement password;

    @FindBys({
            @FindBy(xpath = "(//button[normalize-space()='LOG IN'])[1]")
    })
    WebElement login_button;

    //Screenshot+Report
    public void passCase(String message) {
        test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>" + message + "</b></p>");
    }

    @SuppressWarnings("unused")
    public void passCaseWithSC(String message, String scName) throws IOException {
        test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>" + message + "</b></p>");
        String screenShotPath = Screenshots.capture(PageDriver.getCurrentDriver(), "" + scName + "");
        String dest = System.getProperty("user.dir") + "\\screenshots\\" + scName + ".png";
        test.info(dest);
        test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
    }

    // Fail
    @SuppressWarnings("unused")
    public void failCase(String message, String scName) throws IOException {
        test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>" + message + "</b></p>");
        Throwable t = new InterruptedException("Exception");
        test.fail(t);
        String screenShotPath = Screenshots.capture(PageDriver.getCurrentDriver(), "" + scName + "");
        String dest = System.getProperty("user.dir") + "\\screenshots\\" + "" + scName + ".png";
        test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
        PageDriver.getCurrentDriver().quit();
    }

    public void login() throws IOException {
        try {
            test.info("Please click on Login page");
            if (login_page.isDisplayed()) {
                login_page.click();
                Thread.sleep(5000);
                passCaseWithSC("Please enter your username & password", "login_page_success");
            }
            try {
                test.info("Please enter your username");
                if (username.isDisplayed()) {
                    username.sendKeys("terrablossomm@gmail.com");
                    passCase("You have successfully entered your username");
                    Thread.sleep(5000);

                    try {
                        test.info("Please enter your password");
                        if (password.isDisplayed()) {
                            password.sendKeys("jasmin@12345");
                            passCase("You have successfully entered your password");
                            Thread.sleep(5000);

                            try {
                                test.info("Please click on Login Button");
                                if (login_button.isDisplayed()) {
                                    login_button.click();
                                    Thread.sleep(5000);
                                    passCaseWithSC("You successfully logged in", "login_button_success");
                                }
                            } catch (Exception e) {
                                failCase("Login Button was not locateable. Please check the log", "login_button_fail");
                            }
                        }
                    } catch (Exception e) {
                        failCase("Password was not locateable. Please check the log", "password_fail");
                    }

                }
            } catch (Exception e) {
                failCase("User name was not locateable. Please check the log", "user_name_fail");
            }
        } catch (Exception e) {
            failCase("Login Page was not locateable. Please check the page", "login_page_fail");
        }
    }

}
