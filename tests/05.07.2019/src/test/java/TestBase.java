

public class TestBase {
    protected void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    protected void confirmLogin() {
        click(By.id("login"));
    }

    public void click(By locator)
    {
        wd.findElement(locator).click();
    }

    protected void fillLoginForm(String email, String password) {
        type(By.id("user"), email);
        type(By.name("password"), password);
    }

    private void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void clickLoginButton()
    {
        click(By.cssSelector("[href='login']"));
    }
}
