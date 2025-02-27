package jasmin.akter.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import jasmin.akter.pages.CartPage;
import jasmin.akter.pages.LogoutPage;
import jasmin.akter.utilities.CommonMethod;
import jasmin.akter.utilities.ExtentFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class LogoutPage_Test extends CommonMethod {
    ExtentReports extent;
    ExtentTest parentTest;
    ExtentTest childTest;

    @BeforeClass
    public void open_url() throws InterruptedException {
        //PageDriver.getCurrentDriver().get(url);
        //sleep();

        extent = ExtentFactory.getInstance();
        parentTest = extent.createTest("<p style=\"color:Red; font-size:14px\"><b>Logout Page</b></p>").assignAuthor("Jasmin Akter").assignDevice("Windows");
    }

    @Test
    public void daraz_Website() throws IOException, InterruptedException {
        childTest = parentTest.createNode("<p style=\"color:Red; font-size:14px\"><b>Logout Page Click</b></p>");
        LogoutPage logout_Page = new LogoutPage(childTest);
        logout_Page.logout();

    }

    @AfterClass
    public void report(){

        extent.flush();
    }
}
