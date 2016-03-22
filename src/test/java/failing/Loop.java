package failing;

public class Loop {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("http://");
        while (args[0] == null) {
            sb.append("loop.com");
        }
        sb.append("/path");

        System.out.println(sb.toString());

        debug.Assertions.shouldContainHttp("loop.com/path");
        debug.Assertions.shouldContainHttp("loop.com");
    }
}
