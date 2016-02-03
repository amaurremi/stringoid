package com.flurry.sdk;

import android.text.TextUtils;

import java.io.File;

public class ce {
    public static File a(String paramString) {
        return new File(fd.b(true).getPath() + File.separator + ".fcaches" + File.separator + paramString);
    }

    public static File b(String paramString) {
        return new File(fd.a(true).getPath() + File.separator + ".fcaches" + File.separator + paramString);
    }

    public static String c(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            return null;
        }
        return String.format("%016x", new Object[]{Long.valueOf(fe.g(paramString))}).trim();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/flurry/sdk/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */