package failing;

public class StaticFinalField {

    static final String field = "http://static-final-field.com";

    public static void main(String[] args) {
        f();
    }

    static void f() {
        String x = new StringBuilder().append(field).append("/path").toString();
        Assertions.shouldContainHttp("static-final-field.com/path");
    }
}
