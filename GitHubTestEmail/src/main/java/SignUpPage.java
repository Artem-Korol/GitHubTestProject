import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

    WebDriver driver;

    public SignUpPage (WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("//h1[contains(text(),'Create your account')]");
    private By userNameField = By.xpath("//input[@id='user_login']");
    private By emailField = By.xpath("//input[@id='user_email']");
    private By passwordField = By.xpath("//input[@id='user_password']");
    private By mainError = By.xpath("//div[contains(text(),'There were problems creating your account.')]");
//    private By userNameError = By.xpath("//input[@id='user_login']/ancestor::dd//following-sibling::dd]");
    private By userNameError = By.xpath("//body/div/main/div/div/div/form/auto-check/dl/dd[2]");
    private By emailError = By.xpath("//input[@id='user_email']/ancestor::dd//following-sibling::dd");
//    private By passwordError = By.xpath("//input[@id='user_password']/ancestor::dd//following-sibling::dd");
    private By passwordError = By.xpath("//input[@id='user_password']/ancestor::dd//following-sibling::dd");
    private By signUpButton = By.xpath("//button[@id='signup_button']");
   // private By emailSucsefull = By.xpath("//input[@class='form-control input py-1 is-autocheck-successful']");

    public SignUpPage typeUserName(String username){
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }

    public SignUpPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public SignUpPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage registerInvalidCreds (String username, String email, String password) {
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);

    }
    public  String getHeadingText(){
        return driver.findElement(heading).getText();
    }
    public  String getMainErrorText(){
        return driver.findElement(mainError).getText();
    }
    public  String getUserNameErrorText(){
        return driver.findElement(userNameError).getText();
    }
    public  String getPasswordErrorText(){
        return driver.findElement(passwordError).getText();
    }
    public  String getEmailErrorText(){
        return driver.findElement(emailError).getText();
    }
   // public  String getEmailSucsses(){return driver.findElement(emailSucsefull).getText();}
}
