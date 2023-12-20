package framework.data;

public class NotValidPasswordRepository {
    public static Credential getDefault() {
        return getNotValidPassword1();
    }

    public static Credential getNotValidPassword1() {
        return new Credential("samplestest@greencity.com", "weytuewfghj");
    }

    public static Credential getNotValidPassword2() {
        return new Credential("samplestest@greencity.com", "weyt$Guew^");
    }

    public static Credential getNotValidPassword3() {
        return new Credential("samplestest@greencity.com", "weyt3Guew");
    }

    public static Credential getNotValidPassword4() {
        return new Credential("samplestest@greencity.com", "weyt3$uew^");
    }
}
