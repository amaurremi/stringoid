package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ag;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.b;

public class DataItemAssetParcelable
        implements SafeParcelable, b {
    public static final Parcelable.Creator<DataItemAssetParcelable> CREATOR = new q();
    final int a;
    private final String b;
    private final String c;

    DataItemAssetParcelable(int paramInt, String paramString1, String paramString2) {
        this.a = paramInt;
        this.b = paramString1;
        this.c = paramString2;
    }

    public DataItemAssetParcelable(b paramb) {
        this.a = 1;
        this.b = ((String) ag.a(paramb.b()));
        this.c = ((String) ag.a(paramb.c()));
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public b d() {
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("DataItemAssetParcelable[");
        localStringBuilder.append("@");
        localStringBuilder.append(Integer.toHexString(hashCode()));
        if (this.b == null) {
            localStringBuilder.append(",noid");
        }
        for (; ; ) {
            localStringBuilder.append(", key=");
            localStringBuilder.append(this.c);
            localStringBuilder.append("]");
            return localStringBuilder.toString();
            localStringBuilder.append(",");
            localStringBuilder.append(this.b);
        }
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        q.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wearable/internal/DataItemAssetParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */