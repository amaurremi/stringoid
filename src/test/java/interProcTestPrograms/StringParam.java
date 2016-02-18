package interProcTestPrograms;

import intraProcTestPrograms.Assertions;

public class StringParam {

    public static void main(String[] args) {
        f("http://");
    }

    static void f(String prefix) {
        StringBuilder sb = new StringBuilder(prefix);
        sb.append("string-param.com");
        System.out.println(sb);

        Assertions.shouldContainHttp("string-param.com");
    }
}
