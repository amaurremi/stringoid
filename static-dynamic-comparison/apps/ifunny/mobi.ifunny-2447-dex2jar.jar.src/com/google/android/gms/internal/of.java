package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

public class of {
    private static final String[] a;
    private static final Map<String, Integer> b;

    static {
        int i = 0;
        a = new String[]{"text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity"};
        b = new HashMap(a.length);
        while (i < a.length) {
            b.put(a[i], Integer.valueOf(i));
            i += 1;
        }
    }

    public static String a(int paramInt) {
        if ((paramInt < 0) || (paramInt >= a.length)) {
            return null;
        }
        return a[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/of.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */