import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchWikiTest
{
    WebDriver wd;

    @BeforeMethod
    public void setUp()
    {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://en.wikipedia.org/wiki/Wiki");

    }

    @Test
    public void search()
    {


        wd.findElement(By.id("searchInput")).sendKeys("text");

        wd.findElement(By.id("searchButton")).click();

    }

    @AfterMethod
    public void tearDown()
    {
        wd.quit();
    }
}
