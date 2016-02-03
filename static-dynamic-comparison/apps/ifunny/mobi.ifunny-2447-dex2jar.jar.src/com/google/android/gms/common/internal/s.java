package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;

public class s {
    private static final Uri a = Uri.parse("http://plus.google.com/");
    private static final Uri b = a.buildUpon().appendPath("circles").appendPath("find").build();

    public static Intent a() {
        Intent localIntent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        localIntent.setPackage("com.google.android.wearable.app");
        return localIntent;
    }

    public static Intent a(String paramString) {
        paramString = Uri.fromParts("package", paramString, null);
        Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        localIntent.setData(paramString);
        return localIntent;
    }

    public static Intent b(String paramString) {
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setData(c(paramString));
        localIntent.setPackage("com.android.vending");
        localIntent.addFlags(524288);
        return localIntent;
    }

    private static Uri c(String paramString) {
        return Uri.parse("market://details").buildUpon().appendQueryParameter("id", paramString).build();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/common/internal/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */