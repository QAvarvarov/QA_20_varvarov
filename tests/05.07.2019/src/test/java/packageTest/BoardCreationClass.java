package packageTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationClass extends TestBase
{
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException{
      if(!isUserLoggedIn())
      {
          app.login("972varvarov@gmail.com", "azu185o2");
      }
    }

    private boolean isUserLoggedIn()
    {
        return app.isElementPresent2(By.cssSelector("[href='/]"));
    }

    @Test
    public void testBoardCreationFromHeader() throws InterruptedException
    {
        int before = getBoardsCount();
        app.clickOnPlusButtonOnHeader();
        app.selectCreateBoardFromDropDown();
        app.pause(10000);
        app.typeBoardName("qa20"+System.currentTimeMillis());
        app.confirmBoardCreation();
        app.pause(10000);
        returnToHomePage();
        int after = getBoardsCount();
        Assert.assertEquals(after, before +1);
    }

    private void returnToHomePage() {
        app.click(By.xpath("//span[@name='house']"));

    }


}
