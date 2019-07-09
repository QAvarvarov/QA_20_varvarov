package packageTest;

import org.testng.annotations.Test;


public class TrelloLoginTest extends TestBase
{

    @Test
    public void loginTest() throws InterruptedException{

        clickLoginButton();
        fillLoginForm("972varvarov@gmail.com", "azu185o2");
        pause(3000);
        confirmLogin();
        pause(10000);
    }


}
