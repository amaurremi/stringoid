package com.google.android.gms.plus;

import android.text.TextUtils;
import android.util.Log;

public final class h {
    protected static boolean a(String paramString) {
        if (TextUtils.isEmpty(paramString)) {
            Log.e("GooglePlusPlatform", "The provided deep-link ID is empty.");
            return false;
        }
        if (paramString.contains(" ")) {
            Log.e("GooglePlusPlatform", "Spaces are not allowed in deep-link IDs.");
            return false;
        }
        return true;
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/plus/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */