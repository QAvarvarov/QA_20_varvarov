package packageTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


public class TestBase {

    WebDriver wd;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.get("https://trello.com");
        login("972varvarov@gmail.com" , "azu185o2" );

    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

    void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    void confirmLogin() {
        click(By.id("login"));
    }

    void click(By locator)
    {
        wd.findElement(locator).click();
    }

    void fillLoginForm(String email, String password) {
        type(By.id("user"), email);
        type(By.name("password"), password);
    }

    private void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    void clickLoginButton()
    {
        click(By.cssSelector("[href='login']"));
    }

    void confirmBoardCreation(){
        click(By.cssSelector("[data-test-id=header-create-board-submit-button]"));
    }

    void typeBoardName(String boardName) {
        type(By.cssSelector("[data-test-id=header-create-board-title-input]"), boardName);

    }

    void selectCreateBoardFromDropDown() {
        click(By.cssSelector("[data-test-id=header-create-board-button]"));
    }

    void clickOnPlusButtonOnHeader() {
        click(By.cssSelector("[name=add]"));
    }

    void login(String email, String pwd) throws InterruptedException {
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
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    public boolean isElementPresent2(By locator)
    {
        return wd.findElements(locator).size()>0;

    }
}
