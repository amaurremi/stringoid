package interproc;

public class StringBuilderReturn {

    public static void main(String[] args) {
        StringBuilder sb = getStringBuilder();
        sb.append("/path");

        Assertions.shouldContainHttp("string-builder-return.com/path");
    }

    private static StringBuilder getStringBuilder() {
        return new StringBuilder("http://string-builder-return.com");
    }
}
