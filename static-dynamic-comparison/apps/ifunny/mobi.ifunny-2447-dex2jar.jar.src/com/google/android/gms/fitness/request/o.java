package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.fitness.data.DataType;

import java.util.ArrayList;

public class o
        implements Parcelable.Creator<DataSourcesRequest> {
    static void a(DataSourcesRequest paramDataSourcesRequest, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.c(paramParcel, 1, paramDataSourcesRequest.a(), false);
        c.a(paramParcel, 1000, paramDataSourcesRequest.c());
        c.a(paramParcel, 2, paramDataSourcesRequest.d(), false);
        c.a(paramParcel, 3, paramDataSourcesRequest.b());
        c.a(paramParcel, paramInt);
    }

    public DataSourcesRequest a(Parcel paramParcel) {
        ArrayList localArrayList2 = null;
        boolean bool = false;
        int j = a.b(paramParcel);
        ArrayList localArrayList1 = null;
        int i = 0;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    localArrayList1 = a.c(paramParcel, k, DataType.CREATOR);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    localArrayList2 = a.B(paramParcel, k);
                    break;
                case 3:
                    bool = a.c(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new DataSourcesRequest(i, localArrayList1, localArrayList2, bool);
    }

    public DataSourcesRequest[] a(int paramInt) {
        return new DataSourcesRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */