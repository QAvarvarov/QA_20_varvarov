package com.tr.trelloTests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
  WebDriver wd;

  @BeforeMethod
  public void setUp() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    openSite("https://trello.com/");
    login("elena.telran@yahoo.com", "12345.com");
  }

  @AfterMethod
  public void tearDown() {
    wd.quit();
  }

  //______________________________________________________________________________

  public void openSite(String url) {
    wd.get(url);
  }

  public void login(String email, String pwd) {
    initLogin();
    fillLoginForm(email, pwd);
    confirmLogin();
  }

  public void confirmLogin() {
    click(By.cssSelector("#login[type=submit]"));
  }

  public void fillLoginForm(String email, String password) {
    type(By.xpath("//*[@id='user']"), email);
    type(By.id("password"), password);
  }

  public void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public void initLogin() {
    click(By.xpath("//*[@href='/login']"));
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  protected void submitBoardCreation() {
    click(By.cssSelector("[data-test-id=header-create-board-submit-button]"));
  }

  public void fillBoardCreationForm(String boardName) {
    type(By.cssSelector("input[type=text][autocomplete=off]"), boardName);
  }

  public void selectCreateBoardFromDropDown() {
    click(By.xpath("//*[@role='dialog']//ul//button[1]"));
  }

  public void clickOnPlusButton() {
    click(By.cssSelector("[id=header] button [name=add]"));
  }

  public int getPrivateBoardsCount() {
    return wd.findElements(By.xpath("//span[@class='icon-lg icon-member']/../../..//li")).size()-1;
  }

  public void initBoardDeletion() {
    openMenu();
    clickMoreButtonInTheMenu();
    clickCloseBoardButton();
    confirmCloseButton();
  }

  public void confirmCloseButton() {
    click(By.cssSelector(".js-confirm.full.negate"));
  }

  public void clickCloseBoardButton() {
    click(By.cssSelector(".board-menu-navigation-item-link.js-close-board"));
  }

  public void clickMoreButtonInTheMenu() {
    click(By.cssSelector(".board-menu-navigation-item-link.js-open-more"));
  }

  public void openMenu() {
   if(!isBoardMenuOpened()){
     click(By.cssSelector("a.mod-show-menu span.board-header-btn-text.u-text-underline"));
   }
  }

  public boolean isBoardMenuOpened() {
    return  isElementPresent(By.cssSelector("a.mod-show-menu span.board-header-btn-text.u-text-underline"));
  }

  public void openFirstPrivateBoard() {
    WebElement privateBoardsList = wd.findElement(By.xpath("//span[@class='icon-lg icon-member']/../../..//ul"));
    String boardNameForDelete = privateBoardsList.findElement(By.xpath(".//li")).getText();
    System.out.println(boardNameForDelete);
    privateBoardsList.findElement(By.xpath(".//li")).click();
  }

  public void confirmBoardDeletion() {
    click(By.cssSelector(".js-delete"));
  }

  public void confirmFinishBoardDeletion() {
    click(By.cssSelector(".js-confirm.full"));
  }

  public void returnToHomePage() {
    click(By.cssSelector("[href='/']"));
  }

  public boolean isUserLoggedIn() {
    return isElementPresent(By.cssSelector(".js-open-header-member-menu"));
  }
}
