package com.facebook;

import android.app.Activity;
import android.content.Intent;

abstract interface Session$StartActivityDelegate {
    public abstract Activity getActivityContext();

    public abstract void startActivityForResult(Intent paramIntent, int paramInt);
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/Session$StartActivityDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */