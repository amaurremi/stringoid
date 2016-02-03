package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.a;

import java.util.Collection;

public abstract class h<T extends Parcelable>
        extends a<T> {
    public h(String paramString, int paramInt) {
        super(paramString, paramInt);
    }

    public h(String paramString, Collection<String> paramCollection, int paramInt) {
        super(paramString, paramCollection, paramInt);
    }

    protected void a(Bundle paramBundle, T paramT) {
        paramBundle.putParcelable(getName(), paramT);
    }

    protected T k(Bundle paramBundle) {
        return paramBundle.getParcelable(getName());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */