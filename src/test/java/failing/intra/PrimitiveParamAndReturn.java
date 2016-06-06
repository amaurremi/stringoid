package failing.intra;

import debug.Assertions;

// todo type abstraction returns int for char's (see FixedPointAppendIrRetriever.idToStringPart)

public class PrimitiveParamAndReturn {

    public static void main(String[] args) {
        String domain = getDomain("http://", 1);
        StringBuilder sb = new StringBuilder(domain);
        sb.append("/path/");
        sb.append(getChar());

        System.out.println(sb);

        Assertions.shouldContainHttp("primitive-param-and-return1.com");
        Assertions.shouldContainHttp("primitive-param-and-return1.com/path/a");
    }
    // 2 = getDomain(3, 4)
    // 6 = new SB
    // 6 = SB(2)
    // 9 = 6.app(10)
    // 13 = getBool
    // 12 = 6.app(13)

    private static String getDomain(String prefix, int num) {
        StringBuilder sb = new StringBuilder(prefix);
        sb.append("primitive-param-and-return").append(num).append(".com");
        return sb.toString();
    }
    // 3 = new SB
    // 3 = SB(1)
    // 8 = 3.app(9)
    // 7 = 8.app(2)
    // 6 = 7.app(12)
    // 14 = 3.toString
    // return 14

    private static char getChar() {
        return 'a';
    }
    // return 1
}
