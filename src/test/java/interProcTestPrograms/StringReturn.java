package interProcTestPrograms;

import intraProcTestPrograms.Assertions;

public class StringReturn {

    public static void main(String[] args) {
        String domain = getDomain();
        StringBuilder sb = new StringBuilder(domain);
        sb.append("/path");

        System.out.println(sb);

        Assertions.shouldContainHttp("string-return.com");
        Assertions.shouldContainHttp("string-return.com/path");
    }

    static String getDomain() {
        return "http://string-return.com";
    }
}
