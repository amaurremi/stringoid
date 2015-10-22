package intraProcTestPrograms;

public class IfStatement2 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("http://");
        if (args[0] == null) {
            sb.append("if2.com?");
        }
        String query;
        if (args[1] == null) {
            query = "A,";
        } else {
            if (args[0].isEmpty()) {
                query = args[0] == null ? "B," : "C,";
            } else {
                query = "D,";
            }
            sb.append(query);
        }
        sb.append(query);

        String url = sb.toString();
        System.out.println(url);

        Assertions.shouldContainHttp("if2.com?A,");
        Assertions.shouldContainHttp("if2.com?B,B,");
        Assertions.shouldContainHttp("if2.com?B,C,");
    }
}
