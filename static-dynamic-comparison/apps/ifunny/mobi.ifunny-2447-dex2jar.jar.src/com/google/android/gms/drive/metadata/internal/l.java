package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.f;

import java.util.Collection;

public abstract class l<T extends Parcelable>
        extends f<T> {
    public l(String paramString, Collection<String> paramCollection1, Collection<String> paramCollection2, int paramInt) {
        super(paramString, paramCollection1, paramCollection2, paramInt);
    }

    protected T c(Bundle paramBundle) {
        return paramBundle.getParcelable(a());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */