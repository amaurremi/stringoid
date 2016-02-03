package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.ArrayList;

public class o
        implements Parcelable.Creator<OnResourceIdSetResponse> {
    static void a(OnResourceIdSetResponse paramOnResourceIdSetResponse, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramOnResourceIdSetResponse.a());
        c.b(paramParcel, 2, paramOnResourceIdSetResponse.b(), false);
        c.a(paramParcel, paramInt);
    }

    public OnResourceIdSetResponse a(Parcel paramParcel) {
        int j = a.b(paramParcel);
        int i = 0;
        ArrayList localArrayList = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    localArrayList = a.C(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new OnResourceIdSetResponse(i, localArrayList);
    }

    public OnResourceIdSetResponse[] a(int paramInt) {
        return new OnResourceIdSetResponse[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */