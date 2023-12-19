package framework.test;

import framework.data.Credential;
import framework.data.NotValidEmailRepository;
import framework.data.ValidEmailRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;

import java.util.stream.Stream;

public class SignInNotValidEmailTest extends TestRunner{
    private static Stream<Arguments> provideEmails() {
        return Stream.of(
                Arguments.of(NotValidEmailRepository.getNotValidEmail1()),
                Arguments.of(NotValidEmailRepository.getNotValidEmail2()),
                Arguments.of(NotValidEmailRepository.getNotValidEmail3()),
                Arguments.of(NotValidEmailRepository.getNotValidEmail4()),
                Arguments.of(NotValidEmailRepository.getNotValidEmail5())
        );
    }

    @ParameterizedTest(name = "{index} => credential={0}")
    @MethodSource("provideEmails")
    public void checkEmail(Credential credential) {
        guestFunctions.signIn(credential);

        String actual = driver.findElement(By.xpath("//*[@id='email-err-msg']/app-error/div")).getText().trim();
        String incorrectEmailMessage = "Please check if the email is written correctly";

        Assertions.assertEquals(actual, incorrectEmailMessage);
    }
}
