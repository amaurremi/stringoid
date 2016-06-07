package intraproc;

public class Loop1 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("http://");
        while (args[0] == null) {
            sb.append("loop1.com");
        }

        System.out.println(sb.toString());

        Assertions.shouldContainHttp("loop1.com");
    }
}

// 2 = new SB
// SB(4)
// 8 = arrayload
// 6 = binaryop(eq)
// conditional branch
//     10 = 2.append(11)
// goto 6->2

// 4 = "http://"
// 11 = "loop.com"
// 16 = "/path"