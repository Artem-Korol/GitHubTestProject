import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
        private WebDriver driver;

        public MainPage(WebDriver driver) {
            this.driver = driver;
        }
        private By signInButton = By.xpath("//a[contains(text(),'Sign in')]");
        private By singUpButton = By.xpath("//body//header//a[2]");
        private By userNameField = By.xpath("//input[@id='user[login]']");
        private By emailField = By.xpath("//input[@id='user[email]']");
        private By passwordField = By.xpath("//input[@id='user[password]']");
        private By signUpForButton = By.xpath("//button[contains(text(),'Sign up for GitHub')]");


        public LoginPage clickSignInButton() {
         driver.findElement(signInButton).click();
            return new LoginPage(driver);
        }

        public SignUpPage clickSignUpButton() {
            driver.findElement(singUpButton).click();
            return new SignUpPage(driver);
        }

        public SignUpPage clickSignUpForButton() {
            driver.findElement(signUpForButton).click();
            return new SignUpPage(driver);
        }

        public MainPage typeUserName(String username){
            driver.findElement(userNameField).sendKeys(username);
            return this;
        }

        public MainPage typePassword(String password) {
            driver.findElement(passwordField).sendKeys(password);
            return this;
        }
        public MainPage typeEmail(String email) {
            driver.findElement(emailField).sendKeys(email);
            return this;
        }

        public SignUpPage register(String username, String password, String email){
            this.typeUserName(username);
            this.typePassword(password);
            this.typeEmail(email);
            this.clickSignUpForButton();
            return new SignUpPage(driver);
        }
    }