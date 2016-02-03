package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.Log;

public class fd
        implements DialogInterface.OnClickListener {
    private final int CV;
    private final Intent mIntent;
    private final Activity nS;

    public fd(Activity paramActivity, Intent paramIntent, int paramInt) {
        this.nS = paramActivity;
        this.mIntent = paramIntent;
        this.CV = paramInt;
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        try {
            if (this.mIntent != null) {
                this.nS.startActivityForResult(this.mIntent, this.CV);
            }
            paramDialogInterface.dismiss();
            return;
        } catch (ActivityNotFoundException paramDialogInterface) {
            Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/fd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */