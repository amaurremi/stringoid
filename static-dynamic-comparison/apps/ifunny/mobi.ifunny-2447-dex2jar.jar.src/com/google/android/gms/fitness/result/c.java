package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.DataSource;

import java.util.ArrayList;

public class c
        implements Parcelable.Creator<DataSourcesResult> {
    static void a(DataSourcesResult paramDataSourcesResult, Parcel paramParcel, int paramInt) {
        int i = com.google.android.gms.common.internal.safeparcel.c.a(paramParcel);
        com.google.android.gms.common.internal.safeparcel.c.c(paramParcel, 1, paramDataSourcesResult.b(), false);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 1000, paramDataSourcesResult.c());
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, 2, paramDataSourcesResult.a(), paramInt, false);
        com.google.android.gms.common.internal.safeparcel.c.a(paramParcel, i);
    }

    public DataSourcesResult a(Parcel paramParcel) {
        Status localStatus = null;
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
                    localArrayList = a.c(paramParcel, k, DataSource.CREATOR);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    localStatus = (Status) a.a(paramParcel, k, Status.CREATOR);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new DataSourcesResult(i, localArrayList, localStatus);
    }

    public DataSourcesResult[] a(int paramInt) {
        return new DataSourcesResult[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/result/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */