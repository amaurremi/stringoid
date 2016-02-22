package intraproc;

public class IfStatement {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("http://");
        if (args[0] == null) {
            sb.append("if.com?");
        }
        String query = "key1=param1";
        if (args[1] == null) {
            query = "key2=param2";
        }
        sb.append(query);

        String url = sb.toString();
        System.out.println(url);

        Assertions.shouldContainHttp("if.com?key1=param1");
        Assertions.shouldContainHttp("if.com?key2=param2");
    }
}
