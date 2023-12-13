package framework.test;

import framework.lib.GuestFunctions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

public abstract class TestRunner {
    private static final String BASE_URL = "https://www.greencity.social/#/ubs";
    private static final Long IMPLICITLY_WAIT_SECONDS = 10L;
    protected static GuestFunctions guestFunctions;
    protected static WebDriver driver;
    @FindBy(css = "app-ubs .ubs-header-sing-in-img")
    private WebElement signInButton;
    @FindBy(xpath = ".//img[@alt='close button']")
    private WebElement closeButton;
    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT_SECONDS));
        driver.manage().window().minimize();

        guestFunctions = new GuestFunctions(driver);
    }

    @BeforeEach
    public void setUpThis() {
        driver.get(BASE_URL);
        signInButton.click();
    }

    @AfterEach
    public void  tearThis() {
        closeButton.click();
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
