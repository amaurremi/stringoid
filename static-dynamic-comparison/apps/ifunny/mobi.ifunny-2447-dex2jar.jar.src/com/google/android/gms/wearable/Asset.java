package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ad;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Asset
        implements SafeParcelable {
    public static final Parcelable.Creator<Asset> CREATOR = new d();
    final int a;
    public ParcelFileDescriptor b;
    public Uri c;
    private byte[] d;
    private String e;

    Asset(int paramInt, byte[] paramArrayOfByte, String paramString, ParcelFileDescriptor paramParcelFileDescriptor, Uri paramUri) {
        this.a = paramInt;
        this.d = paramArrayOfByte;
        this.e = paramString;
        this.b = paramParcelFileDescriptor;
        this.c = paramUri;
    }

    public byte[] a() {
        return this.d;
    }

    public String b() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object paramObject) {
        if (this == paramObject) {
        }
        do {
            return true;
            if (!(paramObject instanceof Asset)) {
                return false;
            }
            paramObject = (Asset) paramObject;
        }
        while ((ad.a(this.d, ((Asset) paramObject).d)) && (ad.a(this.e, ((Asset) paramObject).e)) && (ad.a(this.b, ((Asset) paramObject).b)) && (ad.a(this.c, ((Asset) paramObject).c)));
        return false;
    }

    public int hashCode() {
        return ad.a(new Object[]{this.d, this.e, this.b, this.c});
    }

    public String toString() {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Asset[@");
        localStringBuilder.append(Integer.toHexString(hashCode()));
        if (this.e == null) {
            localStringBuilder.append(", nodigest");
        }
        for (; ; ) {
            if (this.d != null) {
                localStringBuilder.append(", size=");
                localStringBuilder.append(this.d.length);
            }
            if (this.b != null) {
                localStringBuilder.append(", fd=");
                localStringBuilder.append(this.b);
            }
            if (this.c != null) {
                localStringBuilder.append(", uri=");
                localStringBuilder.append(this.c);
            }
            localStringBuilder.append("]");
            return localStringBuilder.toString();
            localStringBuilder.append(", ");
            localStringBuilder.append(this.e);
        }
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        d.a(this, paramParcel, paramInt | 0x1);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wearable/Asset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */