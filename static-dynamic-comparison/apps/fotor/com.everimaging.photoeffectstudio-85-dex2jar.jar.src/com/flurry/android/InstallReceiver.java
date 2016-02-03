package com.flurry.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.flurry.sdk.cy;
import com.flurry.sdk.eo;
import com.flurry.sdk.fe;

public final class InstallReceiver
        extends BroadcastReceiver {
    static final String a = InstallReceiver.class.getSimpleName();

    public void onReceive(Context paramContext, Intent paramIntent) {
        eo.a(4, a, "Received an Install nofication of " + paramIntent.getAction());
        String str = paramIntent.getExtras().getString("referrer");
        eo.a(4, a, "Received an Install referrer of " + str);
        if ((str == null) || (!"com.android.vending.INSTALL_REFERRER".equals(paramIntent.getAction()))) {
            eo.a(5, a, "referrer is null");
            return;
        }
        paramIntent = str;
        if (!str.contains("=")) {
            eo.a(4, a, "referrer is before decoding: " + str);
            paramIntent = fe.c(str);
            eo.a(4, a, "referrer is: " + paramIntent);
        }
        new cy(paramContext).a(paramIntent);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/flurry/android/InstallReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */