package interproc;

public class StringParamAndReturn {

    public static void main(String[] args) {
        String domain = getDomain("http://");
        StringBuilder sb = new StringBuilder(domain);
        sb.append("/path");

        System.out.println(sb);

        Assertions.shouldContainHttp("string-param-and-return.com");
        Assertions.shouldContainHttp("string-param-and-return.com/path");
    }

    static String getDomain(String prefix) {
        StringBuilder sb = new StringBuilder(prefix);
        sb.append("string-param-and-return.com");
        return sb.toString();
    }
}
