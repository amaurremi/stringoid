package interproc;

public class StringBuilderReturn {

    public static void main(String[] args) {
        StringBuilder sb = getStringBuilder();
        sb.append("/path");

        Assertions.shouldContainHttp("string-builder-return.com/path");
    }
    // 2 = getSB
    // 4 = 2.append(5)

    private static StringBuilder getStringBuilder() {
        return new StringBuilder("http://string-builder-return.com");
    }
    // 1 = new SB
    // 1 = SB(3)
    // return 1
}
