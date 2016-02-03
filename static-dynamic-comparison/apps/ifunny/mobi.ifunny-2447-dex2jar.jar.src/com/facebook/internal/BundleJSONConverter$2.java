package com.facebook.internal;

import android.os.Bundle;
import org.json.JSONObject;

final class BundleJSONConverter$2
        implements BundleJSONConverter.Setter {
    public void setOnBundle(Bundle paramBundle, String paramString, Object paramObject) {
        paramBundle.putInt(paramString, ((Integer) paramObject).intValue());
    }

    public void setOnJSON(JSONObject paramJSONObject, String paramString, Object paramObject) {
        paramJSONObject.put(paramString, paramObject);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/BundleJSONConverter$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */