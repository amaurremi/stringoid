package moretests;

// this example tests that stringoid can construct URLs out of parameters and method-return values
public class Example {

    public static void main(String[] args) {
        String domain = getDomain("http://");
        StringBuilder sb = new StringBuilder(domain);
        // instead of using concatenation with the '+' operator, we have to use StringBuilder's
        // or StringBuffer's append method
        sb.append("/path");

        // to assert that "http://example.com" and "http://example.com/path" are detected by stringoid,
        // we pass them into the `Assertions.shouldContainHttp` method.
        // important: please pass the necessary URL _without_ the "http://" or "https://" prefix.
        // if you do, the analysis will detect it anyway, which could lead to false positives!
        Assertions.shouldContainHttp("example.com");
        Assertions.shouldContainHttp("example.com/path");
    }

    static String getDomain(String prefix) {
        StringBuilder sb = new StringBuilder(prefix);
        sb.append("example.com");
        return sb.toString();
    }
}
