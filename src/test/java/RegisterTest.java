import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

public class RegisterTest {

    WebDriver driver;

    @Before
    public void setUp () {
        System.setProperty("webdriver.chrome.driver", "D:\\Webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://shop.pragmatic.bg/");
    }


    @Test
    public void testPositive() {
        WebElement myAccount = driver.findElement(By.cssSelector("ul.list-inline>li>a.dropdown-toggle"));
        myAccount.click();
        WebElement register = driver.findElement(By.cssSelector("ul.dropdown-menu.dropdown-menu-right>li>a[href='http://shop.pragmatic.bg/index.php?route=account/register']"));
        register.click();
        WebElement pageTitle1 = driver.findElement(By.cssSelector(".col-sm-9>h1"));
        assertEquals("This is not the corect page","Account", pageTitle1.getText());

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Maya");
        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("Stoyanova");
        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("maya.stoyanova@yahoo.com");
        WebElement telephone = driver.findElement(By.id("input-telephone"));
        telephone.sendKeys("=00359889786543");
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("may25");
        WebElement confPassword = driver.findElement(By.id("input-confirm"));
        confPassword.sendKeys("may25");

        WebElement confirmNewsletterSubscribe = driver.findElement(By.cssSelector("label.radio-inline>input[value='1']"));
        if (!confirmNewsletterSubscribe.isSelected())
            confirmNewsletterSubscribe.click();
        assertTrue(confirmNewsletterSubscribe.isSelected());


        WebElement agreePrivacyPolicy =driver.findElement(By.cssSelector("a.agree+input[type='checkbox']"));
        if (!agreePrivacyPolicy.isSelected())
            agreePrivacyPolicy.click();
        assertTrue(agreePrivacyPolicy.isSelected());

        WebElement continueBox = driver.findElement(By.cssSelector("input[value='Continue']"));
        continueBox.click();




    }

    @Test
    public void testNegative() {



    }


    @After
    public void tearDown() {
        driver.close();
        driver.quit();

    }
}