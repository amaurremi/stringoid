package com.quoord.tapatalkpro.util;

import org.apache.commons.lang.StringUtils;

public class EmojiFilter {
    public static boolean containsEmoji(String paramString) {
        if (StringUtils.isBlank(paramString)) {
        }
        for (; ; ) {
            return false;
            int j = paramString.length();
            int i = 0;
            while (i < j) {
                if (!isEmojiCharacter(paramString.charAt(i))) {
                    return true;
                }
                i += 1;
            }
        }
    }

    public static String filterEmoji(String paramString) {
        if (!containsEmoji(paramString)) {
            return paramString;
        }
        Object localObject1 = null;
        int j = paramString.length();
        int i = 0;
        for (; ; ) {
            if (i >= j) {
                if (localObject1 != null) {
                    break;
                }
                return "";
            }
            char c = paramString.charAt(i);
            Object localObject2 = localObject1;
            if (isEmojiCharacter(c)) {
                localObject2 = localObject1;
                if (localObject1 == null) {
                    localObject2 = new StringBuilder(paramString.length());
                }
                ((StringBuilder) localObject2).append(c);
            }
            i += 1;
            localObject1 = localObject2;
        }
        if (((StringBuilder) localObject1).length() == j) {
            return paramString;
        }
        return ((StringBuilder) localObject1).toString();
    }

    private static boolean isEmojiCharacter(int paramInt) {
        return (paramInt == 0) || (paramInt == 9) || (paramInt == 10) || (paramInt == 13) || ((paramInt >= 32) && (paramInt <= 55295)) || ((paramInt >= 57344) && (paramInt <= 65531)) || ((paramInt >= 65536) && (paramInt <= 1114111));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/quoord/tapatalkpro/util/EmojiFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */