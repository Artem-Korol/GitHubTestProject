import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class MainClassTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\48576\\Desktop\\IntelliJ IDEA\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com");
        mainPage = new MainPage(driver);
    }
    @Test
    public void signINTest(){
        LoginPage loginPage = mainPage.clickSignInButton();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }

    @Test
    public void registerFailTest(){
        SignUpPage signUpPage = mainPage.register("testname", "Testpasswoed_123", "testemail@gmail.com");
        String error = signUpPage.getMainErrorText();
        Assert.assertEquals("There were problems creating your account.", error);
    }

    @Test
    public void signUpEmptyUserNameTest(){
        SignUpPage signUpPage = mainPage.register("1", "Testpasswoed_123","fwewfw@gmail.com");
        String error = signUpPage.getUserNameErrorText();
        Assert.assertEquals("Username is not available", error);
    }

    @Test
    public void signUpInvalidEmail(){
        SignUpPage signUpPage = mainPage.register("1", "Testpasswoed_123","fwewfw@@gmail.com");
        String error = signUpPage.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
