package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@ii
public class at {
    public static final at a = new at();

    public static at a() {
        return a;
    }

    public av a(Context paramContext, bm parambm) {
        Object localObject = parambm.a();
        long l;
        String str1;
        int i;
        label59:
        boolean bool1;
        int j;
        Location localLocation;
        Bundle localBundle;
        boolean bool2;
        String str2;
        if (localObject != null) {
            l = ((Date) localObject).getTime();
            str1 = parambm.b();
            i = parambm.c();
            localObject = parambm.d();
            if (((Set) localObject).isEmpty()) {
                break label157;
            }
            localObject = Collections.unmodifiableList(new ArrayList((Collection) localObject));
            bool1 = parambm.a(paramContext);
            j = parambm.k();
            localLocation = parambm.e();
            localBundle = parambm.a(AdMobAdapter.class);
            bool2 = parambm.f();
            str2 = parambm.g();
            paramContext = parambm.h();
            if (paramContext == null) {
                break label163;
            }
        }
        label157:
        label163:
        for (paramContext = new bj(paramContext); ; paramContext = null) {
            return new av(4, l, localBundle, i, (List) localObject, bool1, j, bool2, str2, paramContext, localLocation, str1, parambm.j());
            l = -1L;
            break;
            localObject = null;
            break label59;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */