public class UrlConcatenation {

    public static void main(String[] args) {
        String prefix = "http://";
        String domain = args[0];
        String queryParam = "?key=";
        String queryVal = "val";
        System.out.println(prefix + domain + queryParam + queryVal);
    }
}
