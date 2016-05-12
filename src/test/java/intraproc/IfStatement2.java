package intraproc;

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

// 2 = new SB(4)
// if (...)
//    10 = 2.append(11)
// else
//    13 = 2.append(14)
// 16 = 2.append(17)
