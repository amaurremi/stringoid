package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.b.a;
import com.google.android.gms.b.d;
import com.google.android.gms.b.e;
import com.google.android.gms.b.f;

@ii
public final class fw
        extends e<gb> {
    private static final fw a = new fw();

    private fw() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public static fy a(Activity paramActivity) {
        try {
            if (b(paramActivity)) {
                mx.a("Using AdOverlay from the client jar.");
                return new fj(paramActivity);
            }
            paramActivity = a.c(paramActivity);
            return paramActivity;
        } catch (fx paramActivity) {
            mx.e(paramActivity.getMessage());
        }
        return null;
    }

    private static boolean b(Activity paramActivity) {
        paramActivity = paramActivity.getIntent();
        if (!paramActivity.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            throw new fx("Ad overlay requires the useClientJar flag in intent extras.");
        }
        return paramActivity.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
    }

    private fy c(Activity paramActivity) {
        try {
            a locala = d.a(paramActivity);
            paramActivity = fz.a(((gb) a(paramActivity)).a(locala));
            return paramActivity;
        } catch (RemoteException paramActivity) {
            mx.d("Could not create remote AdOverlay.", paramActivity);
            return null;
        } catch (f paramActivity) {
            mx.d("Could not create remote AdOverlay.", paramActivity);
        }
        return null;
    }

    protected gb b(IBinder paramIBinder) {
        return gc.a(paramIBinder);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/fw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */