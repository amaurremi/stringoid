package twitter4j.internal.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class z_T4JInternalStringUtil {
    private z_T4JInternalStringUtil() {
        throw new AssertionError();
    }

    public static String join(List<String> paramList) {
        StringBuilder localStringBuilder = new StringBuilder(paramList.size() * 11);
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
            String str = (String) paramList.next();
            if (localStringBuilder.length() != 0) {
                localStringBuilder.append(",");
            }
            localStringBuilder.append(str);
        }
        return localStringBuilder.toString();
    }

    public static String join(int[] paramArrayOfInt) {
        StringBuilder localStringBuilder = new StringBuilder(paramArrayOfInt.length * 11);
        int j = paramArrayOfInt.length;
        int i = 0;
        while (i < j) {
            int k = paramArrayOfInt[i];
            if (localStringBuilder.length() != 0) {
                localStringBuilder.append(",");
            }
            localStringBuilder.append(k);
            i += 1;
        }
        return localStringBuilder.toString();
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

    public static String maskString(String paramString) {
        StringBuilder localStringBuilder = new StringBuilder(paramString.length());
        int i = 0;
        while (i < paramString.length()) {
            localStringBuilder.append("*");
            i += 1;
        }
        return localStringBuilder.toString();
    }

    public static String[] split(String paramString1, String paramString2) {
        int i = paramString1.indexOf(paramString2);
        if (i == -1) {
            return new String[]{paramString1};
        }
        ArrayList localArrayList = new ArrayList();
        int j = 0;
        while (i != -1) {
            localArrayList.add(paramString1.substring(j, i));
            j = i + paramString2.length();
            i = paramString1.indexOf(paramString2, j);
        }
        if (j != paramString1.length()) {
            localArrayList.add(paramString1.substring(j));
        }
        return (String[]) localArrayList.toArray(new String[localArrayList.size()]);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/twitter4j/internal/util/z_T4JInternalStringUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */