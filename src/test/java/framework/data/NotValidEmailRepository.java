package framework.data;

public class NotValidEmailRepository {
    private NotValidEmailRepository() {}

    public static Credential getDefault() {
        return getNotValidEmail1();
    }

    public static Credential getNotValidEmail1() {
        return new Credential("samplestestgreencitycom", "weyt3$Guew^");
    }

    public static Credential getNotValidEmail2() {
        return new Credential("samplestestgreencity.com", "weyt3$Guew^");
    }

    public static Credential getNotValidEmail3() {
        return new Credential("samplestest@greencitycom", "weyt3$Guew^");
    }

    public static Credential getNotValidEmail4() {
        return new Credential("@samplestestgreencity.com", "weyt3$Guew^");
    }

    public static Credential getNotValidEmail5() {
        return new Credential("samplestestgreencity.com@", "weyt3$Guew^");
    }
}
