package com.google.android.gms.ads.mediation.admob;

import android.os.Bundle;
import com.google.ads.mediation.NetworkExtras;

@Deprecated
public final class AdMobExtras
        implements NetworkExtras {
    private final Bundle rP;

    public AdMobExtras(Bundle paramBundle) {
        if (paramBundle != null) {
        }
        for (paramBundle = new Bundle(paramBundle); ; paramBundle = null) {
            this.rP = paramBundle;
            return;
        }
    }

    public Bundle getExtras() {
        return this.rP;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/ads/mediation/admob/AdMobExtras.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */