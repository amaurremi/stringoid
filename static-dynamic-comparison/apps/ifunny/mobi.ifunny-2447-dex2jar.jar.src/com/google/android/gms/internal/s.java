package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;

import java.util.concurrent.Future;

@ii
public class s {
    protected q a(Context paramContext, gt paramgt, ma<q> paramma) {
        paramContext = new v(paramContext, paramgt);
        paramContext.a(new u(this, paramma, paramContext));
        return paramContext;
    }

    public Future<q> a(Context paramContext, gt paramgt, String paramString) {
        ma localma = new ma();
        mv.a.post(new t(this, paramContext, paramgt, localma, paramString));
        return localma;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */