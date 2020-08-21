import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }
    private By loginField = By.xpath("//input[@id='login_field']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By signInButton = By.xpath("//input[@name='commit']");
    private By heading = By.xpath("//h1[contains(text(),'Sign in to GitHub')]");
    private By error = By.xpath("//body//div[@id='js-flash-container']//div//div[1]");
    private By createAccLink = By.xpath("//a[contains(text(),'Create an account')]");

    public LoginPage typeUserName (String username){
        driver.findElement(loginField).sendKeys(username);
        return this;
    }

    public LoginPage typePassword (String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage loginWithInvalidCreds(String username, String password){
        this.typeUserName(username);
        this.typePassword(password);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }
    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }

    public String getErrorText(){
        return driver.findElement(error).getText();
    }

    public SignUpPage createAccount(){
        driver.findElement(createAccLink).click();
        return new SignUpPage(driver);
    }

}

