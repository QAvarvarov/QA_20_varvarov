package com.tr.trelloTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends  TestBase{
  @BeforeMethod
  public void  preconditions(){
    if(!isUserLoggedIn()){
      login("elena.telran@yahoo.com", "12345.com");
    };
  }

  @Test
  public void testPrivateBoardDeletion(){
    int before = getPrivateBoardsCount();
openFirstPrivateBoard();
initBoardDeletion();


    confirmBoardDeletion();//.js-delete
    confirmFinishBoardDeletion();//.js-confirm.full
    returnToHomePage();//[href='/']

    int after = getPrivateBoardsCount();

    Assert.assertEquals(after, before-1);
  }

}
