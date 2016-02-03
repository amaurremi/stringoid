package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class AppVisibleCustomProperties
        implements SafeParcelable, Iterable<CustomProperty> {
    public static final Parcelable.Creator<AppVisibleCustomProperties> CREATOR = new c();
    public static final AppVisibleCustomProperties a = new b().a();
    final int b;
    final List<CustomProperty> c;

    AppVisibleCustomProperties(int paramInt, Collection<CustomProperty> paramCollection) {
        this.b = paramInt;
        ag.a(paramCollection);
        this.c = new ArrayList(paramCollection);
    }

    private AppVisibleCustomProperties(Collection<CustomProperty> paramCollection) {
        this(1, paramCollection);
    }

    public int describeContents() {
        return 0;
    }

    public Iterator<CustomProperty> iterator() {
        return this.c.iterator();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        c.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/AppVisibleCustomProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */