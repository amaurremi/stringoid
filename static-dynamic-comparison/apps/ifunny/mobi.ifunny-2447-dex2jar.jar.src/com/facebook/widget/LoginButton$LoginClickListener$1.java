package com.facebook.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.Session;

class LoginButton$LoginClickListener$1
        implements DialogInterface.OnClickListener {
    LoginButton$LoginClickListener$1(LoginButton.LoginClickListener paramLoginClickListener, Session paramSession) {
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
        this.val$openSession.closeAndClearTokenInformation();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/LoginButton$LoginClickListener$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */