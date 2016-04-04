package interproc;

public class StringReturn3 {

    public static void main(String[] args) {
        String s1 = identity("http://");
        StringBuilder sb = new StringBuilder(s1);
        sb.append("string-return3.com");

        System.out.println(sb);

        debug.Assertions.shouldContainHttp("string-return3.com");
    }

    static String identity(String s) {
        return s;
    }
}
