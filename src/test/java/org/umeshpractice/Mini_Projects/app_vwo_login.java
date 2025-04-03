package org.umeshpractice.Mini_Projects;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class app_vmo_login {

    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test

    public void test_login(){


        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();

      // email
        WebElement email = driver.findElement(By.id("login-username"));
        email.sendKeys("umesh.a@zinier.com");

      // Password
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("AmulJhan@10218");

      // Submit

        WebElement button = driver.findElement(By.id("js-login-btn"));
        button.click();

     // Wait
       // Thread.sleep(2000);

     // Verify Error Message

        WebElement errormsg = driver.findElement(By.id("js-notification-box-msg"));
        Assert.assertEquals(errormsg.getText(),"Your email, password, IP address or location did not match");


        driver.quit();



    }





}
