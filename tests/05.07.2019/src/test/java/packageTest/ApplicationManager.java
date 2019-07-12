package packageTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {


    Board board = new Board();
    WebDriver wd;

    public void init() throws InterruptedException
    {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://trello.com");
        login("972varvarov@gmail.com" , "azu185o2" );
    }

    public void stop()
    {
        wd.quit();
    }

    void pause(int millis) throws InterruptedException
    {
        Thread.sleep(millis);
    }

    void confirmLogin()
    {
        click(By.id("login"));
    }

    void click(By locator)
    {
        wd.findElement(locator).click();
    }

    void fillLoginForm(String email, String password)
    {
        type(By.id("user"), email);
        type(By.name("password"), password);
    }

    public void type(By locator, String text)
    {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    void clickLoginButton()
    {
        click(By.cssSelector("[href='/login']"));
    }

    void clickOnPlusButtonOnHeader()
    {
        click(By.cssSelector("[name=add]"));
    }

    void login(String email, String pwd) throws InterruptedException
    {
        clickLoginButton();
        fillLoginForm(email, pwd); //"elena.telran@yahoo.com", "12345.com"
        pause(3000);
        confirmLogin();
        pause(10000);
    }

    public boolean isElementPresent1 (By locator)
    {
        try {
            wd.findElement(locator);
            return true;
        }
        catch (NoSuchElementException e) {
            return false;
        }

    }

    public boolean isElementPresent2(By locator)
    {
        return wd.findElements(locator).size()>0;

    }
}
