package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.b;

import java.util.ArrayList;
import java.util.Collection;

public class g<T extends Parcelable>
        extends b<T> {
    public g(String paramString, int paramInt) {
        super(paramString, paramInt);
    }

    protected void a(Bundle paramBundle, Collection<T> paramCollection) {
        paramBundle.putParcelableArrayList(getName(), new ArrayList(paramCollection));
    }

    protected Collection<T> j(Bundle paramBundle) {
        return paramBundle.getParcelableArrayList(getName());
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */