package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.view.MotionEvent;

public class pv {
    private String a = "googleads.g.doubleclick.net";
    private String b = "/pagead/ads";
    private String c = "ad.doubleclick.net";
    private String[] d = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private le e;

    public pv(le paramle) {
        this.e = paramle;
    }

    private Uri a(Uri paramUri, Context paramContext, String paramString, boolean paramBoolean) {
        boolean bool;
        try {
            bool = a(paramUri);
            if (bool) {
                if (!paramUri.toString().contains("dc_ms=")) {
                    break label64;
                }
                throw new qu("Parameter already exists: dc_ms");
            }
        } catch (UnsupportedOperationException paramUri) {
            throw new qu("Provided Uri is not in a valid state");
        }
        if (paramUri.getQueryParameter("ms") != null) {
            throw new qu("Query parameter already exists: ms");
        }
        label64:
        if (paramBoolean) {
        }
        for (paramContext = this.e.a(paramContext, paramString); bool; paramContext = this.e.a(paramContext)) {
            return b(paramUri, "dc_ms", paramContext);
        }
        paramUri = a(paramUri, "ms", paramContext);
        return paramUri;
    }

    private Uri a(Uri paramUri, String paramString1, String paramString2) {
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

    private Uri b(Uri paramUri, String paramString1, String paramString2) {
        String str = paramUri.toString();
        int i = str.indexOf(";adurl");
        if (i != -1) {
            return Uri.parse(str.substring(0, i + 1) + paramString1 + "=" + paramString2 + ";" + str.substring(i + 1));
        }
        paramUri = paramUri.getEncodedPath();
        i = str.indexOf(paramUri);
        return Uri.parse(str.substring(0, paramUri.length() + i) + ";" + paramString1 + "=" + paramString2 + ";" + str.substring(paramUri.length() + i));
    }

    public Uri a(Uri paramUri, Context paramContext) {
        try {
            paramUri = a(paramUri, paramContext, paramUri.getQueryParameter("ai"), true);
            return paramUri;
        } catch (UnsupportedOperationException paramUri) {
            throw new qu("Provided Uri is not in a valid state");
        }
    }

    public le a() {
        return this.e;
    }

    public void a(MotionEvent paramMotionEvent) {
        this.e.a(paramMotionEvent);
    }

    public boolean a(Uri paramUri) {
        if (paramUri == null) {
            throw new NullPointerException();
        }
        try {
            boolean bool = paramUri.getHost().equals(this.c);
            return bool;
        } catch (NullPointerException paramUri) {
        }
        return false;
    }

    public boolean b(Uri paramUri) {
        boolean bool2 = false;
        if (paramUri == null) {
            throw new NullPointerException();
        }
        try {
            paramUri = paramUri.getHost();
            String[] arrayOfString = this.d;
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
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/pv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */