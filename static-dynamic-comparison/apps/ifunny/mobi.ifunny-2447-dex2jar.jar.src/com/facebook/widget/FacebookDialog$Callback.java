package com.facebook.widget;

import android.os.Bundle;

public abstract interface FacebookDialog$Callback {
    public abstract void onComplete(FacebookDialog.PendingCall paramPendingCall, Bundle paramBundle);

    public abstract void onError(FacebookDialog.PendingCall paramPendingCall, Exception paramException, Bundle paramBundle);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/widget/FacebookDialog$Callback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */