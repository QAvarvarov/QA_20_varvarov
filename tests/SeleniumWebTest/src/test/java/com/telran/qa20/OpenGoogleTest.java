package com.telran.qa20;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenGoogleTest
{
    WebDriver driver;
    @BeforeMethod
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");

    }

    @Test
    public void testGoogle()
    {
        System.out.println("Google is open");//sout
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();

    }





}
