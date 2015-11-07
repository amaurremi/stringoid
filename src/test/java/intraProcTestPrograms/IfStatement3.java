package intraProcTestPrograms;

public class IfStatement3 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("http://");
        if (args[0] == null) {
            sb.append("if3.com/branch1?");
        }
        sb.append("key=val");

        Assertions.shouldContainHttp("if3.com/branch1?key=val");
        Assertions.shouldContainHttp("key=val");
    }
}
