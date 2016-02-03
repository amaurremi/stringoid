package com.google.android.gms.internal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class mf
        implements DialogInterface.OnClickListener {
    mf(md parammd, String paramString) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        md.a(this.b).startActivity(Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", this.a), "Share via"));
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/mf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */