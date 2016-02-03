package com.mopub.common;

import android.content.Context;
import android.content.SharedPreferences;

public final class SharedPreferencesHelper {
    public static final String PREFERENCE_NAME = "mopubSettings";

    public static SharedPreferences getSharedPreferences(Context paramContext) {
        return paramContext.getSharedPreferences("mopubSettings", 0);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/mopub/common/SharedPreferencesHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */