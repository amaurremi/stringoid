package com.everimaging.fotorsdk.collage;

import android.content.Context;
import com.everimaging.fotorsdk.FotorSDKInitiator;
import com.everimaging.fotorsdk.store.h;

public class e {
    private static boolean a = false;

    public static final void a(Context paramContext) {
        if (!a) {
            a = true;
            FotorSDKInitiator.a(paramContext);
            h.a(paramContext);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/collage/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */