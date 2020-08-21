import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignUpWithInvalidEmailTest {
    private WebDriver driver;
    private SignUpPage signUpPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\48576\\Desktop\\IntelliJ IDEA\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/join");
        signUpPage = new SignUpPage(driver);
    }

    @Test
    //No @ or domain
    public void typeInvalidEmail(){
        SignUpPage signUp = signUpPage.typeEmail("plainaddress");
        String error = signUp.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }
    @Test
    //Missing @
    public void typeInvalidEmail1(){
        SignUpPage signUp = signUpPage.typeEmail("email.domain.com");
        String error = signUp.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }
    @Test
    //Missing address
    public void typeInvalidEmail2(){
        SignUpPage signUp = signUpPage.typeEmail("@domain.com");
        String error = signUp.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }
    @Test
    //Garbage
    public void typeInvalidEmail3(){
        SignUpPage signUp = signUpPage.typeEmail("#@%^%#$@#$@#.com");
        String error = signUp.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }
    @Test
    //Copy/paste from address book with name
    public void typeInvalidEmail4(){
        SignUpPage signUp = signUpPage.typeEmail("Joe Smith <email@domain.com>");
        String error = signUp.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }
    @Test
    //Superfluous text
    public void typeInvalidEmail5(){
        SignUpPage signUp = signUpPage.typeEmail("email@domain.com (Joe Smith)");
        String error = signUp.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }
    @Test
    //Two @
    public void typeInvalidEmail6(){
        SignUpPage signUp = signUpPage.typeEmail("email@domain@domain.com");
        String error = signUp.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }
    @Test
    //Leading dot in address
    public void typeInvalidEmail7(){
        SignUpPage signUp = signUpPage.typeEmail(".email@domain.com");
        String error = signUp.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }
    @Test
    //Trailing dot in address
    public void typeInvalidEmail8(){
        SignUpPage signUp = signUpPage.typeEmail("email.@domain.com");
        String error = signUp.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }
    @Test
    //Multiply dot in address
    public void typeInvalidEmail9(){
        SignUpPage signUp = signUpPage.typeEmail("email..email@domain.com");
        String error = signUp.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }
    @Test
    //Unicode chars in address
    public void typeInvalidEmail10(){
        SignUpPage signUp = signUpPage.typeEmail("あいうえお@domain.com");
        String error = signUp.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }
    @Test
    //Leading dash in domain
    public void typeInvalidEmail11(){
        SignUpPage signUp = signUpPage.typeEmail("email@-domain.com");
        String error = signUp.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }
    @Test
    //Leading dot in domain
    public void typeInvalidEmail12(){
        SignUpPage signUp = signUpPage.typeEmail("email@.domain.com");
        String error = signUp.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }
    @Test
    //Invalid IP format
    public void typeInvalidEmail13(){
        SignUpPage signUp = signUpPage.typeEmail("email@111.222.333.44444");
        String error = signUp.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }
    @Test
    //Multiply dot in domain
    public void typeInvalidEmail14(){
        SignUpPage signUp = signUpPage.typeEmail("email@domain..com");
        String error = signUp.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
