package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.Session;

class SessionTracker$ActiveSessionBroadcastReceiver
        extends BroadcastReceiver {
    private SessionTracker$ActiveSessionBroadcastReceiver(SessionTracker paramSessionTracker) {
    }

    public void onReceive(Context paramContext, Intent paramIntent) {
        if ("com.facebook.sdk.ACTIVE_SESSION_SET".equals(paramIntent.getAction())) {
            paramContext = Session.getActiveSession();
            if (paramContext != null) {
                paramContext.addCallback(SessionTracker.access$100(this.this$0));
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/SessionTracker$ActiveSessionBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */