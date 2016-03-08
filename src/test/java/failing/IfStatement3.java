package failing;

public class IfStatement3 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("http://if3.com");
//        sb.append("if3.com?");
        String query;
        if (args[1] == null) {
            query = "A,";
        } else {
            query = "B,";
            sb.append(query);
        }
        sb.append(query);

        String url = sb.toString();
        System.out.println(url);

        Assertions.shouldContainHttp("if3.com?A,");
        Assertions.shouldContainHttp("if3.com?A,B");
        Assertions.shouldContainHttp("if3.com?B,B");
    }
}
