package twitter4j;

import java.io.PrintStream;

public final class Version {
    private static final String TITLE = "Twitter4J";
    private static final String VERSION = "3.0.5";

    private Version() {
        throw new AssertionError();
    }

    public static String getVersion() {
        return "3.0.5";
    }

    public static void main(String[] paramArrayOfString) {
        System.out.println("Twitter4J 3.0.5");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/Version.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */