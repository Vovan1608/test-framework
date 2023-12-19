package framework.test;

import framework.lib.GuestFunctions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

public abstract class TestRunner {
    private static final String BASE_URL = "https://www.greencity.social/#/ubs";
    protected static GuestFunctions guestFunctions;
    protected static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.manage().window().setSize(new Dimension(1264, 798));

        guestFunctions = new GuestFunctions(driver);
    }

    @BeforeEach
    public void setUpThis() {

    }

    @AfterEach
    public void  tearThis() {

    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
