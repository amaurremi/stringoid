package com.amazon.device.ads;

import android.util.Log;

import java.util.Iterator;

class dx
        implements dm {
    public void a(String paramString1, String paramString2) {
        paramString2 = dv.a(paramString2, 1000).iterator();
        while (paramString2.hasNext()) {
            Log.i(paramString1, (String) paramString2.next());
        }
    }

    public void a(String paramString1, String paramString2, Object... paramVarArgs) {
        a(paramString1, String.format(paramString2, paramVarArgs));
    }

    public void b(String paramString1, String paramString2) {
        paramString2 = dv.a(paramString2, 1000).iterator();
        while (paramString2.hasNext()) {
            Log.v(paramString1, (String) paramString2.next());
        }
    }

    public void b(String paramString1, String paramString2, Object... paramVarArgs) {
        c(paramString1, String.format(paramString2, paramVarArgs));
    }

    public void c(String paramString1, String paramString2) {
        paramString2 = dv.a(paramString2, 1000).iterator();
        while (paramString2.hasNext()) {
            Log.d(paramString1, (String) paramString2.next());
        }
    }

    public void c(String paramString1, String paramString2, Object... paramVarArgs) {
        d(paramString1, String.format(paramString2, paramVarArgs));
    }

    public void d(String paramString1, String paramString2) {
        paramString2 = dv.a(paramString2, 1000).iterator();
        while (paramString2.hasNext()) {
            Log.w(paramString1, (String) paramString2.next());
        }
    }

    public void d(String paramString1, String paramString2, Object... paramVarArgs) {
        e(paramString1, String.format(paramString2, paramVarArgs));
    }

    public void e(String paramString1, String paramString2) {
        paramString2 = dv.a(paramString2, 1000).iterator();
        while (paramString2.hasNext()) {
            Log.e(paramString1, (String) paramString2.next());
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/dx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */