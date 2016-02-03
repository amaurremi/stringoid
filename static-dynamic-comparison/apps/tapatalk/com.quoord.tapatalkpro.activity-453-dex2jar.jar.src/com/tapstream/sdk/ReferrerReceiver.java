package com.tapstream.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class ReferrerReceiver
        extends BroadcastReceiver {
    private static final String UUID_KEY = "TapstreamSDKUUID";

    public void onReceive(Context paramContext, Intent paramIntent) {
        String str = paramIntent.getStringExtra("referrer");
        if (str != null) {
            paramIntent = "";
        }
        try {
            str = URLDecoder.decode(str, "utf-8");
            paramIntent = str;
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            for (; ; ) {
                localUnsupportedEncodingException.printStackTrace();
            }
        }
        if (paramIntent.length() > 0) {
            paramContext = paramContext.getApplicationContext().getSharedPreferences("TapstreamSDKUUID", 0).edit();
            paramContext.putString("referrer", paramIntent);
            paramContext.commit();
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/tapstream/sdk/ReferrerReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */