package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.a;
import com.google.android.gms.wearable.b;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class m
        implements SafeParcelable, a {
    public static final Parcelable.Creator<m> CREATOR = new s();
    final int a;
    private final Uri b;
    private final Map<String, b> c;
    private byte[] d;

    m(int paramInt, Uri paramUri, Bundle paramBundle, byte[] paramArrayOfByte) {
        this.a = paramInt;
        this.b = paramUri;
        paramUri = new HashMap();
        paramBundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        Iterator localIterator = paramBundle.keySet().iterator();
        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();
            paramUri.put(str, (DataItemAssetParcelable) paramBundle.getParcelable(str));
        }
        this.c = paramUri;
        this.d = paramArrayOfByte;
    }

    public String a(boolean paramBoolean) {
        StringBuilder localStringBuilder = new StringBuilder("DataItemParcelable[");
        localStringBuilder.append("@");
        localStringBuilder.append(Integer.toHexString(hashCode()));
        Object localObject2 = new StringBuilder().append(",dataSz=");
        if (this.d == null) {
        }
        for (Object localObject1 = "null"; ; localObject1 = Integer.valueOf(this.d.length)) {
            localStringBuilder.append(localObject1);
            localStringBuilder.append(", numAssets=" + this.c.size());
            localStringBuilder.append(", uri=" + this.b);
            if (paramBoolean) {
                break;
            }
            localStringBuilder.append("]");
            return localStringBuilder.toString();
        }
        localStringBuilder.append("]\n  assets: ");
        localObject1 = this.c.keySet().iterator();
        while (((Iterator) localObject1).hasNext()) {
            localObject2 = (String) ((Iterator) localObject1).next();
            localStringBuilder.append("\n    " + (String) localObject2 + ": " + this.c.get(localObject2));
        }
        localStringBuilder.append("\n  ]");
        return localStringBuilder.toString();
    }

    public m b() {
        return this;
    }

    public Uri c() {
        return this.b;
    }

    public byte[] d() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public Bundle e() {
        Bundle localBundle = new Bundle();
        localBundle.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        Iterator localIterator = this.c.entrySet().iterator();
        while (localIterator.hasNext()) {
            Map.Entry localEntry = (Map.Entry) localIterator.next();
            localBundle.putParcelable((String) localEntry.getKey(), new DataItemAssetParcelable((b) localEntry.getValue()));
        }
        return localBundle;
    }

    public String toString() {
        return a(Log.isLoggable("DataItem", 3));
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        s.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wearable/internal/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */