package com.google.android.gms.internal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.JsPromptResult;
import android.widget.EditText;

final class nm
        implements DialogInterface.OnClickListener {
    nm(JsPromptResult paramJsPromptResult, EditText paramEditText) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        this.a.confirm(this.b.getText().toString());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/nm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */