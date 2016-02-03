package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

@ii
public final class fg {
    public static boolean a(Context paramContext, dj paramdj, fv paramfv) {
        if (paramdj == null) {
            mx.e("No intent data for launcher overlay.");
            return false;
        }
        Intent localIntent = new Intent();
        if (TextUtils.isEmpty(paramdj.c)) {
            mx.e("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty(paramdj.d)) {
            localIntent.setDataAndType(Uri.parse(paramdj.c), paramdj.d);
        }
        String[] arrayOfString;
        for (; ; ) {
            localIntent.setAction("android.intent.action.VIEW");
            if (!TextUtils.isEmpty(paramdj.e)) {
                localIntent.setPackage(paramdj.e);
            }
            if (TextUtils.isEmpty(paramdj.f)) {
                break label172;
            }
            arrayOfString = paramdj.f.split("/", 2);
            if (arrayOfString.length >= 2) {
                break;
            }
            mx.e("Could not parse component name from open GMSG: " + paramdj.f);
            return false;
            localIntent.setData(Uri.parse(paramdj.c));
        }
        localIntent.setClassName(arrayOfString[0], arrayOfString[1]);
        try {
            label172:
            mx.d("Launching an intent: " + localIntent);
            paramContext.startActivity(localIntent);
            paramfv.t();
            return true;
        } catch (ActivityNotFoundException paramContext) {
            mx.e(paramContext.getMessage());
        }
        return false;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/fg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */