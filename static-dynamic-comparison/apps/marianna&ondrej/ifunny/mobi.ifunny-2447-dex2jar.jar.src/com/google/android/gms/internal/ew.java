package com.google.android.gms.internal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ew
        implements DialogInterface.OnClickListener {
    ew(ev paramev) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        paramDialogInterface = this.a.b();
        ev.a(this.a).startActivity(paramDialogInterface);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/ew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */