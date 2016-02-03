package com.facebook.android;

import android.os.Bundle;

public abstract interface Facebook$DialogListener {
    public abstract void onCancel();

    public abstract void onComplete(Bundle paramBundle);

    public abstract void onError(DialogError paramDialogError);

    public abstract void onFacebookError(FacebookError paramFacebookError);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/android/Facebook$DialogListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */