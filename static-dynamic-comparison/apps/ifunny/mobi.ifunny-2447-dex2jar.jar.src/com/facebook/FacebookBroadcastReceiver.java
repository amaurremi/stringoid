package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;

public class FacebookBroadcastReceiver
        extends BroadcastReceiver {
    protected void onFailedAppCall(String paramString1, String paramString2, Bundle paramBundle) {
    }

    public void onReceive(Context paramContext, Intent paramIntent) {
        paramContext = paramIntent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
        String str = paramIntent.getStringExtra("com.facebook.platform.protocol.PROTOCOL_ACTION");
        Bundle localBundle;
        if ((paramContext != null) && (str != null)) {
            localBundle = paramIntent.getExtras();
            if (NativeProtocol.isErrorResult(paramIntent)) {
                onFailedAppCall(paramContext, str, localBundle);
            }
        } else {
            return;
        }
        onSuccessfulAppCall(paramContext, str, localBundle);
    }

    protected void onSuccessfulAppCall(String paramString1, String paramString2, Bundle paramBundle) {
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/FacebookBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */