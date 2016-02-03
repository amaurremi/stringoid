package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;

import java.util.ArrayList;

public class aa
        implements Parcelable.Creator<CheckResourceIdsExistRequest> {
    static void a(CheckResourceIdsExistRequest paramCheckResourceIdsExistRequest, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramCheckResourceIdsExistRequest.a());
        c.b(paramParcel, 2, paramCheckResourceIdsExistRequest.b(), false);
        c.a(paramParcel, paramInt);
    }

    public CheckResourceIdsExistRequest a(Parcel paramParcel) {
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
        return new CheckResourceIdsExistRequest(i, localArrayList);
    }

    public CheckResourceIdsExistRequest[] a(int paramInt) {
        return new CheckResourceIdsExistRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/drive/internal/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */