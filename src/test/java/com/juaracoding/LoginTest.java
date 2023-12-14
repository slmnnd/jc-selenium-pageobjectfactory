package com.juaracoding;


import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(url);
        loginPage = new LoginPage();
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Test (priority = 1)
    public void testValidLogin(){
        loginPage.login("Admin", "admin123");
        Assert.assertEquals(loginPage.getTxtDashboard(), "Dashboard");

    }

    @Test (priority = 2)
    public void testInvalidLogin(){
        loginPage.logout();
        loginPage.login("Adminn", "admin1123");
        Assert.assertTrue(loginPage.getTxtDashboard().contains("Invalid"));

    }

    @Test (priority = 3)
    public void testUsernamaNull(){
        loginPage.login("", "admin123");
        Assert.assertEquals(loginPage.getTxtRequired(), "Required");

    }

}
