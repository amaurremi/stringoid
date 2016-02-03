package failing;

public class Assertions {

    /**
     * Assert that the analysis should detect a concatenation that produces the given URL with an "http://" prefix.
     * To avoid false positives, url should not contain the "http://" prefix.
     */
    public static void shouldContainHttp(String url) {}
}
