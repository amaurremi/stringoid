package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

final class LikeActionController$4
        extends BroadcastReceiver {
    public void onReceive(Context paramContext, Intent paramIntent) {
        if (LikeActionController.access$200()) {
            return;
        }
        paramIntent = paramIntent.getAction();
        if ((Utility.areObjectsEqual("com.facebook.sdk.ACTIVE_SESSION_UNSET", paramIntent)) || (Utility.areObjectsEqual("com.facebook.sdk.ACTIVE_SESSION_CLOSED", paramIntent))) {
        }
        for (boolean bool = true; ; bool = false) {
            LikeActionController.access$202(true);
            LikeActionController.access$700().postDelayed(new LikeActionController .4 .1 (this, bool, paramContext),
            100L);
            return;
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/LikeActionController$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */