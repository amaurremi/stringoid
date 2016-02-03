package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import org.json.JSONObject;

class fb
        implements DialogInterface.OnClickListener {
    fb(ez paramez) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        ez.b(this.a).b("onStorePictureCanceled", new JSONObject());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/fb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */