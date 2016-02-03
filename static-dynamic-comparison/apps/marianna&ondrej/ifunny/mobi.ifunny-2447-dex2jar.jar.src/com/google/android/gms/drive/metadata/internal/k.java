package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.g;

import java.util.Collection;
import java.util.Collections;

public class k<T extends Parcelable>
        extends g<T> {
    public k(String paramString, int paramInt) {
        super(paramString, Collections.emptySet(), Collections.singleton(paramString), paramInt);
    }

    protected Collection<T> c(Bundle paramBundle) {
        return paramBundle.getParcelableArrayList(a());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */