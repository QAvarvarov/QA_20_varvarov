package com.tr.trelloTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import packageTest.TestBase;

public class BoardDeletionTests extends TestBase {
  @BeforeMethod
  public void  preconditions(){
    if(!isUserLoggedIn()){
      app.login("elena.telran@yahoo.com", "12345.com");
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
