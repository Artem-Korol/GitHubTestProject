import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainClass {

    static WebDriver driver;

    public static void main(String[] args) {
     System.setProperty("webdriver.chrome.driver", "C:\\Users\\48576\\Desktop\\IntelliJ IDEA\\drivers\\chromedriver.exe");

     driver = new ChromeDriver();
     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     driver.manage().window().maximize();
     driver.get("https://github.com");

     MainPage mainPage = PageFactory.initElements(driver, MainPage.class);

     mainPage.register("loginlogin", "123321test", "qwerty@gmail.com");
    }
}
