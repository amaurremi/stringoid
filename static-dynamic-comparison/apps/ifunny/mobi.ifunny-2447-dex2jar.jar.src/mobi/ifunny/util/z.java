package mobi.ifunny.util;

import java.security.MessageDigest;

public class z {
    public static String a(String paramString) {
        MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
        localMessageDigest.reset();
        return a(localMessageDigest.digest(paramString.getBytes("UTF-8")));
    }

    private static String a(byte[] paramArrayOfByte) {
        StringBuilder localStringBuilder = new StringBuilder();
        int j = paramArrayOfByte.length;
        int i = 0;
        while (i < j) {
            localStringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(paramArrayOfByte[i])}));
            i += 1;
        }
        return localStringBuilder.toString();
    }

    public static String b(String paramString) {
        MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
        paramString = paramString.getBytes("UTF-8");
        localMessageDigest.reset();
        localMessageDigest.update(paramString, 0, paramString.length);
        return a(localMessageDigest.digest());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/mobi/ifunny/util/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */