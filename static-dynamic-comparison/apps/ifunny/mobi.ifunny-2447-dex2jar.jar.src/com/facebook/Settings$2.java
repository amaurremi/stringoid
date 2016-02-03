package com.facebook;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

final class Settings$2
        implements Runnable {
    Settings$2(Context paramContext, String paramString, Request.Callback paramCallback) {
    }

    public void run() {
        Response localResponse = Settings.publishInstallAndWaitForResponse(this.val$applicationContext, this.val$applicationId, false);
        if (this.val$callback != null) {
            new Handler(Looper.getMainLooper()).post(new Settings .2 .1 (this, localResponse));
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/Settings$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */