package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RecruitmentTest {
    private WebDriver driver;
    private RecruitmentTest recruitmentTest;

    @BeforeClass
    public void startHere(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates";
        driver.get(url);
        recruitmentTest = new RecruitmentTest();
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void testValidAddCandidate(){
        recruitmentTest.formRecruitment("Salma", "Khofiyya", "salmanida@gmail.com");
        Assert.assertEquals(recruitmentTest.getTxtSuccess(), "Success");

    }

    private void testRequired() {
        recruitmentTest.formRecruitment("", "", "");
        Assert.assertEquals(recruitmentTest.getTxtRequired(), "required");
    }


}

