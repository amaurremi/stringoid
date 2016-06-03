package debug;

public class Loop {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("http://");
        while (args[0] == null) {
            sb.append("loop.com");
        }
        sb.append("/path");

        System.out.println(sb.toString());

//        Assertions.shouldContainHttp("loop.com/path");
        Assertions.shouldContainHttp("loop.com");
    }
}

// 2 = new SB
// SB(4)
// 8 = arrayload
// 6 = binaryop(eq)
// conditional branch
//     10 = 2.append(11)
// goto 6->2
// 15 = 2.append(16)

// 4 = "http://"
// 11 = "loop.com"
// 16 = "/path"