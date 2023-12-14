package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SelCollection {
    public static void main(String[] args) {
        String path = "C:\\Users\\DELL\\Documents\\work pray balance\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize(); //agar tampilan auto maksimal
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com");
        System.out.println("open browser");

        //pengen cari berapa banyak tag input (ditampung di collection)
        List<WebElement> tagInput = driver.findElements(By.xpath("//input[contains(@class, 'form_input')")); //xpathnya pake format gitu
        System.out.println(tagInput.size()); //jumlah ada 2 = uname, pass
        String[] arrayInput = {"standard_user", "secret_sauce"};

        //looping
        for (int i = 0; i < tagInput.size(); i++) {
            tagInput.get(i).sendKeys(arrayInput[i]);
        }

        WebElement btnLogin = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        btnLogin.click();

        //masukkan 3 produk

        List<WebElement> inputProduct = driver.findElements(By.xpath("//button[contains(@class, 'btn_inventory')]"));
        for (int i = 0; i < 3; i++) {
            inputProduct.get(i).click();
        }

        //select all terus delete
        WebElement input = driver.findElement(By.xpath(""));
        input.clear(); //langsung clear
        input.sendKeys(Keys.CONTROL+"A");
        input.sendKeys((Keys.DELETE));


        delay(3);
        driver.quit();
        System.out.println("close browser");
    }
    static void delay(long detik) {
        try { //jeda sebelum close
            Thread.sleep(detik*1000);
        } catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
