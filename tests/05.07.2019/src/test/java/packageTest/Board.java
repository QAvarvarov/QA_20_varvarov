package packageTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Board
{

    WebDriver wd;
    void click(By locator)
    {
        wd.findElement(locator).click();
    }
    public void type(By locator, String text)
    {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    void confirmBoardCreation()
    {
        click(By.cssSelector("[data-test-id=header-create-board-submit-button]"));
    }

    void typeBoardName(String boardName)
    {
        type(By.cssSelector("[data-test-id=header-create-board-title-input]"), boardName);

    }

    void selectCreateBoardFromDropDown()
    {
        click(By.cssSelector("[data-test-id=header-create-board-button]"));
    }
}
