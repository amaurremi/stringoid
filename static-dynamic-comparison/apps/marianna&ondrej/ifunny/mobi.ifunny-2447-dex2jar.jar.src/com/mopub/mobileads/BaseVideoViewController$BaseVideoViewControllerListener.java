package com.mopub.mobileads;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

abstract interface BaseVideoViewController$BaseVideoViewControllerListener {
    public abstract void onFinish();

    public abstract void onSetContentView(View paramView);

    public abstract void onSetRequestedOrientation(int paramInt);

    public abstract void onStartActivityForResult(Class<? extends Activity> paramClass, int paramInt, Bundle paramBundle);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/mobileads/BaseVideoViewController$BaseVideoViewControllerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */