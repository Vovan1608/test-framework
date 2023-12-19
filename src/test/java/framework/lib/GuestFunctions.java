package framework.lib;

import framework.data.Credential;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GuestFunctions {
    private final WebDriver driver;

    public GuestFunctions(WebDriver driver) {
        this.driver = driver;
    }

    public void signIn (Credential credential) {
        driver.findElement(By.cssSelector("app-ubs .ubs-header-sing-in-img")).click();
        driver.findElement(By.id("email")).sendKeys(credential.getEmail());
        driver.findElement(By.id("password")).sendKeys(credential.getPassword());
        driver.findElement(By.cssSelector(".ubsStyle")).click();
    }
}
