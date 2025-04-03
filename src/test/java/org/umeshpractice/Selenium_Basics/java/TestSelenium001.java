package org.umeshpractice.Selenium_Basics.java;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestSelenium001 {
    /*
    //Write the code which will execute the perform the ui interactions

    ChromeDriver driver = new ChromeDriver();
    driver.get("https://www.zinier.com/");
    System.out.println(driver.getTitle())

     */


    @Test
    public void test_VerifyzinierLogin() {
        // Write the code which will execute the perform the ui interactions
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.zinier.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        //System.out.println(driver.getPageSource());
        System.out.println("Opened Zinier Company Web Page");
        driver.navigate().to("https://facebook.com");
        driver.navigate().refresh();
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().to("https://brave.com");
        driver.manage().window().minimize();
        driver.close();



    }


}