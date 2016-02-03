package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.fitness.data.DataSet;

public class k
        implements Parcelable.Creator<DataInsertRequest> {
    static void a(DataInsertRequest paramDataInsertRequest, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramDataInsertRequest.a(), paramInt, false);
        c.a(paramParcel, 1000, paramDataInsertRequest.b());
        c.a(paramParcel, i);
    }

    public DataInsertRequest a(Parcel paramParcel) {
        int j = a.b(paramParcel);
        int i = 0;
        DataSet localDataSet = null;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    localDataSet = (DataSet) a.a(paramParcel, k, DataSet.CREATOR);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new DataInsertRequest(i, localDataSet);
    }

    public DataInsertRequest[] a(int paramInt) {
        return new DataInsertRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */