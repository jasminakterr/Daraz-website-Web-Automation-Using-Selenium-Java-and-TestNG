package jasmin.akter.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import jasmin.akter.pages.LogoutPage;
import jasmin.akter.pages.SearchProductPage;
import jasmin.akter.utilities.CommonMethod;
import jasmin.akter.utilities.ExtentFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchProductPage_Test extends CommonMethod {
    ExtentReports extent;
    ExtentTest parentTest;
    ExtentTest childTest;

    @BeforeClass
    public void open_url() throws InterruptedException {
        //PageDriver.getCurrentDriver().get(url);
        //sleep();

        extent = ExtentFactory.getInstance();
        parentTest = extent.createTest("<p style=\"color:blue; font-size:14px\"><b>Search Product Page</b></p>").assignAuthor("Jasmin Akter").assignDevice("Windows");
    }

    @Test
    public void daraz_Website_search() throws IOException, InterruptedException {
        childTest = parentTest.createNode("<p style=\"color:blue; font-size:14px\"><b>Search Product Page Click</b></p>");
        SearchProductPage search_Page = new SearchProductPage(childTest);
        search_Page.cart();

    }

    @AfterClass
    public void report(){

        extent.flush();
    }
}
