package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.aj;
import com.google.android.gms.drive.metadata.a;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class MetadataBundle
        implements SafeParcelable {
    public static final Parcelable.Creator<MetadataBundle> CREATOR = new j();
    final int a;
    final Bundle b;

    MetadataBundle(int paramInt, Bundle paramBundle) {
        this.a = paramInt;
        this.b = ((Bundle) ag.a(paramBundle));
        this.b.setClassLoader(getClass().getClassLoader());
        paramBundle = new ArrayList();
        Object localObject = this.b.keySet().iterator();
        while (((Iterator) localObject).hasNext()) {
            String str = (String) ((Iterator) localObject).next();
            if (g.a(str) == null) {
                paramBundle.add(str);
                aj.a("MetadataBundle", "Ignored unknown metadata field in bundle: " + str);
            }
        }
        paramBundle = paramBundle.iterator();
        while (paramBundle.hasNext()) {
            localObject = (String) paramBundle.next();
            this.b.remove((String) localObject);
        }
    }

    public <T> T a(a<T> parama) {
        return (T) parama.a(this.b);
    }

    public Set<a<?>> a() {
        HashSet localHashSet = new HashSet();
        Iterator localIterator = this.b.keySet().iterator();
        while (localIterator.hasNext()) {
            localHashSet.add(g.a((String) localIterator.next()));
        }
        return localHashSet;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
            return true;
        }
        if (!(paramObject instanceof MetadataBundle)) {
            return false;
        }
        paramObject = (MetadataBundle) paramObject;
        Object localObject = this.b.keySet();
        if (!((Set) localObject).equals(((MetadataBundle) paramObject).b.keySet())) {
            return false;
        }
        localObject = ((Set) localObject).iterator();
        while (((Iterator) localObject).hasNext()) {
            String str = (String) ((Iterator) localObject).next();
            if (!ad.a(this.b.get(str), ((MetadataBundle) paramObject).b.get(str))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Iterator localIterator = this.b.keySet().iterator();
        String str;
        for (int i = 1; localIterator.hasNext(); i = this.b.get(str).hashCode() + i * 31) {
            str = (String) localIterator.next();
        }
        return i;
    }

    public String toString() {
        return "MetadataBundle [values=" + this.b + "]";
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        j.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/MetadataBundle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */