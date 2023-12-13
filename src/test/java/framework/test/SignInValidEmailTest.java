package framework.test;

import framework.data.Credential;
import net.bytebuddy.asm.MemberSubstitution;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SignInValidEmailTest extends TestRunner{
    @FindBy(css = ".ng-star-inserted > h1")
    private WebElement welcomeText;
    @FindBy(css = "h2:nth-child(2)")
    private WebElement signInDetailsText;
    @FindBy(xpath = "//label[@for='email']")
    private WebElement emailLabel;
    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(xpath = "//label[@for='password']")
    private WebElement passwordLabel;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(css = ".ubsStyle")
    private WebElement signInSubmitButton;
    @FindBy(css=".mat-simple-snackbar > span")
    private WebElement result;
    @FindBy(css = ".alert-general-error")
    private WebElement errorMessage;
    @FindBy(xpath = "//div[@id='pass-err-msg']/app-error/div")
    private WebElement errorPasswordLessEightChar;
    @FindBy(xpath = "//div[@class='alert-general-error ng-star-inserted']")
    private WebElement errorPassword;
    @FindBy(xpath = "//*[@id='email-err-msg']/app-error/div")
    private WebElement errorEmail;
    private static Stream<Arguments> provideEmails() {
        return Stream.of(
                Arguments.of(new Credential("samplestest@greencity.com", "weyt3$Guew^"))
        );
    }

    @ParameterizedTest(name = "{index} => email={0}")
    @MethodSource("provideEmails")
    public void checkEmail(Credential credential) {
        guestFunctions.signIn(credential.getEmail(), credential.getPassword());

        assertThat(welcomeText.getText(), is("Welcome back!"));
        assertThat(signInDetailsText.getText(), is("Please enter your details to sign in."));
        assertThat(emailLabel.getText(), is("Email"));
        assertThat(passwordLabel.getText(), is("Password"));
        emailInput.sendKeys(credential.getEmail());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assertThat(emailInput.getAttribute("value"), is(credential.getEmail()));
        passwordInput.sendKeys(credential.getPassword());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assertThat(passwordInput.getAttribute("value"), is(credential.getPassword()));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        signInSubmitButton.click();
    }

}
