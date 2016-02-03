package twitter4j;

import java.io.PrintStream;

public final class Version {
    private static final String TITLE = "Twitter4J";
    private static final String VERSION = "4.0.2";

    private Version() {
        throw new AssertionError();
    }

    public static String getVersion() {
        return "4.0.2";
    }

    public static void main(String[] paramArrayOfString) {
        System.out.println("Twitter4J 4.0.2");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/Version.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */