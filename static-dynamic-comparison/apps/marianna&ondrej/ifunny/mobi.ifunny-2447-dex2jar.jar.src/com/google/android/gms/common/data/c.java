package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.ag;

import java.util.ArrayList;
import java.util.HashMap;

public class c {
    private final String[] a;
    private final ArrayList<HashMap<String, Object>> b;
    private final String c;
    private final HashMap<Object, Integer> d;
    private boolean e;
    private String f;

    private c(String[] paramArrayOfString, String paramString) {
        this.a = ((String[]) ag.a(paramArrayOfString));
        this.b = new ArrayList();
        this.c = paramString;
        this.d = new HashMap();
        this.e = false;
        this.f = null;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/data/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */