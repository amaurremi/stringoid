package testPrograms;

public class IfStatement {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("http://");
        if (args[0] == null) {
            sb.append("domain.com?");
        }
        String query = "key1=query1";
        if (args[1] == null) {
            query = "key2=query2";
        }
        sb.append(query);

        String url = sb.toString();
        System.out.println(url);

        Assertions.shouldContainHttp("domain.com?key1=query1");
        Assertions.shouldContainHttp("domain.com?key2=query2");
    }
}
