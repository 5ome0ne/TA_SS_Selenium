package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

@Ignore
public class LoginTest {

    private static final CharSequence VALID_EMAIL = "ivanhorintest@gmail.com";
    private static final CharSequence VALID_PASSWORD = "ivanhorintestPassword";
    private static final CharSequence INVALID_PASSWORD = "ivanhorintestPasswordWrong";
    private static final long MAX_WAIT_TIME = 10;
    private ChromeDriver driver;

    @BeforeClass
    public void initialize(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(MAX_WAIT_TIME));
    }

    @Test(description = "Verify user is successfully logged in with appropriate credentials")
    public void verifyUserIsSuccessfullyLoggedIn(){
        driver.get("https://training.by");

        WebElement signInButton = driver.findElement(By.className("header-auth__signin"));
        signInButton.click();
        WebElement mailInput = driver.findElement(By.id("username"));
        mailInput.sendKeys(VALID_EMAIL);
        WebElement continueButton = driver.findElement(By.id("kc-login-next"));
        continueButton.click();
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(VALID_PASSWORD);
        WebElement signInButtonOnPasswordWindow = driver.findElement(By.id("kc-login"));
        signInButtonOnPasswordWindow.click();

        WebElement userName = driver.findElement(By.className("user-info__name"));
        Assert.assertTrue(userName.isDisplayed(), "User is not displayed");
    }

    @AfterClass
    public void freeResources(){
        driver.close();
    }
}
