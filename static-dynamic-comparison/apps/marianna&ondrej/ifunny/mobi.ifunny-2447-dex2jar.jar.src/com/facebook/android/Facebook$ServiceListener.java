package com.facebook.android;

import android.os.Bundle;

public abstract interface Facebook$ServiceListener {
    public abstract void onComplete(Bundle paramBundle);

    public abstract void onError(Error paramError);

    public abstract void onFacebookError(FacebookError paramFacebookError);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/android/Facebook$ServiceListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */