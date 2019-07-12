package packageTest;

import org.testng.annotations.Test;


public class TrelloLoginTest extends TestBase
{

    @Test
    public void loginTest() throws InterruptedException{

        //app.init();
        app.clickLoginButton();
        app.fillLoginForm("972varvarov@gmail.com", "azu185o2");
        app.pause(3000);
        app.confirmLogin();
        app.pause(10000);
    }


}
