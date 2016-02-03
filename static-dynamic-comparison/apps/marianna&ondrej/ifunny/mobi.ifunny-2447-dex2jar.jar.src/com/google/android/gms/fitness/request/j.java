package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;

import java.util.ArrayList;

public class j
        implements Parcelable.Creator<DataDeleteRequest> {
    static void a(DataDeleteRequest paramDataDeleteRequest, Parcel paramParcel, int paramInt) {
        paramInt = c.a(paramParcel);
        c.a(paramParcel, 1, paramDataDeleteRequest.a());
        c.a(paramParcel, 1000, paramDataDeleteRequest.h());
        c.a(paramParcel, 2, paramDataDeleteRequest.b());
        c.c(paramParcel, 3, paramDataDeleteRequest.c(), false);
        c.c(paramParcel, 4, paramDataDeleteRequest.d(), false);
        c.c(paramParcel, 5, paramDataDeleteRequest.e(), false);
        c.a(paramParcel, 6, paramDataDeleteRequest.f());
        c.a(paramParcel, 7, paramDataDeleteRequest.g());
        c.a(paramParcel, paramInt);
    }

    public DataDeleteRequest a(Parcel paramParcel) {
        long l1 = 0L;
        ArrayList localArrayList1 = null;
        boolean bool1 = false;
        int j = a.b(paramParcel);
        boolean bool2 = false;
        ArrayList localArrayList2 = null;
        ArrayList localArrayList3 = null;
        long l2 = 0L;
        int i = 0;
        while (paramParcel.dataPosition() < j) {
            int k = a.a(paramParcel);
            switch (a.a(k)) {
                default:
                    a.b(paramParcel, k);
                    break;
                case 1:
                    l2 = a.i(paramParcel, k);
                    break;
                case 1000:
                    i = a.g(paramParcel, k);
                    break;
                case 2:
                    l1 = a.i(paramParcel, k);
                    break;
                case 3:
                    localArrayList3 = a.c(paramParcel, k, DataSource.CREATOR);
                    break;
                case 4:
                    localArrayList2 = a.c(paramParcel, k, DataType.CREATOR);
                    break;
                case 5:
                    localArrayList1 = a.c(paramParcel, k, Session.CREATOR);
                    break;
                case 6:
                    bool2 = a.c(paramParcel, k);
                    break;
                case 7:
                    bool1 = a.c(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new DataDeleteRequest(i, l2, l1, localArrayList3, localArrayList2, localArrayList1, bool2, bool1);
    }

    public DataDeleteRequest[] a(int paramInt) {
        return new DataDeleteRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/request/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */