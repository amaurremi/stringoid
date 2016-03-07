package debug;

public class IfStatement2 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("http://");
        if (args[0] == null) {
            sb.append("if2.com/branch1?");
        } else {
            sb.append("if2.com/");
        }
        sb.append("key=val");

        System.out.println(sb.toString());

        Assertions.shouldContainHttp("if2.com/branch1?key=val");
        Assertions.shouldContainHttp("if2.com/key=val");
    }
}
