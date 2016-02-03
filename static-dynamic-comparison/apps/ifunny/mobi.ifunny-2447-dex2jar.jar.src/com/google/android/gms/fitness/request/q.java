package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.fitness.data.Field;

import java.util.ArrayList;

public class q
        implements Parcelable.Creator<DataTypeCreateRequest> {
    static void a(DataTypeCreateRequest paramDataTypeCreateRequest, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramDataTypeCreateRequest.a(), false);
        c.a(paramParcel, 1000, paramDataTypeCreateRequest.c());
        c.c(paramParcel, 2, paramDataTypeCreateRequest.b(), false);
        c.a(paramParcel, paramInt);
    }

    public DataTypeCreateRequest a(Parcel paramParcel) {
        ArrayList localArrayList = null;
        int j = a.b(paramParcel);
        int i = 0;
        String str = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    str = a.o(paramParcel, k);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    localArrayList = a.c(paramParcel, k, Field.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new DataTypeCreateRequest(i, str, localArrayList);
    }

    public DataTypeCreateRequest[] a(int paramInt) {
        return new DataTypeCreateRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */