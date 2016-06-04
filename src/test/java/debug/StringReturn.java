package debug;

public class StringReturn {

    public static void main(String[] args) {
        String domain = getDomain();
        StringBuilder sb = new StringBuilder(domain);
        sb.append("/path");

        System.out.println(sb);

        Assertions.shouldContainHttp("string-return.com");
        Assertions.shouldContainHttp("string-return.com/path");
    }
    // 2 = getDomain
    // 4 = new SB(2)
    // 7 = 4.append 8

    static String getDomain() {
        return "http://string-return.com";
    }
    // return 1
}

