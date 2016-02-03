package com.millennialmedia.android;

import android.content.Context;
import android.view.WindowManager.BadTokenException;
import android.widget.Toast;

class HandShake$3
        implements Runnable {
    HandShake$3(HandShake paramHandShake, Context paramContext, String paramString) {
    }

    public void run() {
        try {
            Toast.makeText(this.a, "Error: " + this.b, 1).show();
            return;
        } catch (WindowManager.BadTokenException localBadTokenException) {
            MMLog.a("HandShake", "Error with toast token", localBadTokenException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/HandShake$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */