package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.view.MotionEvent;

public class l {
    private String kd = "googleads.g.doubleclick.net";
    private String ke = "/pagead/ads";
    private String[] kf = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private h kg;
    private final g kh = new g();

    public l(h paramh) {
        this.kg = paramh;
    }

    private Uri a(Uri paramUri, Context paramContext, String paramString, boolean paramBoolean)
            throws m {
        try {
            if (paramUri.getQueryParameter("ms") != null) {
                throw new m("Query parameter already exists: ms");
            }
        } catch (UnsupportedOperationException paramUri) {
            throw new m("Provided Uri is not in a valid state");
        }
        if (paramBoolean) {
        }
        for (paramContext = this.kg.a(paramContext, paramString); ; paramContext = this.kg.a(paramContext)) {
            return a(paramUri, "ms", paramContext);
        }
    }

    private Uri a(Uri paramUri, String paramString1, String paramString2)
            throws UnsupportedOperationException {
        String str = paramUri.toString();
        int j = str.indexOf("&adurl");
        int i = j;
        if (j == -1) {
            i = str.indexOf("?adurl");
        }
        if (i != -1) {
            return Uri.parse(str.substring(0, i + 1) + paramString1 + "=" + paramString2 + "&" + str.substring(i + 1));
        }
        return paramUri.buildUpon().appendQueryParameter(paramString1, paramString2).build();
    }

    public Uri a(Uri paramUri, Context paramContext)
            throws m {
        try {
            paramUri = a(paramUri, paramContext, paramUri.getQueryParameter("ai"), true);
            return paramUri;
        } catch (UnsupportedOperationException paramUri) {
            throw new m("Provided Uri is not in a valid state");
        }
    }

    public void a(MotionEvent paramMotionEvent) {
        this.kg.a(paramMotionEvent);
    }

    public boolean a(Uri paramUri) {
        boolean bool2 = false;
        if (paramUri == null) {
            throw new NullPointerException();
        }
        try {
            paramUri = paramUri.getHost();
            String[] arrayOfString = this.kf;
            int j = arrayOfString.length;
            int i = 0;
            for (; ; ) {
                boolean bool1 = bool2;
                if (i < j) {
                    bool1 = paramUri.endsWith(arrayOfString[i]);
                    if (bool1) {
                        bool1 = true;
                    }
                } else {
                    return bool1;
                }
                i += 1;
            }
            return false;
        } catch (NullPointerException paramUri) {
        }
    }

    public h y() {
        return this.kg;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/internal/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */