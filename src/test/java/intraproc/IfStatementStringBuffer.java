package intraproc;

public class IfStatementStringBuffer {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("http://");
        if (args[0] == null) {
            sb.append("ifStringBuffer.com?");
        }
        String query = "key1=param1";
        if (args[1] == null) {
            query = "key2=param2";
        }
        sb.append(query);

        String url = sb.toString();
        System.out.println(url);

        Assertions.shouldContainHttp("ifStringBuffer.com?key1=param1");
        Assertions.shouldContainHttp("ifStringBuffer.com?key2=param2");
    }
}
