package interProcTestPrograms;

import intraProcTestPrograms.Assertions;

public class InterProc {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("http://");
        sb.append(getDomain());

        System.out.println(sb);

        Assertions.shouldContainHttp("interproc.com");
    }

    static String getDomain() {
        return "interproc.com";
    }
}
