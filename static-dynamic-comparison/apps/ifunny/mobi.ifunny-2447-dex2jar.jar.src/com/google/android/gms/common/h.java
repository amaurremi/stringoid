package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.g;
import android.support.v4.app.q;
import com.google.android.gms.common.internal.ag;

public class h
        extends g {
    private Dialog j = null;
    private DialogInterface.OnCancelListener k = null;

    public static h a(Dialog paramDialog, DialogInterface.OnCancelListener paramOnCancelListener) {
        h localh = new h();
        paramDialog = (Dialog) ag.a(paramDialog, "Cannot display null dialog");
        paramDialog.setOnCancelListener(null);
        paramDialog.setOnDismissListener(null);
        localh.j = paramDialog;
        if (paramOnCancelListener != null) {
            localh.k = paramOnCancelListener;
        }
        return localh;
    }

    public Dialog a(Bundle paramBundle) {
        if (this.j == null) {
            c(false);
        }
        return this.j;
    }

    public void a(q paramq, String paramString) {
        super.a(paramq, paramString);
    }

    public void onCancel(DialogInterface paramDialogInterface) {
        if (this.k != null) {
            this.k.onCancel(paramDialogInterface);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */