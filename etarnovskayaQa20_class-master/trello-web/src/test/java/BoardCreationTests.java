import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests  extends TestBase{
  @BeforeMethod
  public void ensurePreconditions() throws InterruptedException {
   if(!app.isUserLoggedIn()){
     app.login("elena.telran@yahoo.com", "12345.com");
   };
  }

  @Test
  public void testBoardCreationFromHeader() throws InterruptedException {
    int before = app.getPersonalBoardsCount();
    app.clickOnPlusButtonOnHeader();
    app.selectCreateBoardFromDropDown();
    app.pause(7000);
    app.typeBoardName("qa20" + System.currentTimeMillis());
    app.confirmBoardCreation();
    app.pause(10000);
    app.returnToHomePage();
    app.pause(7000);

 int after = app.getPersonalBoardsCount();
    Assert.assertEquals(after, before +1);
  }


}
