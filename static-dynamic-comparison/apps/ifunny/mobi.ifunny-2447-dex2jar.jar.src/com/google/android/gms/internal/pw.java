package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class pw {
    public static void a(StringBuilder paramStringBuilder, HashMap<String, String> paramHashMap) {
        paramStringBuilder.append("{");
        Iterator localIterator = paramHashMap.keySet().iterator();
        int i = 1;
        if (localIterator.hasNext()) {
            String str1 = (String) localIterator.next();
            label50:
            String str2;
            if (i == 0) {
                paramStringBuilder.append(",");
                str2 = (String) paramHashMap.get(str1);
                paramStringBuilder.append("\"").append(str1).append("\":");
                if (str2 != null) {
                    break label98;
                }
                paramStringBuilder.append("null");
            }
            for (; ; ) {
                break;
                i = 0;
                break label50;
                label98:
                paramStringBuilder.append("\"").append(str2).append("\"");
            }
        }
        paramStringBuilder.append("}");
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/pw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */