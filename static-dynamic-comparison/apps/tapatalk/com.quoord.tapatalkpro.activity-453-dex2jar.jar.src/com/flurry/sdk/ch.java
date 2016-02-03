package com.flurry.sdk;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.Window;

public final class ch {
    @TargetApi(11)
    public static void a(Window paramWindow) {
        if (paramWindow == null) {
        }
        while (Build.VERSION.SDK_INT < 11) {
            return;
        }
        paramWindow.setFlags(16777216, 16777216);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */