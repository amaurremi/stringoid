package com.amazon.device.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

class AmazonDeviceLauncher {
    static boolean isWindowshopPresent(Context paramContext) {
        return paramContext.getPackageManager().getLaunchIntentForPackage("com.amazon.windowshop") != null;
    }

    static void launchWindowshopDetailPage(Context paramContext, String paramString) {
        Intent localIntent = paramContext.getPackageManager().getLaunchIntentForPackage("com.amazon.windowshop");
        if (localIntent != null) {
            localIntent.putExtra("com.amazon.windowshop.refinement.asin", paramString);
            paramContext.startActivity(localIntent);
        }
    }

    static void launchWindowshopSearchPage(Context paramContext, String paramString) {
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


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/amazon/device/ads/AmazonDeviceLauncher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */