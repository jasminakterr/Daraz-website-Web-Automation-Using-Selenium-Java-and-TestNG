package jasmin.akter.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import jasmin.akter.basedrivers.PageDriver;
import jasmin.akter.pages.LoginPage;
import jasmin.akter.utilities.CommonMethod;
import jasmin.akter.utilities.ExtentFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class LoginPage_Test extends CommonMethod {
    ExtentReports extent;
    ExtentTest parentTest;
    ExtentTest childTest;

    @BeforeClass
    public void open_url() throws InterruptedException {
        PageDriver.getCurrentDriver().get(url);
        sleep();
        extent = ExtentFactory.getInstance();
        parentTest = extent.createTest("<p style=\"color:orange; font-size:13px\"><b>Login Page</b></p>").assignAuthor("Jasmin Akter").assignDevice("Windows");
    }

    @Test
    public void daraz_login() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:orange; font-size:13px\"><b>Login Page Click</b></p>");
        LoginPage login_page = new LoginPage(childTest);
        login_page.login();
    }

    @AfterClass
    public void report(){
        extent.flush();
    }
}



