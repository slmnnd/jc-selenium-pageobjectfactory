package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.RecruitmentPage;
import org.openqa.selenium.WebDriver;

public class MainApp {
    private static WebDriver driver;

    public static void main(String[] args) {

        DriverSingleton.getInstance("chrome");
        driver= DriverSingleton.getDriver();
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(url);

        //call method from pages
        LoginPage loginPage = new LoginPage();
        loginPage.login("Admin", "admin123");
        System.out.println(loginPage.getTxtDashboard());

        //method recruitment
        RecruitmentPage recruitmentPage = new RecruitmentPage();
        recruitmentPage.btnRecruitment();
        recruitmentPage.addCandidate();

        recruitmentPage.formRecruitment("", "Khofiyya", "");
        System.out.println(recruitmentPage.getTxtRequired());

        recruitmentPage.formRecruitment("Salma", "Khofiyya", "salmanida@gmail.com");
        System.out.println(recruitmentPage.getTxtSuccess());

        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();

        //invalid login
        loginPage.logout();
        loginPage.login("adminn", "admin123");
        System.out.println(loginPage.getTxtInvalidLogin());

        //username kosong
        loginPage.login("", "admin123");
        System.out.println(loginPage.getTxtRequired());



        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }
}
