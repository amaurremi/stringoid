package com.everimaging.photoeffectstudio;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

public final class a {
    static String a = "http://store.fotor.com/PushSurpport/pushFlow";
    static String b = "163249411645";
    static String c = "GCMDemo";
    static String d = "com.everimaging.gcm.library.DISPLAY_MESSAGE";
    static String e = "message";
    static Class<?> f;
    static int g;
    static String h;
    private static boolean i;
    private static boolean j;

    public static void a(Context paramContext) {
        if (j) {
            com.google.android.gcm.b.d(paramContext);
        }
    }

    static void a(Context paramContext, String paramString) {
        Intent localIntent = new Intent(d);
        localIntent.putExtra(e, paramString);
        paramContext.sendBroadcast(localIntent);
    }

    public static void a(Context paramContext, final String paramString1, String paramString2, Class<?> paramClass, int paramInt, String paramString3) {
        c(paramContext);
        if (j) {
            b = paramString1;
            a = paramString2;
            f = paramClass;
            g = paramInt;
            h = paramString3;
            paramString1 = com.google.android.gcm.b.g(paramContext);
            Log.d(c, "regId:" + paramString1);
            if (paramString1.equals("")) {
                com.google.android.gcm.b.a(paramContext, new String[]{b});
            }
            while (com.google.android.gcm.b.j(paramContext)) {
                return;
            }
            new AsyncTask() {
                protected Void a(Void... paramAnonymousVarArgs) {
                    if (!b.a(this.a, paramString1)) {
                        com.google.android.gcm.b.c(this.a);
                    }
                    return null;
                }
            }.execute(new Void[0]);
            return;
        }
        Log.e(c, "initialized error ,gcm is not avaliable");
    }

    public static void b(Context paramContext) {
        if (j) {
            com.google.android.gcm.b.c(paramContext);
        }
    }

    public static boolean c(Context paramContext) {
        if (!i) {
        }
        try {
            com.google.android.gcm.b.a(paramContext);
            com.google.android.gcm.b.b(paramContext);
            j = true;
            i = true;
            return j;
        } catch (Exception paramContext) {
            for (; ; ) {
                j = false;
                Log.e(c, "gcm error:" + paramContext.getMessage());
            }
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/fotor/com.everimaging.photoeffectstudio-85-dex2jar.jar!/com/everimaging/photoeffectstudio/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */