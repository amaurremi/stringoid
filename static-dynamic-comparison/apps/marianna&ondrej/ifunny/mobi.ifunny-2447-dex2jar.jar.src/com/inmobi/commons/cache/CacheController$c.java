package com.inmobi.commons.cache;

import com.inmobi.commons.internal.Log;

import java.util.Map;

import org.json.JSONException;

final class CacheController$c
        implements CacheController.Committer {
    CacheController$c(String paramString) {
    }

    public void onCommit() {
        try {
            ProductCacheConfig localProductCacheConfig = (ProductCacheConfig) CacheController.b().get(this.a);
            if (localProductCacheConfig == null) {
                return;
            }
            LocalCache.addToCache(this.a, localProductCacheConfig.toJSON());
            return;
        } catch (JSONException localJSONException) {
            Log.internal("[InMobi]-4.5.1", "Unable to add json to persistent memory", localJSONException);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/inmobi/commons/cache/CacheController$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */