package com.google.android.gms.internal;

import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class fa
        implements DialogInterface.OnClickListener {
    fa(ez paramez, String paramString1, String paramString2) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        paramDialogInterface = (DownloadManager) ez.a(this.c).getSystemService("download");
        try {
            paramDialogInterface.enqueue(this.c.a(this.a, this.b));
            return;
        } catch (IllegalStateException paramDialogInterface) {
            mx.c("Could not store picture.");
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/fa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */