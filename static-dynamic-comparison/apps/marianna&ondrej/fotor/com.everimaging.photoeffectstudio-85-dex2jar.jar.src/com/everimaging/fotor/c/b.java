package com.everimaging.fotor.c;

import android.content.Context;
import com.google.analytics.tracking.android.l;
import com.google.analytics.tracking.android.w;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class b {
    public static void a(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap) {
        paramContext = l.a(paramContext);
        paramString1 = w.a(paramString1, paramString2, null, null);
        if ((paramMap != null) && (paramMap.values() != null)) {
            paramString2 = paramMap.keySet().iterator();
            while (paramString2.hasNext()) {
                String str = (String) paramString2.next();
                paramString1.a(str, (String) paramMap.get(str));
            }
        }
        paramContext.a(paramString1.a());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotor/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */