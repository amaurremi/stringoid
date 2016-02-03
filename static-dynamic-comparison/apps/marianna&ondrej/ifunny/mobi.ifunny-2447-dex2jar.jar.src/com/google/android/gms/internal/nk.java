package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsPromptResult;

final class nk
        implements DialogInterface.OnClickListener {
    nk(JsPromptResult paramJsPromptResult) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        this.a.cancel();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/nk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */