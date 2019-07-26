import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  WebDriver wd;

  public void init() throws InterruptedException {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wd.get("https://trello.com");
    login("elena.telran@yahoo.com", "12345.com");
  }

  public void stop() {
    wd.quit();
  }

  public void pause(int millis) throws InterruptedException {
    Thread.sleep(millis);
  }

  public void confirmLogin() {
    click(By.id("login"));
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public void fillLoginForm(String email, String password) {
    type(By.id("user"), email);
    type(By.name("password"), password);
  }

  public void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public void clickLoginButton() {
    click(By.cssSelector("[href='/login']"));
  }

  public void login(String email, String pwd) throws InterruptedException {
    clickLoginButton();
    fillLoginForm(email, pwd); //"elena.telran@yahoo.com", "12345.com"
    pause(3000);
    confirmLogin();
    pause(10000);
  }

  public  void confirmBoardCreation(){
    click(By.cssSelector("[data-test-id=header-create-board-submit-button]"));
  }

  public void typeBoardName(String boardName) {
    type(By.cssSelector("[data-test-id=header-create-board-title-input]"), boardName);

  }

  public void selectCreateBoardFromDropDown() {
    click(By.cssSelector("[data-test-id=header-create-board-button]"));
  }

  public void clickOnPlusButtonOnHeader() {
    click(By.cssSelector("[name=add]"));
  }

  public boolean isElementPresent1(By locator){
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public boolean isElementPresent2(By locator){
    return  wd.findElements(locator).size()>0;
  }

  public boolean isUserLoggedIn() {
    return isElementPresent2(By.cssSelector("[href='/']"));
  }

  public void returnToHomePage() {
    click(By.cssSelector("[href='/']"));
  }

  public int getPersonalBoardsCount() {
    return  wd.findElements(By.xpath("//span[@class='icon-lg icon-member']/../../..//li")).size()-1;
  }
}
