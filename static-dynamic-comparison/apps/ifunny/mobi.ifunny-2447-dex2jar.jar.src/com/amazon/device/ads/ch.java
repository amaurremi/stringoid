package com.amazon.device.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.Display;

@TargetApi(8)
class ch {
    protected static int a(Display paramDisplay) {
        return paramDisplay.getRotation();
    }

    protected static String a(Context paramContext) {
        return paramContext.getPackageCodePath();
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */