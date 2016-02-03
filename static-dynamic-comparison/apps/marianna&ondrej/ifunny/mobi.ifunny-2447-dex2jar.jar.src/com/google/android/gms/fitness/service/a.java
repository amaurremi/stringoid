package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.fitness.data.DataSource;

public class a
        implements Parcelable.Creator<FitnessSensorServiceRequest> {
    static void a(FitnessSensorServiceRequest paramFitnessSensorServiceRequest, Parcel paramParcel, int paramInt) {
        int i = c.a(paramParcel);
        c.a(paramParcel, 1, paramFitnessSensorServiceRequest.a(), paramInt, false);
        c.a(paramParcel, 1000, paramFitnessSensorServiceRequest.d());
        c.a(paramParcel, 2, paramFitnessSensorServiceRequest.e(), false);
        c.a(paramParcel, 3, paramFitnessSensorServiceRequest.b());
        c.a(paramParcel, 4, paramFitnessSensorServiceRequest.c());
        c.a(paramParcel, i);
    }

    public FitnessSensorServiceRequest a(Parcel paramParcel) {
        long l1 = 0L;
        IBinder localIBinder = null;
        int j = com.google.android.gms.common.internal.safeparcel.a.b(paramParcel);
        int i = 0;
        long l2 = 0L;
        DataSource localDataSource = null;
        while (paramParcel.dataPosition() < j) {
            int k = com.google.android.gms.common.internal.safeparcel.a.a(paramParcel);
            switch (com.google.android.gms.common.internal.safeparcel.a.a(k)) {
                default:
                    com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
                    break;
                case 1:
                    localDataSource = (DataSource) com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, DataSource.CREATOR);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
                    break;
                case 2:
                    localIBinder = com.google.android.gms.common.internal.safeparcel.a.p(paramParcel, k);
                    break;
                case 3:
                    l2 = com.google.android.gms.common.internal.safeparcel.a.i(paramParcel, k);
                    break;
                case 4:
                    l1 = com.google.android.gms.common.internal.safeparcel.a.i(paramParcel, k);
            }
        }
        if (paramParcel.dataPosition() != j) {
            throw new b("Overread allowed size end=" + j, paramParcel);
        }
        return new FitnessSensorServiceRequest(i, localDataSource, localIBinder, l2, l1);
    }

    public FitnessSensorServiceRequest[] a(int paramInt) {
        return new FitnessSensorServiceRequest[paramInt];
    }
}


/* Location:              /Users/amaurremi/uw/stringoid stuff/static vs dynamic/ifunny/mobi.ifunny-2447-dex2jar.jar!/com/google/android/gms/fitness/service/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */