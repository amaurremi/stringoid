package intraproc;

public class StringBuilderToString {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("http://string-builder-to-string.com");
        StringBuilder sb2 = new StringBuilder(sb.toString());
        sb2.append("/path");

        System.out.println(sb2);

        Assertions.shouldContainHttp("string-builder-to-string.com/path");
    }
}
