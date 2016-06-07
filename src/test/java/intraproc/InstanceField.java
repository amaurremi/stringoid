package intraproc;

public class InstanceField {

    String url = "http://field";

    public static void main(String[] args) {
        InstanceField instanceField = new InstanceField();
        instanceField.url = "http://field2";
        f(instanceField.url);
    }
    // 2 = new InstanceField
    // putfield 2 = 5
    // 7 = getfield 2
    // f(7)

    // if method doesn't create URL string but refers to static field that is a URL string, it needs to be analyzed
    static void f(String ignored) {
        String url = new InstanceField().url;
        new StringBuilder(url).append(".com/path");
        Assertions.shouldContainHttp("field.com/path");
        Assertions.shouldContainHttp("field2.com/path");
    }
}
