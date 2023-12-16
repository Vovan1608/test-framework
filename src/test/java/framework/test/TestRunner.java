package framework.test;

import framework.lib.GuestFunctions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestRunner {
    private static final String BASE_URL = "https://www.greencity.social/#/ubs";
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    protected static GuestFunctions guestFunctions;
    protected static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(180));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(100));
        driver.manage().window().maximize();

        guestFunctions = new GuestFunctions(driver);
    }

    @BeforeEach
    public void setUpThis() {
        driver.get(BASE_URL);
        System.out.println("BeforeEach executed");
    }

    @AfterEach
    public void  tearThis() {

    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }

        System.out.println("AfterAll executed");
    }
}
