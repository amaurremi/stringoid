package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class s
        implements Parcelable.Creator<m> {
    static void a(m paramm, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramm.a);
        c.a(paramParcel, 2, paramm.c(), paramInt, false);
        c.a(paramParcel, 4, paramm.e(), false);
        c.a(paramParcel, 5, paramm.d(), false);
        c.a(paramParcel, i);
    }

    public m a(Parcel paramParcel) {
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
        return new m(i, (Uri) localObject1, (Bundle) localObject2, arrayOfByte);
    }

    public m[] a(int paramInt) {
        return new m[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/wearable/internal/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */