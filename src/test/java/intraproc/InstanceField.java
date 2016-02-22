package intraproc;

public class InstanceField {

    String url = "http://field.com";

    public static void main(String[] args) {
        InstanceField instanceField = new InstanceField();
        instanceField.url = "http://field2.com";
        f(instanceField.url);
        Assertions.shouldContainHttp("field.com");
        Assertions.shouldContainHttp("field2.com");
    }

    // if method doesn't create URL string but refers to static field that is a URL string, it needs to be analyzed
    static void f(String ignored) {
        String url = new InstanceField().url;
        new StringBuilder(url).append("/path");
        Assertions.shouldContainHttp("field.com/path");
        Assertions.shouldContainHttp("field2.com/path");
    }
}
