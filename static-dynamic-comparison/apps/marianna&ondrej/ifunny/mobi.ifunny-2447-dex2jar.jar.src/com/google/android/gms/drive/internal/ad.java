package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

public class ad
        implements Parcelable.Creator<CreateContentsRequest> {
    static void a(CreateContentsRequest paramCreateContentsRequest, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramCreateContentsRequest.a);
        c.a(paramParcel, 2, paramCreateContentsRequest.b);
        c.a(paramParcel, paramInt);
    }

    public CreateContentsRequest a(Parcel paramParcel) {
        int k = a.b(paramParcel);
        int i = 0;
        int j = 536870912;
        while (paramParcel.dataPosition() < k) {
            int m = a.a(paramParcel);
            switch (a.a(m)) {
                default:
                    a.b(paramParcel, m);
                    break;
                case 1:
                    i = a.g(paramParcel, m);
                    break;
                case 2:
                    j = a.g(paramParcel, m);
            }
        }
        if (paramParcel.dataPosition() != k) {
            throw new b("Overread allowed size end=" + k, paramParcel);
        }
        return new CreateContentsRequest(i, j);
    }

    public CreateContentsRequest[] a(int paramInt) {
        return new CreateContentsRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */