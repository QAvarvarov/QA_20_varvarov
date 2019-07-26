package packageTest;


import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase {

    ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() throws InterruptedException
    {
        app.init();

    }

    @AfterMethod
    public void tearDown()
    {
        app.stop();
    }

    protected int getBoardsCount()
    {
         return app.wd.findElements(By.xpath("//span[@class='icon-lg icon-member']/../../..//li")).size();
    }
}
