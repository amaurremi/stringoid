package com.amazon.device.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

class ce {
    static void a(Context paramContext, String paramString) {
        Intent localIntent = paramContext.getPackageManager().getLaunchIntentForPackage("com.amazon.windowshop");
        if (localIntent != null) {
            localIntent.putExtra("com.amazon.windowshop.refinement.asin", paramString);
            paramContext.startActivity(localIntent);
        }
    }

    static boolean a(Context paramContext) {
        return paramContext.getPackageManager().getLaunchIntentForPackage("com.amazon.windowshop") != null;
    }

    static void b(Context paramContext, String paramString) {
        Intent localIntent = new Intent("android.intent.action.SEARCH");
        localIntent.setComponent(new ComponentName("com.amazon.windowshop", "com.amazon.windowshop.search.SearchResultsGridActivity"));
        localIntent.putExtra("query", paramString);
        try {
            paramContext.startActivity(localIntent);
            return;
        } catch (RuntimeException paramContext) {
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */