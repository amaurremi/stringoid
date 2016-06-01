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

        System.out.println(sb.toString());

        Assertions.shouldContainHttp("if.com?key1=param1");
        Assertions.shouldContainHttp("if.com?key2=param2");
    }
}

// 2 = new SB
// 2 = SB(4)
// conditional branch
//     10 = 2.append(11)
// conditional branch
// 19 = 2.append(14)


// 4 = "http://"
// 11 = "if.com"
// 13 = "key1=param1"
// 18 = "key2=param2"