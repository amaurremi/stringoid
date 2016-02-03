package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;

import java.util.ArrayList;

public class m
        implements Parcelable.Creator<DataReadRequest> {
    static void a(DataReadRequest paramDataReadRequest, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.c(paramParcel, 1, paramDataReadRequest.a(), false);
        c.a(paramParcel, 1000, paramDataReadRequest.n());
        c.c(paramParcel, 2, paramDataReadRequest.b(), false);
        c.a(paramParcel, 3, paramDataReadRequest.c());
        c.a(paramParcel, 4, paramDataReadRequest.d());
        c.c(paramParcel, 5, paramDataReadRequest.e(), false);
        c.c(paramParcel, 6, paramDataReadRequest.f(), false);
        c.a(paramParcel, 7, paramDataReadRequest.g());
        c.a(paramParcel, 8, paramDataReadRequest.h());
        c.a(paramParcel, 9, paramDataReadRequest.i(), paramInt, false);
        c.a(paramParcel, 10, paramDataReadRequest.j());
        c.a(paramParcel, 11, paramDataReadRequest.k());
        c.a(paramParcel, 12, paramDataReadRequest.m());
        c.a(paramParcel, 13, paramDataReadRequest.l());
        c.a(paramParcel, i);
    }

    public DataReadRequest a(Parcel paramParcel) {
        int m = a.b(paramParcel);
        int k = 0;
        ArrayList localArrayList4 = null;
        ArrayList localArrayList3 = null;
        long l3 = 0L;
        long l2 = 0L;
        ArrayList localArrayList2 = null;
        ArrayList localArrayList1 = null;
        int j = 0;
        long l1 = 0L;
        DataSource localDataSource = null;
        int i = 0;
        boolean bool3 = false;
        boolean bool2 = false;
        boolean bool1 = false;
        while (paramParcel.dataPosition() < m) {
            int n = a.a(paramParcel);
            switch (a.a(n)) {
                default:
                    a.b(paramParcel, n);
                    break;
                case 1:
                    localArrayList4 = a.c(paramParcel, n, DataType.CREATOR);
                    break;
                case 1000:
                    k = a.g(paramParcel, n);
                    break;
                case 2:
                    localArrayList3 = a.c(paramParcel, n, DataSource.CREATOR);
                    break;
                case 3:
                    l3 = a.i(paramParcel, n);
                    break;
                case 4:
                    l2 = a.i(paramParcel, n);
                    break;
                case 5:
                    localArrayList2 = a.c(paramParcel, n, DataType.CREATOR);
                    break;
                case 6:
                    localArrayList1 = a.c(paramParcel, n, DataSource.CREATOR);
                    break;
                case 7:
                    j = a.g(paramParcel, n);
                    break;
                case 8:
                    l1 = a.i(paramParcel, n);
                    break;
                case 9:
                    localDataSource = (DataSource) a.a(paramParcel, n, DataSource.CREATOR);
                    break;
                case 10:
                    i = a.g(paramParcel, n);
                    break;
                case 11:
                    bool3 = a.c(paramParcel, n);
                    break;
                case 12:
                    bool2 = a.c(paramParcel, n);
                    break;
                case 13:
                    bool1 = a.c(paramParcel, n);
            }
        }
        if (paramParcel.dataPosition() != m) {
            throw new b("Overread allowed size end=" + m, paramParcel);
        }
        return new DataReadRequest(k, localArrayList4, localArrayList3, l3, l2, localArrayList2, localArrayList1, j, l1, localDataSource, i, bool3, bool2, bool1);
    }

    public DataReadRequest[] a(int paramInt) {
        return new DataReadRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */