package org.umeshpractice.Mini_Projects;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class katalon_ETOE_Automation {

    @Description("Testing of the Katalon Website , Appointment Booking & Verify Booked Appointment")
    @Test
  //  @Severity(Blocker)
    @Owner("Umesh A")
    @Link(name = "Katalon website", url = "https://katalon-demo-cura.herokuapp.com/")




    public void test_Booking() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();


        //Make Appointment Button
        WebElement Make_App_Button = driver.findElement(By.id("btn-make-appointment"));
        Make_App_Button.click();

        //Adding Value to User Name field
        WebElement User_name = driver.findElement(By.id("txt-username"));
        User_name.sendKeys("John Doe");

        //Adding Value to Password field
        List<WebElement> Pwd = driver.findElements(By.xpath("//input[@placeholder=\"Password\"]"));
        Pwd.get(1).sendKeys("ThisIsNotAPassword");

        //Click on Login

        WebElement Login = driver.findElement(By.xpath("//button[@class=\"btn btn-default\"]"));
        Login.click();

        Thread.sleep(2000);

        //Make Appointment Page Verification
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");
        System.out.println(driver.getCurrentUrl());


        WebElement drop_down = driver.findElement(By.xpath("//option[@value=\"Seoul CURA Healthcare Center\"]"));
        drop_down.click();

        WebElement check_box_select = driver.findElement(By.name("hospital_readmission"));
        check_box_select.click();

        List<WebElement> radio_select = driver.findElements(By.xpath("//input[@name=\"programs\"]"));
        radio_select.get(1).click();

        WebElement Select_date = driver.findElement(By.id("txt_visit_date"));
        Select_date.sendKeys("01/04/2024");

        WebElement comment = driver.findElement(By.name("comment"));
        comment.sendKeys("Automation testing of the Katalon Website");

        Thread.sleep(2000);

        WebElement Book= driver.findElement(By.xpath("//button[@type = \"submit\"]"));
        Book.click();


        //Appointment Confirmation Done page
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/appointment.php#summary");
        System.out.println(driver.getCurrentUrl());


        WebElement Hamburger = driver.findElement(By.xpath("//a[@class=\"btn btn-dark btn-lg toggle\"]"));
        Hamburger.click();

        Thread.sleep(2000);

        WebElement Logout = driver.findElement(By.xpath("//a[@href=\"authenticate.php?logout\"]"));
        Logout.click();

        //Verify user lands on Homepage

        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/");
        System.out.println(driver.getCurrentUrl());

        Thread.sleep(2000);
        driver.quit();




    }

}
