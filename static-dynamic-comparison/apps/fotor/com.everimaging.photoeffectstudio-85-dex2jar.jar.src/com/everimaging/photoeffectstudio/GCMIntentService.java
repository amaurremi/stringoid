package com.everimaging.photoeffectstudio;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.everimaging.fotor.push.d;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class GCMIntentService
        extends com.google.android.gcm.a {
    public GCMIntentService() {
        super(new String[]{a.b});
    }

    protected void a(Context paramContext, int paramInt) {
        Log.i("GCMIntentService", "Received deleted messages notification");
        String str = paramInt + " message";
        a.a(paramContext, str);
        d.a(paramContext, str, a.g);
    }

    protected void a(Context paramContext, Intent paramIntent) {
        Log.i("GCMIntentService", "Received message");
        String str = "";
        Bundle localBundle = paramIntent.getExtras();
        paramIntent = str;
        if (!localBundle.isEmpty()) {
            paramIntent = "" + localBundle.getString("message");
        }
        try {
            str = URLDecoder.decode(paramIntent, "utf-8");
            paramIntent = str;
        } catch (UnsupportedEncodingException localUnsupportedEncodingException) {
            for (; ; ) {
                localUnsupportedEncodingException.printStackTrace();
            }
        }
        a.a(paramContext, paramIntent);
        d.a(paramContext, paramIntent, a.g);
    }

    protected void a(Context paramContext, String paramString) {
        Log.i("GCMIntentService", "Device registered: regId = " + paramString);
        b.a(paramContext, paramString);
    }

    protected void b(Context paramContext, String paramString) {
        Log.i("GCMIntentService", "Device unregistered");
        if (com.google.android.gcm.b.j(paramContext)) {
            return;
        }
        Log.i("GCMIntentService", "Ignoring unregister callback");
    }

    public void c(Context paramContext, String paramString) {
        Log.i("GCMIntentService", "Received error: " + paramString);
    }

    protected boolean d(Context paramContext, String paramString) {
        Log.i("GCMIntentService", "Received recoverable error: " + paramString);
        return super.d(paramContext, paramString);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/photoeffectstudio/GCMIntentService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */