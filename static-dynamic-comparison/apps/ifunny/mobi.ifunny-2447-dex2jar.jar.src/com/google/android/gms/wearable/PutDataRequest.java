package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.DataItemAssetParcelable;

import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class PutDataRequest
        implements SafeParcelable {
    public static final Parcelable.Creator<PutDataRequest> CREATOR = new f();
    private static final Random b = new SecureRandom();
    final int a;
    private final Uri c;
    private final Bundle d;
    private byte[] e;

    PutDataRequest(int paramInt, Uri paramUri, Bundle paramBundle, byte[] paramArrayOfByte) {
        this.a = paramInt;
        this.c = paramUri;
        this.d = paramBundle;
        this.d.setClassLoader(DataItemAssetParcelable.class.getClassLoader());
        this.e = paramArrayOfByte;
    }

    public Uri a() {
        return this.c;
    }

    public String a(boolean paramBoolean) {
        StringBuilder localStringBuilder = new StringBuilder("PutDataRequest[");
        Object localObject2 = new StringBuilder().append("dataSz=");
        if (this.e == null) {
        }
        for (Object localObject1 = "null"; ; localObject1 = Integer.valueOf(this.e.length)) {
            localStringBuilder.append(localObject1);
            localStringBuilder.append(", numAssets=" + this.d.size());
            localStringBuilder.append(", uri=" + this.c);
            if (paramBoolean) {
                break;
            }
            localStringBuilder.append("]");
            return localStringBuilder.toString();
        }
        localStringBuilder.append("]\n  assets: ");
        localObject1 = this.d.keySet().iterator();
        while (((Iterator) localObject1).hasNext()) {
            localObject2 = (String) ((Iterator) localObject1).next();
            localStringBuilder.append("\n    " + (String) localObject2 + ": " + this.d.getParcelable((String) localObject2));
        }
        localStringBuilder.append("\n  ]");
        return localStringBuilder.toString();
    }

    public byte[] b() {
        return this.e;
    }

    public Bundle c() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return a(Log.isLoggable("DataMap", 3));
    }

    public void writeToParcel(Parcel paramParcel, int paramInt) {
        f.a(this, paramParcel, paramInt);
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wearable/PutDataRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */