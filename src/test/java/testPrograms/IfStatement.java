package testPrograms;

public class IfStatement {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("http://");
        if (args[0] == null) {
            sb.append("domain.com?");
        }
        String query = "query1=key1";
        if (args[1] == null) {
            query = "query2=key2";
        }
        sb.append(query);

        String url = sb.toString();
        System.out.println(url);

        Assertions.shouldContainHttp("domain.com?query1=key1");
        Assertions.shouldContainHttp("domain.com?query2=key2");
    }
}
