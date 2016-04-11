package interproc;

public class Recursion {

    public static void main(String[] args) {
        String domain = getDomain(1);
        StringBuilder sb = new StringBuilder();
        sb.append(domain);

        System.out.println(sb);

        Assertions.shouldContainHttp("recursion.com");
    }

    static String getDomain(int i) {
        if (i == 0)
            return "http://recursion.com";
        return getDomain(i - 1);
    }
}
