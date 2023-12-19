package framework.data;

public class CredentialRepository {
    private CredentialRepository() {
    }

    public static Credential getDefault() {
        return getValidEmail1();
    }

    public static Credential getValidEmail1() {
        return new Credential("samplestest@greencity.com", "weyt3$Guew^");
    }

    public static Credential getValidEmail2() {
        return new Credential("sadgmplestest@greencity.com", "weyt3$Guew^");
    }

    public static Credential getValidEmail3() {
        return new Credential("test@multiline.dp.ua", "weyt3$Guew^");
    }
}
