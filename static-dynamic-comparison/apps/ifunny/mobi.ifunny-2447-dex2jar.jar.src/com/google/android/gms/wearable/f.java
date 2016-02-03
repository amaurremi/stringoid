package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class f
        implements Parcelable.Creator<PutDataRequest> {
    static void a(PutDataRequest paramPutDataRequest, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramPutDataRequest.a);
        c.a(paramParcel, 2, paramPutDataRequest.a(), paramInt, false);
        c.a(paramParcel, 4, paramPutDataRequest.c(), false);
        c.a(paramParcel, 5, paramPutDataRequest.b(), false);
        c.a(paramParcel, i);
    }

    public PutDataRequest a(Parcel paramParcel) {
        byte[] arrayOfByte = null;
        int j = a.b(paramParcel);
        int i = 0;
        Object localObject2 = null;
        Object localObject1 = null;
        if (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            Object localObject3;
            switch (a.a(k)) {
                case 3:
                default:
                    a.b(paramParcel, k);
                    localObject3 = localObject2;
                    localObject2 = localObject1;
                    localObject1 = localObject3;
            }
            for (; ; ) {
                localObject3 = localObject2;
                localObject2 = localObject1;
                localObject1 = localObject3;
                break;
                i = a.g(paramParcel, k);
                localObject3 = localObject1;
                localObject1 = localObject2;
                localObject2 = localObject3;
                continue;
                localObject3 = (Uri) a.a(paramParcel, k, Uri.CREATOR);
                localObject1 = localObject2;
                localObject2 = localObject3;
                continue;
                localObject3 = a.q(paramParcel, k);
                localObject2 = localObject1;
                localObject1 = localObject3;
                continue;
                arrayOfByte = a.r(paramParcel, k);
                localObject3 = localObject1;
                localObject1 = localObject2;
                localObject2 = localObject3;
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new PutDataRequest(i, (Uri) localObject1, (Bundle) localObject2, arrayOfByte);
    }

    public PutDataRequest[] a(int paramInt) {
        return new PutDataRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wearable/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */