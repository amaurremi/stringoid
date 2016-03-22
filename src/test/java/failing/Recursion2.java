package failing;

public class Recursion2 {

    public static void main(String[] args) {
        String domain = getDomain(1);
        StringBuilder sb = new StringBuilder("http://");
        sb.append(domain);
        sb.append("/path");

        System.out.println(sb);

        interproc.Assertions.shouldContainHttp("recursion-1.com/path");
        interproc.Assertions.shouldContainHttp("recursion-2.com/path");
    }

    static String getDomain(int i) {
        if (i == 0)
            return "recursion-1.com";
        return getDomain2(i - 1);
    }

    static String getDomain2(int i) {
        if (i == 0)
            return "recursion-2.com";
        else if (i == 1)
            return getDomain(i - 1);
        else return getDomain2(i - 1);
    }
}
