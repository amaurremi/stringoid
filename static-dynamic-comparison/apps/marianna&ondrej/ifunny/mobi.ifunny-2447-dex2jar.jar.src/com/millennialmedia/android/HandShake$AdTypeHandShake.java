package com.millennialmedia.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.json.JSONObject;

class HandShake$AdTypeHandShake {
    long a = 0L;
    long b = 0L;
    boolean c;

    HandShake$AdTypeHandShake(HandShake paramHandShake) {
    }

    void a(Context paramContext, String paramString) {
        this.a = System.currentTimeMillis();
        c(paramContext, paramString);
    }

    void a(SharedPreferences.Editor paramEditor, String paramString) {
        paramEditor.putLong("handshake_lastvideo_" + paramString, this.a);
        paramEditor.putLong("handshake_videointerval_" + paramString, this.b);
    }

    void a(JSONObject paramJSONObject) {
        if (paramJSONObject == null) {
            return;
        }
        this.b = (paramJSONObject.optLong("videointerval") * 1000L);
    }

    boolean a(long paramLong) {
        return System.currentTimeMillis() - paramLong < HandShake.f(this.d);
    }

    boolean a(Context paramContext) {
        long l = System.currentTimeMillis();
        MMLog.b("HandShake", "canRequestVideo() Current Time:" + l + " Last Video: " + this.a / 1000L + "  Diff: " + (l - this.a) / 1000L + "  Video interval: " + this.b / 1000L);
        return System.currentTimeMillis() - this.a > this.b;
    }

    boolean a(SharedPreferences paramSharedPreferences, String paramString) {
        boolean bool = false;
        if (paramSharedPreferences.contains("handshake_lastvideo_" + paramString)) {
            this.a = paramSharedPreferences.getLong("handshake_lastvideo_" + paramString, this.a);
            bool = true;
        }
        if (paramSharedPreferences.contains("handshake_videointerval_" + paramString)) {
            this.b = paramSharedPreferences.getLong("handshake_videointerval_" + paramString, this.b);
            return true;
        }
        return bool;
    }

    void b(Context paramContext, String paramString) {
        paramContext = paramContext.getSharedPreferences("MillennialMediaSettings", 0);
        if ((paramContext != null) && (paramContext.contains("handshake_lastvideo_" + paramString))) {
            this.a = paramContext.getLong("handshake_lastvideo_" + paramString, this.a);
        }
    }

    void c(Context paramContext, String paramString) {
        paramContext = paramContext.getSharedPreferences("MillennialMediaSettings", 0).edit();
        a(paramContext, paramString);
        paramContext.commit();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/HandShake$AdTypeHandShake.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */