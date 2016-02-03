package twitter4j.util;

public final class CharacterUtil {
    private CharacterUtil() {
        throw new AssertionError();
    }

    public static int count(String paramString) {
        return paramString.length();
    }

    public static boolean isExceedingLengthLimitation(String paramString) {
        return count(paramString) > 140;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/util/CharacterUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */