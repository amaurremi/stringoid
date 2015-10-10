package testPrograms;

public class UrlConcatenation {

    public static void main(String[] args) {
        String queryParam2 = "query2";
        String query = String.format("key1=%s,key2=%s", "query1", queryParam2);
        StringBuilder sb = new StringBuilder("http://");
        sb.append("domain.com?");
        sb.append(query);
        System.out.println(sb);

        Assertions.shouldContainUrl("http://", "domain.com?", "key1=", "query1", ",key2=", "query2");
    }
}
