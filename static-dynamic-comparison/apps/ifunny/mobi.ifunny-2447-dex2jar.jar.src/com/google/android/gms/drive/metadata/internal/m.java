package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.drive.metadata.g;

import java.util.Collection;
import java.util.Collections;

public class m
        extends g<String> {
    public m(String paramString, int paramInt) {
        super(paramString, Collections.singleton(paramString), Collections.emptySet(), paramInt);
    }

    protected Collection<String> c(Bundle paramBundle) {
        return paramBundle.getStringArrayList(a());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */