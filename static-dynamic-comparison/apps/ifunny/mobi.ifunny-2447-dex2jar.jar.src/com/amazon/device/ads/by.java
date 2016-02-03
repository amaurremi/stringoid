package com.amazon.device.ads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

class by
        implements ca {
    by(bw parambw) {
    }

    public boolean a(String paramString) {
        Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        localIntent.addFlags(268435456);
        try {
            bw.a(this.a).startActivity(localIntent);
            return true;
        } catch (ActivityNotFoundException localActivityNotFoundException) {
            dv.d(bw.a(), "Could not handle intent with URI: %s", new Object[]{paramString});
        }
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/amazon/device/ads/by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */