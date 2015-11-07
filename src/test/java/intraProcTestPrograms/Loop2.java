package intraProcTestPrograms;

public class Loop2 {

    public static void main(String[] args) {
        while (args[0] == null) {
            StringBuilder sb2 = new StringBuilder("http://");
            sb2.append("loop2.com");
            System.out.println(sb2);
        }

//        Assertions.shouldContainHttp("loop2.com");
    }
}
