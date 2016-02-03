package com.everimaging.fotorsdk.engine;

import android.content.Context;
import android.content.Intent;

public class d {
    public static void a(Context paramContext, int paramInt) {
        String str = paramContext.getPackageName() + ".permission.MODULE_CHANGED_RECIVER";
        Intent localIntent = new Intent("com.everimaging.android.ACTION_MODULE_CHANGED");
        localIntent.putExtra("extra_key", paramInt);
        paramContext.sendBroadcast(localIntent, str);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/fotorsdk/engine/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */