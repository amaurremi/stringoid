package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.fitness.data.DataType;

public class d
        implements Parcelable.Creator<DataTypeResult> {
    static void a(DataTypeResult paramDataTypeResult, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramDataTypeResult.a(), paramInt, false);
        c.a(paramParcel, 1000, paramDataTypeResult.c());
        c.a(paramParcel, 3, paramDataTypeResult.b(), paramInt, false);
        c.a(paramParcel, i);
    }

    public DataTypeResult a(Parcel paramParcel) {
        DataType localDataType = null;
        int j = a.b(paramParcel);
        int i = 0;
        Status localStatus = null;
        if (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
            }
            for (; ; ) {
                break;
                localStatus = (Status) a.a(paramParcel, k, Status.CREATOR);
                continue;
                i = a.g(paramParcel, k);
                continue;
                localDataType = (DataType) a.a(paramParcel, k, DataType.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new DataTypeResult(i, localStatus, localDataType);
    }

    public DataTypeResult[] a(int paramInt) {
        return new DataTypeResult[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/result/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */