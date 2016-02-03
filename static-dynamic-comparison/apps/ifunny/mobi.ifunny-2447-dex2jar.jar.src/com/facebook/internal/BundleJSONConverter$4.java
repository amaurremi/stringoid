package com.facebook.internal;

import android.os.Bundle;
import org.json.JSONObject;

final class BundleJSONConverter$4
        implements BundleJSONConverter.Setter {
    public void setOnBundle(Bundle paramBundle, String paramString, Object paramObject) {
        paramBundle.putDouble(paramString, ((Double) paramObject).doubleValue());
    }

    public void setOnJSON(JSONObject paramJSONObject, String paramString, Object paramObject) {
        paramJSONObject.put(paramString, paramObject);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/facebook/internal/BundleJSONConverter$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */