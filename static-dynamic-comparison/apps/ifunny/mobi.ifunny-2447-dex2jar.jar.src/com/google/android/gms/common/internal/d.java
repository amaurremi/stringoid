package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

public class d
        implements DialogInterface.OnClickListener {
    private final Activity a;
    private final Fragment b;
    private final Intent c;
    private final int d;

    public d(Activity paramActivity, Intent paramIntent, int paramInt) {
        this.a = paramActivity;
        this.b = null;
        this.c = paramIntent;
        this.d = paramInt;
    }

    public d(Fragment paramFragment, Intent paramIntent, int paramInt) {
        this.a = null;
        this.b = paramFragment;
        this.c = paramIntent;
        this.d = paramInt;
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        try {
            if ((this.c != null) && (this.b != null)) {
                this.b.startActivityForResult(this.c, this.d);
            }
            for (; ; ) {
                paramDialogInterface.dismiss();
                return;
                if (this.c != null) {
                    this.a.startActivityForResult(this.c, this.d);
                }
            }
            return;
        } catch (ActivityNotFoundException paramDialogInterface) {
            Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/internal/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */