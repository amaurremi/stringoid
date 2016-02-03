package twitter4j;

class StringUtil {
    private StringUtil() {
        throw new AssertionError();
    }

    public static String join(long[] paramArrayOfLong) {
        StringBuilder localStringBuilder = new StringBuilder(paramArrayOfLong.length * 11);
        int j = paramArrayOfLong.length;
        int i = 0;
        while (i < j) {
            long l = paramArrayOfLong[i];
            if (localStringBuilder.length() != 0) {
                localStringBuilder.append(",");
            }
            localStringBuilder.append(l);
            i += 1;
        }
        return localStringBuilder.toString();
    }

    public static String join(String[] paramArrayOfString) {
        StringBuilder localStringBuilder = new StringBuilder(paramArrayOfString.length * 11);
        int j = paramArrayOfString.length;
        int i = 0;
        while (i < j) {
            String str = paramArrayOfString[i];
            if (localStringBuilder.length() != 0) {
                localStringBuilder.append(",");
            }
            localStringBuilder.append(str);
            i += 1;
        }
        return localStringBuilder.toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/twitter4j/StringUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */