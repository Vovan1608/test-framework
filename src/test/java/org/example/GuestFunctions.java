package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GuestFunctions {
    private WebDriver driver;

    public GuestFunctions(WebDriver driver) {
        this.driver = driver;
    }

    public void signIn (String email, String password) {
        driver.findElement(By.cssSelector("app-ubs .ubs-header-sing-in-img"));
        driver.findElement(By.id("email"));
        driver.findElement(By.id("password"));
        driver.findElement(By.cssSelector(".ubsStyle"));
    }
}
