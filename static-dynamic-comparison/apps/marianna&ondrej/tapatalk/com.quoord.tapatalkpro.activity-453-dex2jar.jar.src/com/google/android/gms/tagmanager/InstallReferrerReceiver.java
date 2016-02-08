package com.google.android.gms.tagmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class InstallReferrerReceiver
        extends BroadcastReceiver {
    public void onReceive(Context paramContext, Intent paramIntent) {
        String str = paramIntent.getStringExtra("referrer");
        if ((!"com.android.vending.INSTALL_REFERRER".equals(paramIntent.getAction())) || (str == null)) {
            return;
        }
        ay.bF(str);
        paramIntent = new Intent(paramContext, InstallReferrerService.class);
        paramIntent.putExtra("referrer", str);
        paramContext.startService(paramIntent);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/InstallReferrerReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */