package intraProcTestPrograms;

public class Loop {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("http://");
        while (args[0] == null) {
            sb.append("loop");
        }
        sb.append("loop.com");

        System.out.println(sb.toString());

        Assertions.shouldContainHttp("loop.com");
    }
}
