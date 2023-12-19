package framework.test;

import framework.data.Credential;
import framework.data.ValidEmailRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SignInValidEmailTest extends TestRunner{

    private static Stream<Arguments> provideEmails() {
        return Stream.of(
                Arguments.of(ValidEmailRepository.getValidEmail1()),
                Arguments.of(ValidEmailRepository.getValidEmail2()),
                Arguments.of(ValidEmailRepository.getValidEmail3())
        );
    }

    @ParameterizedTest(name = "{index} => credential={0}")
    @MethodSource("provideEmails")
    public void checkEmail(Credential credential) {
        guestFunctions.signIn(credential);

        String actualEmail = driver.findElement(By.id("email")).getAttribute("value");
        String expectedEmail = credential.getEmail();

        Assertions.assertEquals(actualEmail, expectedEmail);
    }
}
