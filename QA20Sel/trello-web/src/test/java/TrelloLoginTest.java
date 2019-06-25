import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TrelloLoginTest
{
    WebDriver wd;

    @BeforeMethod
    public void setUp()
    {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://trello.com/");

    }

    @Test
    public void loginTest() throws InterruptedException {
        //Click LogIn button
        wd.findElement(By.cssSelector("[href='/login']")).click();
        //type Email
        wd.findElement(By.id("user")).sendKeys("TelRanQa20");
        //type password
        wd.findElement(By.id("password")).sendKeys("q1w2e3r4");
        Thread.sleep(3000);//pause
        //confirm logIn
        wd.findElement(By.id("login")).click();
        Thread.sleep(3000);//pause

    }

    @AfterMethod
    public void tearDown()
    {
        wd.quit();
    }

}
