package com.google.android.gms.tagmanager;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.CampaignTrackingService;

public final class InstallReferrerService
        extends IntentService {
    CampaignTrackingService Yi;
    Context Yj;

    public InstallReferrerService() {
        super("InstallReferrerService");
    }

    public InstallReferrerService(String paramString) {
        super(paramString);
    }

    private void a(Context paramContext, Intent paramIntent) {
        if (this.Yi == null) {
            this.Yi = new CampaignTrackingService();
        }
        this.Yi.processIntent(paramContext, paramIntent);
    }

    protected void onHandleIntent(Intent paramIntent) {
        String str = paramIntent.getStringExtra("referrer");
        if (this.Yj != null) {
        }
        for (Context localContext = this.Yj; ; localContext = getApplicationContext()) {
            ay.c(localContext, str);
            a(localContext, paramIntent);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/tagmanager/InstallReferrerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */