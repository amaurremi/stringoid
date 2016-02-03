package com.google.android.gms.internal;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class pu {
    private static final Pattern a = Pattern.compile("\\\\.");
    private static final Pattern b = Pattern.compile("[\\\\\"/\b\f\n\r\t]");

    public static String a(String paramString) {
        Matcher localMatcher;
        Object localObject1;
        if (!TextUtils.isEmpty(paramString)) {
            localMatcher = b.matcher(paramString);
            localObject1 = null;
            while (localMatcher.find()) {
                Object localObject2 = localObject1;
                if (localObject1 == null) {
                    localObject2 = new StringBuffer();
                }
                switch (localMatcher.group().charAt(0)) {
                    default:
                        localObject1 = localObject2;
                        break;
                    case '\b':
                        localMatcher.appendReplacement((StringBuffer) localObject2, "\\\\b");
                        localObject1 = localObject2;
                        break;
                    case '"':
                        localMatcher.appendReplacement((StringBuffer) localObject2, "\\\\\\\"");
                        localObject1 = localObject2;
                        break;
                    case '\\':
                        localMatcher.appendReplacement((StringBuffer) localObject2, "\\\\\\\\");
                        localObject1 = localObject2;
                        break;
                    case '/':
                        localMatcher.appendReplacement((StringBuffer) localObject2, "\\\\/");
                        localObject1 = localObject2;
                        break;
                    case '\f':
                        localMatcher.appendReplacement((StringBuffer) localObject2, "\\\\f");
                        localObject1 = localObject2;
                        break;
                    case '\n':
                        localMatcher.appendReplacement((StringBuffer) localObject2, "\\\\n");
                        localObject1 = localObject2;
                        break;
                    case '\r':
                        localMatcher.appendReplacement((StringBuffer) localObject2, "\\\\r");
                        localObject1 = localObject2;
                        break;
                    case '\t':
                        localMatcher.appendReplacement((StringBuffer) localObject2, "\\\\t");
                        localObject1 = localObject2;
                }
            }
            if (localObject1 != null) {
            }
        } else {
            return paramString;
        }
        localMatcher.appendTail((StringBuffer) localObject1);
        return ((StringBuffer) localObject1).toString();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/pu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */