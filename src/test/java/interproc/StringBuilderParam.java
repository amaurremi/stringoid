package interproc;

public class StringBuilderParam {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("http://").append("string-builder-param.com");
        appendPath(sb);

        Assertions.shouldContainHttp("string-builder-param.com/path");
    }

    private static void appendPath(StringBuilder sb) {
        sb.append("/path");
    }
}
