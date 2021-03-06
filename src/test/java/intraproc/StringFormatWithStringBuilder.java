package intraproc;

public class StringFormatWithStringBuilder {

    public static void main(String[] args) {
        String queryParam2 = new StringBuilder("param").append("2").toString();
        String query = String.format("key1=%s,key2=%s", "param1", queryParam2);
        StringBuilder sb = new StringBuilder("http://");
        sb.append("sbAndStringFormat.com?");
        sb.append(query);
        String url = sb.toString();
        System.out.println(url);

        Assertions.shouldContainHttp("sbAndStringFormat.com?key1=param1,key2=param2");
    }
}
