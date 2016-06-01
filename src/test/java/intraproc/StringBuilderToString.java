package intraproc;

public class StringBuilderToString {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("http://string-builder-to-string.com");
        StringBuilder sb2 = new StringBuilder(sb.toString());
        sb2.append("/path");

        System.out.println(sb2);

        Assertions.shouldContainHttp("string-builder-to-string.com/path");
    }
}

// 2 = new SB
// 2 = SB(4)
// 6 = new SB
// 8 = 2.toString
// 6 = SB(8)
// 11 = 6.append(12)

// 4 -> "http://..."
// 12 -> "path"