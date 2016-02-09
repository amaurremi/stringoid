package intraProcTestPrograms;

public class StaticField {

    static String url = "http://static-field.com";

    public static void main(String[] args) {
        url = "http://static-field2.com";
        f(url);
        Assertions.shouldContainHttp("static-field.com");
        Assertions.shouldContainHttp("static-field2.com");
    }

    // if method doesn't create URL string but refers to static field that is a URL string, it needs to be analyzed
    static void f(String ignored) {
        new StringBuilder(StaticField.url).append("/path");
        Assertions.shouldContainHttp("static-field.com/path");
        Assertions.shouldContainHttp("static-field2.com/path");
    }
}
