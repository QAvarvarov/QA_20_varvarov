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
          login("972varvarov@gmail.com", "azu185o2");
      }
    }

    private boolean isUserLoggedIn()
    {
        return isElementPresent2(By.cssSelector("[href='/]"));
    }

    @Test
    public void testBoardCreationFromHeader() throws InterruptedException
    {
        int before = getBoardsCount();
        clickOnPlusButtonOnHeader();
        selectCreateBoardFromDropDown();
        pause(10000);
        typeBoardName("qa20"+System.currentTimeMillis());
        confirmBoardCreation();
        pause(10000);
        returnToHomePage();
        int after = getBoardsCount();
        Assert.assertEquals(after, before +1);
    }

    private void returnToHomePage() {
        click(By.xpath("//span[@name='house']"));

    }

    private int getBoardsCount()
    {
         return wd.findElements(By.xpath("//span[@class='icon-lg icon-member']/../../..//li")).size();
    }







}
