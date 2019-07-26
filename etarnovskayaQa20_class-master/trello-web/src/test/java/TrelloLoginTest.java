import org.testng.annotations.Test;

public class TrelloLoginTest  extends  TestBase{

  @Test
  public void loginTest() throws InterruptedException {
    app.clickLoginButton();
    app.fillLoginForm("elena.telran@yahoo.com", "12345.com");
    app.pause(3000);
    app.confirmLogin();
    app.pause(10000);


  }

}
