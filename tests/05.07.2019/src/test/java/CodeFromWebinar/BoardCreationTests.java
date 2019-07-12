package com.tr.trelloTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import packageTest.TestBase;

public class BoardCreationTests extends TestBase {
  @Test
          public void testBoardCreation(){
    int before = getPrivateBoardsCount();
    clickOnPlusButton();
    app.selectCreateBoardFromDropDown();
    fillBoardCreationForm("qa20");
    submitBoardCreation();
    returnToHomePage();
    int after = getPrivateBoardsCount();

    Assert.assertEquals(after, before + 1);

  }

  @Test
  public void testBoardCreationLongName(){
    clickOnPlusButton();
    app.selectCreateBoardFromDropDown();
    fillBoardCreationForm("qa20 with Veery Long Name Ha Ho");
    submitBoardCreation();
  }


}
