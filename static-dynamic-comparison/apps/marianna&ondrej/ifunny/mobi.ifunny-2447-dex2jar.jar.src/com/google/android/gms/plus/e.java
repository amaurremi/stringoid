package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.m;
import com.google.android.gms.common.api.n;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.h;
import com.google.android.gms.plus.internal.i;

import java.util.Set;

final class e
        implements c<i, f> {
    public int a() {
        return 2;
    }

    public i a(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, f paramf, m paramm, n paramn) {
        Object localObject = paramf;
        if (paramf == null) {
            localObject = new f(null);
        }
        paramf = paramClientSettings.a();
        paramClientSettings = paramClientSettings.c();
        localObject = (String[]) ((f) localObject).b.toArray(new String[0]);
        String str1 = paramContext.getPackageName();
        String str2 = paramContext.getPackageName();
        PlusCommonExtras localPlusCommonExtras = new PlusCommonExtras();
        return new i(paramContext, paramLooper, paramm, paramn, new h(paramf, paramClientSettings, (String[]) localObject, new String[0], str1, str2, null, localPlusCommonExtras));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/plus/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */