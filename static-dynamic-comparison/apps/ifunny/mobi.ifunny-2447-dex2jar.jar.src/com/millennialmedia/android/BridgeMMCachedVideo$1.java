package com.millennialmedia.android;

import android.content.Context;
import org.json.JSONArray;

class BridgeMMCachedVideo$1
        extends AdCache.Iterator {
    BridgeMMCachedVideo$1(BridgeMMCachedVideo paramBridgeMMCachedVideo, Context paramContext, JSONArray paramJSONArray) {
    }

    boolean a(CachedAd paramCachedAd) {
        if (((paramCachedAd instanceof VideoAd)) && (paramCachedAd.d(this.a)) && (!paramCachedAd.a())) {
            this.b.put(paramCachedAd.e());
        }
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/millennialmedia/android/BridgeMMCachedVideo$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */