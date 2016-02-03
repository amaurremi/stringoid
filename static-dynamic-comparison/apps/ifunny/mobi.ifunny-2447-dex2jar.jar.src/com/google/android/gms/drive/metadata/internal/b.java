package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.drive.metadata.CustomPropertyKey;

import java.util.HashMap;
import java.util.Map;

public class b {
    private final Map<CustomPropertyKey, CustomProperty> a = new HashMap();

    public AppVisibleCustomProperties a() {
        return new AppVisibleCustomProperties(this.a.values(), null);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */