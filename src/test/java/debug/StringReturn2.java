package debug;

public class StringReturn2 {

    public static void main(String[] args) {
        String domain = getDomain();
        StringBuilder sb = new StringBuilder(domain);
        sb.append("/path");

        System.out.println(sb);

        Assertions.shouldContainHttp("string-param-and-return.com");
        Assertions.shouldContainHttp("string-param-and-return.com/path");
    }

    static String getDomain() {
        StringBuilder sb = new StringBuilder("string-param-and-return.com");
        return sb.toString();
    }
}
