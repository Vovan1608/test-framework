package framework.test;

import framework.data.Credential;
import framework.data.NotValidPasswordRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.stream.Stream;

public class SignInNotValidPasswordTest extends TestRunner{

    private static Stream<Arguments> providePasswords() {
        return Stream.of(
                Arguments.of(NotValidPasswordRepository.getNotValidPassword1()),
                Arguments.of(NotValidPasswordRepository.getNotValidPassword2()),
                Arguments.of(NotValidPasswordRepository.getNotValidPassword3()),
                Arguments.of(NotValidPasswordRepository.getNotValidPassword4())
        );
    }

    @ParameterizedTest(name = "{index} => credential={0}")
    @MethodSource("providePasswords")
    public void checkEmail(Credential credential) {
        int IMPLICIT_WAITING_SEC = 8;
        String incorrectPasswordMessage = "Bad email or password";

        guestFunctions.signIn(credential);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAITING_SEC));
        String actual = driver.findElement(By.xpath("//div[@class='alert-general-error ng-star-inserted']")).getText().trim();

        Assertions.assertEquals(actual, incorrectPasswordMessage);
    }
}
