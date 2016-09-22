package interproc;
public class FieldReadWrite {

    private String url = getDomain();
    private static String fullUrl;

    public static void main(String[] args) {
        FieldReadWrite frw = new FieldReadWrite();
        frw.url = new StringBuilder(frw.url).append("/path1").toString();
        f();

        System.out.println(fullUrl);

        Assertions.shouldContainHttp("field-read-write.com/path1/path2");
    }

    static void f() {
        FieldReadWrite frw = new FieldReadWrite();
        fullUrl = new StringBuilder(frw.url).append("/path2").toString();
    }

    String getDomain() {
        return "http://field-read-write.com";
    }
}
