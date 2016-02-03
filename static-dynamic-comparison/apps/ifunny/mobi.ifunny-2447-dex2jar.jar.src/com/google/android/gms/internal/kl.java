package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.ag;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class kl
        implements cp {
    kl(kk paramkk, q paramq, ma paramma) {
    }

    public void a(mz parammz, Map<String, String> paramMap) {
        this.a.b("/nativeAdPreProcess");
        try {
            parammz = (String) paramMap.get("success");
            if (!TextUtils.isEmpty(parammz)) {
                this.b.a(new JSONObject(parammz).getJSONArray("ads").getJSONObject(0));
                return;
            }
        } catch (JSONException parammz) {
            mx.b("Malformed native JSON response.", parammz);
            this.c.a(0);
            ag.a(this.c.b(), "Unable to set the ad state error!");
            this.b.a(null);
        }
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/internal/kl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */