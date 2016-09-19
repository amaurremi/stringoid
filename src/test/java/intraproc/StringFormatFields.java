package intraproc;

public class StringFormatFields {

    String domain = "string-format-fields.com";
    int field2 = 10;
    static String path = "path";

    public static void main(String[] args) {
        StringFormatFields sff = new StringFormatFields();
        sff.domain = "string-format-fields.ca";
        path = "path2";
        String url = String.format("%swww.%s/%s?key=%d", "http://", sff.domain, path, sff.field2);

        System.out.println(url);

        Assertions.shouldContainHttp("www.string-format-fields.com/path?key=10");
        Assertions.shouldContainHttp("www.string-format-fields.ca/path?key=10");
        Assertions.shouldContainHttp("www.string-format-fields.com/path2?key=10");
        Assertions.shouldContainHttp("www.string-format-fields.ca/path2?key=10");
    }
}
