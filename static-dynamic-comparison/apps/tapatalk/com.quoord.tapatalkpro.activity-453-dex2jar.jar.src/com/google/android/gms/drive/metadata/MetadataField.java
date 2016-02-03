package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

import java.util.Collection;

public abstract interface MetadataField<T> {
    public abstract T a(DataHolder paramDataHolder, int paramInt1, int paramInt2);

    public abstract void a(DataHolder paramDataHolder, MetadataBundle paramMetadataBundle, int paramInt1, int paramInt2);

    public abstract void a(T paramT, Bundle paramBundle);

    public abstract T d(Bundle paramBundle);

    public abstract Collection<String> fR();

    public abstract String getName();
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/tapatalk/com.quoord.tapatalkpro.activity-453-dex2jar.jar!/com/google/android/gms/drive/metadata/MetadataField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */